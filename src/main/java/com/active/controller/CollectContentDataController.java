package com.active.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.active.service.TempService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("collectContentData")
public class CollectContentDataController {
	@Autowired
	TempService TempService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String test(@RequestParam(required = false) String id) {
		if (StringUtils.isBlank(id)) {
			return "";
		}
		return JSON.toJSONString(TempService.selectTempById(id));
	}
}
