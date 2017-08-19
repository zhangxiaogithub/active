package com.active.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.common.Page;
import com.active.dao.CollectContentExtMapper;
import com.active.entity.CollectContent;
import com.active.service.CollectContentService;

/**
 * 收录内容service
 *
 * @author zx
 * @Date 2017年8月12日 下午9:11:57
 */
@Service
public class CollectContentServiceImpl implements CollectContentService {

	@Autowired
	CollectContentExtMapper collectContentExtMapper;

	@Override
	public CollectContent get(String id) {
		return collectContentExtMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(CollectContent record) {
		collectContentExtMapper.insertSelective(record);
	}

	@Override
	public int update(CollectContent record) {
		return collectContentExtMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(String id) {
		collectContentExtMapper.deleteById(id);
	}

	@Override
	public Page<CollectContent> findPage(Page<CollectContent> page, CollectContent collectContent) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bizCategoryId", collectContent.getBizCategoryId());
		params.put("pageIndex", (page.getPageNo() - 1) * page.getPageSize());
		params.put("pageSize", page.getPageSize());
		page.setCount(collectContentExtMapper.findListCount(params));
		page.setList(collectContentExtMapper.findList(params));
		return page;
	}

	@Override
	public List<CollectContent> getCollectContent() {
		return collectContentExtMapper.getCollectContent(new HashMap<String, Object>());
	}
}
