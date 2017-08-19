package com.active.dao;

import java.util.List;
import java.util.Map;

import com.active.entity.BizCategory;

public interface BizCategoryExtMapper extends BizCategoryMapper {

	int deleteById(String id);

	List<BizCategory> findList(Map<String, Object> params);

	Long findListCount(Map<String, Object> params);

	List<BizCategory> getBizCategoryType(Map<String, Object> params);

}