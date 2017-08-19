package com.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.active.base.BaseResult;
import com.active.dto.User;
import com.active.service.SignInService;
import com.active.util.UserUtil;

@RestController
@RequestMapping("signIn")
public class SignInController {
	@Autowired
	SignInService signInService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public BaseResult<?> signIn() {
		String weixinId = null;
		String userId = null;
		User user = UserUtil.getUser();
		if (user != null) {
			weixinId = UserUtil.getUser().getWeixinId();
			userId = UserUtil.getUser().getWeixinId();
		}
		return new BaseResult<>(signInService.getSignIn(userId, weixinId));
	}
}
