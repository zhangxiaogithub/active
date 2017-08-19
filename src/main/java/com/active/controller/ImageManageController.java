package com.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.active.base.BaseResult;
import com.active.service.ImageManageService;

@RestController
@RequestMapping("imageManage")
public class ImageManageController {
	@Autowired
	ImageManageService imageManageService;

	@RequestMapping(value = "icon", method = RequestMethod.GET)
	public BaseResult<?> icon(@RequestParam(required = false) String id) {
		return new BaseResult<>(imageManageService.getIcon());
	}

	@RequestMapping(value = "image", method = RequestMethod.GET)
	public BaseResult<?> image(@RequestParam(required = false) String id) {
		return new BaseResult<>(imageManageService.getImage());
	}
}
