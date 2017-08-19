package com.active.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.dao.SignInExtMapper;
import com.active.entity.SignIn;
import com.active.service.SignInService;

/**
 * 签到service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
@Service
public class SignInServiceImpl implements SignInService {

	@Autowired
	SignInExtMapper signInExtMapper;

	@Override
	public Map<String, Object> getSignIn(String userId, String weixinId) {
		List<SignIn> list = signInExtMapper.selectList("signIn");
		if (list != null && list.size() > 0) {
			SignIn signIn = list.get(0);
		}
		return null;
	}

	@Override
	public Map<String, Object> signIn(String userId, String weixinId) {
		// TODO Auto-generated method stub
		return null;
	}
}
