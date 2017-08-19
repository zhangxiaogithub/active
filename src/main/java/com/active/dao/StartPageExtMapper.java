package com.active.dao;

import java.util.List;

import com.active.entity.StartPage;

public interface StartPageExtMapper extends StartPageMapper {

	/**
	 * 查询启动页列表
	 */
	List<StartPage> selectStartPageList();
}