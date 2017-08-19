package com.active.dao;

import com.active.entity.CollectContentData;

public interface CollectContentDataMapper {
	int deleteByPrimaryKey(String id);

	int insert(CollectContentData record);

	int insertSelective(CollectContentData record);

	CollectContentData selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CollectContentData record);

	int updateByPrimaryKeyWithBLOBs(CollectContentData record);

	int updateByPrimaryKey(CollectContentData record);
}