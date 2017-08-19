package com.active.dao;

import com.active.entity.ImageManage;

public interface ImageManageMapper {
	int deleteByPrimaryKey(String id);

	int insert(ImageManage record);

	int insertSelective(ImageManage record);

	ImageManage selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ImageManage record);

	int updateByPrimaryKey(ImageManage record);
}