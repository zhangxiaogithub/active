package com.active.service;

import java.util.Date;

import com.active.common.Page;
import com.active.entity.RecommendationData;

/**
 * 业务类目service
 *
 * @author zx
 * @Date 2017年8月12日 下午11:43:57
 */
public interface RecommendationDataService {

	RecommendationData get(String id);

	void save(RecommendationData record);

	void delete(String id);

	Page<RecommendationData> findPage(Page<RecommendationData> page, RecommendationData RecommendationData);

	int updateStatus(String id, String userId, Date date);
}
