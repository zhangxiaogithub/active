package com.active.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.common.Page;
import com.active.dao.CollectContentDataExtMapper;
import com.active.entity.CollectContentData;
import com.active.service.CollectContentDataService;

/**
 * 收录内容数据管理service
 *
 * @author zx
 * @Date 2017年8月12日 下午9:11:57
 */
@Service
public class CollectContentDataServiceImpl implements CollectContentDataService {

	@Autowired
	CollectContentDataExtMapper collectContentDataExtMapper;

	@Override
	public CollectContentData get(String id) {
		return collectContentDataExtMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(CollectContentData record) {
		collectContentDataExtMapper.insertSelective(record);
	}

	@Override
	public int update(CollectContentData record) {
		return collectContentDataExtMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(String id) {
		collectContentDataExtMapper.deleteById(id);
	}

	@Override
	public Page<CollectContentData> findPage(Page<CollectContentData> page, CollectContentData CollectContentData) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageIndex", (page.getPageNo() - 1) * page.getPageSize());
		params.put("pageSize", page.getPageSize());
		page.setCount(collectContentDataExtMapper.findListCount(params));
		page.setList(collectContentDataExtMapper.findList(params));
		return page;
	}
}
