package com.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.active.service.TempService;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("version")
public class VersionController {
	@Autowired
	TempService TempService;

	@RequestMapping(value = "/{canal}", method = RequestMethod.GET)
	public String test(@PathVariable("canal") String canal, @RequestParam("version") String version,
			@RequestParam("os") String os) {
		return JSON.toJSONString(TempService.selectTempById(""));
	}
}
