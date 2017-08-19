package com.active.dao;

import java.util.List;
import java.util.Map;

import com.active.entity.Version;

public interface VersionExtMapper extends VersionMapper {

	int deleteById(String id);

	List<Version> selectList();

	List<Version> getVersion(Map<String, Object> params);
}