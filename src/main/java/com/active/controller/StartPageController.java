package com.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.active.base.BaseResult;
import com.active.service.StartPageService;

@RestController
@RequestMapping("startPage")
public class StartPageController {

	@Autowired
	StartPageService startPageService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public BaseResult<?> startPage() throws Exception {
		return new BaseResult<>(startPageService.getStartPage());
	}
}
