package com.active.service;

import java.util.Map;

/**
 * 笨笨管理service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
public interface VersionService {

	Map<String, Object> getVersion(String canal, String os, String version);
}
