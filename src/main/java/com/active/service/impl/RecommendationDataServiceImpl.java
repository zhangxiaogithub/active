package com.active.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.common.Page;
import com.active.dao.RecommendationDataExtMapper;
import com.active.entity.RecommendationData;
import com.active.service.RecommendationDataService;

/**
 * service
 *
 * @author zx
 * @Date 2017年8月12日 下午9:11:57
 */
@Service
public class RecommendationDataServiceImpl implements RecommendationDataService {

	@Autowired
	RecommendationDataExtMapper recommendationDataExtMapper;

	@Override
	public RecommendationData get(String id) {
		return recommendationDataExtMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(RecommendationData record) {
		recommendationDataExtMapper.insertSelective(record);
	}

	@Override
	public int updateStatus(String id, String userId, Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("updateBy", userId);
		params.put("updateDate", date);
		params.put("status", "1");
		return recommendationDataExtMapper.updateStatus(params);
	}

	@Override
	public void delete(String id) {
		recommendationDataExtMapper.deleteById(id);
	}

	@Override
	public Page<RecommendationData> findPage(Page<RecommendationData> page, RecommendationData bizCategory) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageIndex", (page.getPageNo() - 1) * page.getPageSize());
		params.put("pageSize", page.getPageSize());
		page.setCount(recommendationDataExtMapper.findListCount(params));
		page.setList(recommendationDataExtMapper.findList(params));
		return page;
	}

}
