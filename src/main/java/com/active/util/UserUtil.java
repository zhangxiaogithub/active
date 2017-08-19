package com.active.util;

import java.util.logging.Logger;

import com.active.dto.User;
import com.active.exception.NotLoginException;
import com.alibaba.fastjson.JSON;

public class UserUtil implements AutoCloseable {
	private static Logger logger = Logger.getLogger(UserUtil.class.getName());

	private UserUtil() {
		//
	}

	public static ThreadLocal<UserUtil> me = new ThreadLocal<UserUtil>() {
		protected UserUtil initialValue() {
			return new UserUtil();
		}
	};

	private User user;
	private String clientIp;
	private String lastErrorMsg;

	/**
	 * 获取当前登录用户，如果未登录则返回null
	 * 
	 * @return
	 */
	public static User getUser() {
		return me.get().user;
	}

	public static String clientIp() {
		return me.get().clientIp;
	}

	/**
	 * 获取当前登录用户，如果未登录则抛出 RuntimeException
	 * 
	 * @return User
	 */
	public static User accessUser() {
		User user = me.get().user;
		if (user == null) {
			throw new NotLoginException();
		} else {
			logger.info("accessUser():" + Thread.currentThread().getId() + " " + JSON.toJSONString(user));
		}
		return user;
	}

	/**
	 * 获取当前登录用户 id，如果未登录则抛出 RuntimeException
	 * 
	 * @return userId
	 */
	public static String accessUserId() {
		User user = me.get().user;
		if (user == null) {
			throw new NotLoginException();
		} else {
			logger.info("accessUserId():" + JSON.toJSONString(user));
		}
		return user.getUserId();
	}

	public static void clientIp(String ip) {
		me.get().clientIp = ip;
	}

	public static void setUser(User user) {
		me.get().user = user;
	}

	public static void lastErrorMsg(String msg) {
		me.get().lastErrorMsg = msg;
	}

	public static String lastErrorMsg() {
		return me.get().lastErrorMsg;
	}

	public UserUtil clear() {
		this.user = null;
		this.lastErrorMsg = null;
		this.clientIp = null;
		return this;
	}

	public void close() {
		me.get().clear();
		me.remove();
	}
}
