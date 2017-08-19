package com.active.filter.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.active.constant.Constant;
import com.active.dto.User;
import com.active.util.CookieUtils;
import com.active.util.UserUtil;

/**
 * token验证
 * 
 * @author hzybo
 * @verson 2016-11-15
 */
@Service
public class TokenValidator {
	private final static Logger LOGGER = LoggerFactory.getLogger(TokenValidator.class);

	private static PathMatcher matcher = new AntPathMatcher();

	/**
	 * 校验token，如果是有效token则返回userId
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String tokenVerify(HttpServletRequest request, HttpServletResponse response) {
		UserUtil.clientIp(getRemoteIp(request));
		String weixinId = request.getHeader(Constant.WEIXIN_ID);
		if (StringUtils.isBlank(weixinId)) {
			weixinId = CookieUtils.getCookie(request, Constant.WEIXIN_ID);
		}
		LOGGER.info("{} {} {} {} {}", request.getRemoteAddr(), request.getRequestURI(), request.getMethod(), weixinId,
				UserUtil.clientIp());
		if (StringUtils.isBlank(weixinId)) {
			return null;
		}
		User user = new User();
		user.setWeixinId(weixinId);
		UserUtil.setUser(user);
		return user.getUserId();
	}

	private static String getRemoteIp(HttpServletRequest request) {
		String remoteIp = "";
		remoteIp = request.getHeader(Constant.HEAD_NAME_X_REAL_IP);
		if (StringUtils.isBlank(remoteIp)) {
			remoteIp = request.getHeader(Constant.HEAD_NAME_X_FORWARDED_FOR);
		}
		if (StringUtils.isBlank(remoteIp)) {
			remoteIp = request.getRemoteAddr();
		}
		if (StringUtils.isBlank(remoteIp)) {
			remoteIp = "127.0.0.1";
		}

		return remoteIp;
	}

	public Boolean isNeedLogin(HttpServletRequest req) {
		String path = req.getRequestURI();
		if (matcher.match("/**/public/**", path) || matcher.match("/**/test/**", path)) {
			return false;
		}
		return false;
	}
}
