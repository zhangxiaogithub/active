package com.active.config;

import javax.annotation.Resource;
import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	public FilterConfig() {
		//
	}

	@Resource(name = "tokenFilter")
	Filter tokenFilter;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean addTokenFilter() {
		// 默认拦截所有请求
		// 如果满足 filter.mapping.token.not_need_login 则不需要登录
		// 如果满足 filter.mapping.token 则需要登录
		// 默认返回不需要登录
		FilterRegistrationBean registration = new FilterRegistrationBean();
		String tokenMapping = "/*";
		String[] tokenMappings = tokenMapping.split(",");
		registration.setFilter(tokenFilter);
		registration.addUrlPatterns(tokenMappings);
		registration.setOrder(1);
		return registration;
	}
}
