package com.active.service;

import java.util.List;

import com.active.common.Page;
import com.active.entity.BizCategory;

/**
 * 业务类目service
 *
 * @author zx
 * @Date 2017年8月12日 下午11:43:57
 */
public interface BizCategoryService {

	BizCategory get(String id);

	void save(BizCategory record);

	int update(BizCategory record);

	void delete(String id);

	Page<BizCategory> findPage(Page<BizCategory> page, BizCategory bizCategory);

	List<BizCategory> getBizCategoryType();
}
