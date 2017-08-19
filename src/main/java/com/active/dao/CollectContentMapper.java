package com.active.dao;

import com.active.entity.CollectContent;

public interface CollectContentMapper {

	int deleteByPrimaryKey(String id);

	int insert(CollectContent record);

	int insertSelective(CollectContent record);

	CollectContent selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CollectContent record);

	int updateByPrimaryKey(CollectContent record);
}