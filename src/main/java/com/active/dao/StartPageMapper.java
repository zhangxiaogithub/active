package com.active.dao;

import com.active.entity.StartPage;

public interface StartPageMapper {
	int deleteByPrimaryKey(String id);

	int insert(StartPage record);

	int insertSelective(StartPage record);

	StartPage selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(StartPage record);

	int updateByPrimaryKey(StartPage record);
}