package com.active.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.common.Page;
import com.active.dao.BizCategoryExtMapper;
import com.active.entity.BizCategory;
import com.active.service.BizCategoryService;

/**
 * 业务类目service
 *
 * @author zx
 * @Date 2017年8月12日 下午9:11:57
 */
@Service
public class BizCategoryServiceImpl implements BizCategoryService {

	@Autowired
	BizCategoryExtMapper bizCategoryExtMapper;

	@Override
	public BizCategory get(String id) {
		return bizCategoryExtMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(BizCategory record) {
		bizCategoryExtMapper.insertSelective(record);
	}

	@Override
	public int update(BizCategory record) {
		return bizCategoryExtMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(String id) {
		bizCategoryExtMapper.deleteById(id);
	}

	@Override
	public Page<BizCategory> findPage(Page<BizCategory> page, BizCategory bizCategory) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageIndex", (page.getPageNo() - 1) * page.getPageSize());
		params.put("pageSize", page.getPageSize());
		page.setCount(bizCategoryExtMapper.findListCount(params));
		page.setList(bizCategoryExtMapper.findList(params));
		return page;
	}

	@Override
	public List<BizCategory> getBizCategoryType() {
		return bizCategoryExtMapper.getBizCategoryType(new HashMap<String, Object>());
	}
}
