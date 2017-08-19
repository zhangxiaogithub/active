package com.active.dao;

import java.util.List;

import com.active.entity.ImageManage;

public interface ImageManageExtMapper extends ImageManageMapper {

	List<ImageManage> selectList(String type);

}