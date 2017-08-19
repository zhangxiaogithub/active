package com.active.service;

import java.util.Map;

/**
 * 签到service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
public interface SignInService {

	/**
	 * 获取签到信息
	 * 
	 * @return
	 */
	Map<String, Object> getSignIn(String userId, String weixinId);

	/**
	 * 获取用户签到信息
	 * 
	 * @param userId
	 * @param weixinId
	 * @return
	 */
	Map<String, Object> signIn(String userId, String weixinId);
}
