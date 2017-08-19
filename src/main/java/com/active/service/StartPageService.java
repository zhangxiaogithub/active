package com.active.service;

import java.util.Map;

import com.active.entity.StartPage;

/**
 * 启动页service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
public interface StartPageService {

	/**
	 * 获取启动页
	 * 
	 * @return
	 */
	Map<String, Object> getStartPage();

	int update(StartPage record);

	StartPage get(String id);

	StartPage get();

	void save(StartPage record);
}
