package com.active.dao;

import com.active.entity.BizCategory;

public interface BizCategoryMapper {
	int deleteByPrimaryKey(String id);

	int insert(BizCategory record);

	int insertSelective(BizCategory record);

	BizCategory selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(BizCategory record);

	int updateByPrimaryKey(BizCategory record);
}