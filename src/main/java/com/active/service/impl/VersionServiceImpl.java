package com.active.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.constant.Constant;
import com.active.dao.VersionExtMapper;
import com.active.entity.Version;
import com.active.service.VersionService;

/**
 * 版本管理service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	VersionExtMapper versionExtMapper;

	@Override
	public Map<String, Object> getVersion(String canal, String os, String version) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("os", os);
		params.put("canal", canal);
		List<Version> list = versionExtMapper.getVersion(params);
		if (list != null && list.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			Version record = list.get(0);
			map.put("os", record.getOs());
			map.put("canal", record.getCanal());
			// TODO 验证方式待定 更新，强制更新：2，更新：1，不更新：0
			if (record.getVersion().contentEquals(version)) {
				if (Constant.CONSTRAINT_UPDAT_YES.equals(record.getUpdateFlag())) {
					map.put("update", "2");// 强制更新
				} else {
					map.put("update", "1");// 更新
				}
			} else {
				map.put("update", "0");// 不更新
			}
			map.put("url", record.getUrl());
			map.put("description", record.getDescription());
		}
		return null;
	}

}
