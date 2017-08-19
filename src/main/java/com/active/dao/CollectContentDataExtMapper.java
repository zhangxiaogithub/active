package com.active.dao;

import java.util.List;
import java.util.Map;

import com.active.entity.CollectContentData;

public interface CollectContentDataExtMapper extends CollectContentDataMapper {

	int deleteById(String id);

	List<CollectContentData> findList(Map<String, Object> params);

	Long findListCount(Map<String, Object> params);
}