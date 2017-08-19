package com.active.filter.token;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.active.util.UserUtil;

@Service("tokenFilter")
public class TokenFilter extends OncePerRequestFilter {
	@Autowired
	private TokenValidator tokenValidator;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		UserUtil test = UserUtil.me.get().clear();
		try {
			String userId = tokenValidator.tokenVerify(request, response);
			Boolean isNeedLogin = tokenValidator.isNeedLogin(request);
			if (StringUtils.isBlank(userId) && isNeedLogin) {
				onAuthFail(request, response, "{\"code\":\"40100\",\"message\":\"用户尚未登录\",\"data\":null}");
				return;
			}
			chain.doFilter(request, response);
		} finally {
			test.close();
		}
	}

	private void onAuthFail(HttpServletRequest request, HttpServletResponse response, String message)
			throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(message);
	}
}
