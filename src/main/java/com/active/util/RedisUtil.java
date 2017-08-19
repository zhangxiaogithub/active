package com.active.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public final class RedisUtil {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static RedisUtil redisUtil;

	private static boolean redisEnable = true;

	@PostConstruct
	public void init() {
		redisUtil = this;
	}

	public static RedisTemplate<String, Object> getRedisTemplate() {
		return redisUtil.redisTemplate;
	}

	/**
	 * 判断缓存中是否有指定的key值
	 * 
	 * @param key
	 * @return
	 */
	public static boolean hasKey(String key) {
		return redisUtil.redisTemplate.hasKey(key);
	}

	/**
	 * 如果指定key不存在，则将value对象写入缓存
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            失效时间(秒)
	 * @return
	 */
	public static boolean setnx(String key, Object value, long seconds) {
		if (!redisEnable) {
			return false;
		}
		Boolean result = false;
		try {
			ValueOperations<String, Object> vo = redisUtil.redisTemplate.opsForValue();
			result = vo.setIfAbsent(key, value);
			if (result && seconds > 0) {
				redisUtil.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			return false;
		}
		return result;
	}

	/**
	 * 根据key 获取和设置对象, 并更新失效时间
	 * 
	 * @param key
	 * @param value
	 * @param clazz
	 * @param expireSeconds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getSet(String key, T value, Class<T> clazz, long expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		try {
			BoundValueOperations<String, Object> bvo = redisUtil.redisTemplate.boundValueOps(key);
			T obj = (T) bvo.getAndSet(value);
			if (expireSeconds > 0 && obj != null) {
				bvo.expire(expireSeconds, TimeUnit.SECONDS);
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据key 获取和设置对象, 并更新失效时间
	 * 
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getSet(String key, T value, Class<T> clazz) {
		if (!redisEnable) {
			return null;
		}
		try {
			BoundValueOperations<String, Object> bvo = redisUtil.redisTemplate.boundValueOps(key);
			T obj = (T) bvo.getAndSet(value);
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将value对象写入缓存
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            失效时间(秒)
	 * @return
	 */
	public static boolean set(String key, Object value, long seconds) {
		if (!redisEnable) {
			return false;
		}
		try {
			ValueOperations<String, Object> vo = redisUtil.redisTemplate.opsForValue();
			if (seconds > 0) {
				vo.set(key, value, seconds, TimeUnit.SECONDS);
			} else {
				vo.set(key, value);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 向缓存中设置字符串内容 默认10分钟
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(String key, Object value) {
		if (!redisEnable) {
			return false;
		}
		return set(key, value, 600);
	}

	/**
	 * 删除缓存中的对象，根据key
	 * 
	 * @param key
	 * @return
	 */
	public static boolean remove(String key) {
		if (!redisEnable) {
			return true;
		}
		try {
			redisUtil.redisTemplate.delete(key);
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * 批量删除缓存中的对象，根据keys
	 * 
	 * @param key
	 * @return
	 */
	public static boolean remove(Collection<String> keys) {
		if (!redisEnable) {
			return true;
		}
		try {
			redisUtil.redisTemplate.delete(keys);
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * 批量删除缓存对象，根据某前缀开头的key （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
	 * 
	 * @param prex
	 * @return
	 */
	public static boolean removeByPrex(String... prex) {
		if (!redisEnable) {
			return true;
		}
		try {
			for (String kp : prex) {
				redisUtil.redisTemplate.delete(redisUtil.redisTemplate.keys(kp + "*"));
			}
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * 根据key 获取内容
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		try {
			return redisUtil.redisTemplate.boundValueOps(key).get();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据key 获取对象, 并更新失效时间
	 * 
	 * @param key
	 * @param expireSeconds
	 * @return
	 */
	public static Object get(String key, int expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		try {
			BoundValueOperations<String, Object> bvo = redisUtil.redisTemplate.boundValueOps(key);
			Object obj = bvo.get();
			if (expireSeconds > 0 && obj != null) {
				bvo.expire(expireSeconds, TimeUnit.SECONDS);
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据key 获取对象, 并更新失效时间
	 * 
	 * @param key
	 * @param clazz
	 * @param expireSeconds
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String key, Class<T> clazz, long expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		try {
			BoundValueOperations<String, Object> bvo = redisUtil.redisTemplate.boundValueOps(key);
			T obj = (T) bvo.get();
			if (expireSeconds > 0 && obj != null) {
				bvo.expire(expireSeconds, TimeUnit.SECONDS);
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据key 获取对象
	 * 
	 * @param key
	 * @return
	 */
	public static <T> T get(String key, Class<T> clazz) {
		return get(key, clazz, 0);
	}

	/**
	 * 向缓存中设置字符串内容 ,永久有效
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static boolean persist(String key, Object value) {
		if (!redisEnable) {
			return false;
		}
		try {
			BoundValueOperations<String, Object> bvo = redisUtil.redisTemplate.boundValueOps(key);
			bvo.set(value);
			bvo.persist();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 往队列中增加一个值，默认使用lpush
	 * 
	 * @param key
	 * @param value
	 * @param expireSeconds
	 * @return
	 */
	public static Long push(String key, Object value, int expireSeconds) {
		try {
			BoundListOperations<String, Object> blo = redisUtil.redisTemplate.boundListOps(key);
			Long result = blo.leftPush(value);
			if (expireSeconds > 0) {
				blo.expire(expireSeconds, TimeUnit.SECONDS);
			}
			return result;
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 从队列中获取一个值，默认使用rpop
	 * 
	 * @param key
	 * @return
	 */
	public static Object pop(String key) {
		try {
			BoundListOperations<String, Object> blo = redisUtil.redisTemplate.boundListOps(key);
			return blo.rightPop();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 从队列中获取一个值，使用阻塞模式，默认使用brpop
	 * 
	 * @param seconds
	 *            超时时间，超过这个时间之后仍然没有取到值则停止阻塞返回空值
	 * @param key
	 * @return 返回的具体数据，如果为空则代表没有取到数据
	 */
	public static Object bpop(int seconds, String key) {
		try {
			BoundListOperations<String, Object> blo = redisUtil.redisTemplate.boundListOps(key);
			return blo.rightPop(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 从队列1中获取一个值并返回，同时将这个值放在队列2的末尾
	 * 
	 * @param key1
	 *            队列1
	 * @param key2
	 *            队列2，可以是队列1的名称，这样就是从队列1的头部拿出来，同时又放回队列1的尾部
	 * @return
	 */
	public static Object rpoplpush(String key1, String key2) {
		try {
			return redisUtil.redisTemplate.opsForList().rightPopAndLeftPush(key1, key2);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 从key对应list中删除与value相同的所有元素
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long remAll(String key, Object value) {
		try {
			return rem(key, 0L, value);
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 从key对应list中删除count个和value相同的元素.
	 * count>0时，按从头到尾的顺序删除,count<0时，按从尾到头的顺序删除,count=0时，删除全部
	 * 
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 */
	public static Long rem(String key, Long count, Object value) {
		try {
			return redisUtil.redisTemplate.opsForList().remove(key, count, value);
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 将队列中的所有value对应的缓存删除掉
	 * 
	 * @param key
	 */
	public static void removeCacheList(String key) {
		try {
			RedisTemplate<String, Object> rt = redisUtil.redisTemplate;
			BoundListOperations<String, Object> lo = rt.boundListOps(key);
			String value = (String) lo.rightPop();
			while (StringUtils.isNotBlank(value)) {
				rt.delete(value);
				value = (String) lo.rightPop();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 将map写入缓存
	 * 
	 * @param key
	 * @param map
	 */
	public static <T> void setMap(String key, Map<String, T> map) {
		try {
			redisUtil.redisTemplate.opsForHash().putAll(key, map);
		} catch (Exception e) {
		}
	}

	/**
	 * 向key对应的map中添加缓存对象
	 * 
	 * @param key
	 *            cache对象key
	 * @param field
	 *            map对应的key
	 * @param value
	 *            值
	 */
	public static void addMap(String key, String field, Object value) {
		try {
			redisUtil.redisTemplate.opsForHash().put(key, field, value);
		} catch (Exception e) {
		}
	}

	/**
	 * 获取map缓存
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> Map<String, T> getMap(String key, Class<T> clazz) {
		try {
			BoundHashOperations<String, String, T> boundHashOperations = redisUtil.redisTemplate.boundHashOps(key);
			return boundHashOperations.entries();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取map缓存中的某个对象
	 * 
	 * @param key
	 * @param field
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getMapField(String key, String field, Class<T> clazz) {
		try {
			return (T) redisUtil.redisTemplate.boundHashOps(key).get(field);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 删除map中的某个对象
	 * 
	 * @param key
	 *            map对应的key
	 * @param field
	 *            map中该对象的key
	 * @return
	 */
	public static long delMapField(String key, Object... field) {
		try {
			return redisUtil.redisTemplate.boundHashOps(key).delete(field);
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 将redis中的key值增加
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long incrBy(String key, long value) {
		try {
			return redisUtil.redisTemplate.opsForValue().increment(key, value);
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 将redis中的key值减去
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long decrBy(String key, long value) {
		try {
			return redisUtil.redisTemplate.opsForValue().increment(key, -value);
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 更新缓存中key的过期时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 * @throws Exception
	 */
	public static void expire(String key, int seconds) {
		if (!redisEnable) {
			return;
		}
		try {
			redisUtil.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}

	public static boolean isRedisEnable() {
		return redisEnable;
	}

	/**
	 * 向缓存中设置hash， 默认为永久
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public static boolean hset(String key, String field, Object value) {
		return hset(key, field, value, 0);
	}

	/**
	 * 向缓存中设置对象
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @param seconds
	 * @return
	 */
	public static boolean hset(String key, String field, Object value, int seconds) {
		if (!redisEnable) {
			return false;
		}
		redisUtil.redisTemplate.boundHashOps(key).put(field, value);
		if (seconds > 0) {
			redisUtil.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
		}
		return true;
	}

	public static <T> T hget(String key, String field, Class<T> clazz) {
		return hget(key, field, clazz, 0);
	}

	@SuppressWarnings("unchecked")
	public static <T> T hget(String key, String field, Class<T> clazz, int expireSeconds) {
		if (!redisEnable) {
			return null;
		}
		Object value = redisUtil.redisTemplate.boundHashOps(key).get(field);
		if (expireSeconds > 0) {
			redisUtil.redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
		}
		return (T) value;
	}

	public static String serialize(Object object) {
		if (object == null) {
			return "NULL";
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// serialize
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			return baos.toString("ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object unserialize(String value) {
		if (StringUtils.isBlank(value) || "NULL".equals(value)) {
			return null;
		}
		try (ByteArrayInputStream bais = new ByteArrayInputStream(value.getBytes("ISO-8859-1"));
				ObjectInputStream ois = new ObjectInputStream(bais);) {
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}