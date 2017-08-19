package com.active.dao;

import java.util.List;
import java.util.Map;

import com.active.entity.RecommendationData;

public interface RecommendationDataExtMapper extends RecommendationDataMapper {

	int updateStatus(Map<String, Object> params);

	int deleteById(String id);

	List<RecommendationData> findList(Map<String, Object> params);

	Long findListCount(Map<String, Object> params);
}