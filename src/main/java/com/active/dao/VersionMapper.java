package com.active.dao;

import com.active.entity.Version;

public interface VersionMapper {
	int deleteByPrimaryKey(String id);

	int insert(Version record);

	int insertSelective(Version record);

	Version selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Version record);

	int updateByPrimaryKey(Version record);
}