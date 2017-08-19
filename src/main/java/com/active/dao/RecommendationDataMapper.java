package com.active.dao;

import com.active.entity.RecommendationData;

public interface RecommendationDataMapper {

	int deleteByPrimaryKey(String id);

	int insert(RecommendationData record);

	int insertSelective(RecommendationData record);

	RecommendationData selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(RecommendationData record);

	int updateByPrimaryKey(RecommendationData record);
}