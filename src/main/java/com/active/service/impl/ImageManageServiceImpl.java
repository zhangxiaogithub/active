package com.active.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.dao.ImageManageExtMapper;
import com.active.entity.ImageManage;
import com.active.service.ImageManageService;
import com.active.util.ImageUrlUtil;

/**
 * 签到service
 *
 * @author zx
 * @Date 2017年7月15日 下午9:11:57
 */
@Service
public class ImageManageServiceImpl implements ImageManageService {

	@Autowired
	ImageManageExtMapper imageManageExtMapper;

	@Override
	public Map<String, Object> getIcon() {
		List<ImageManage> list = imageManageExtMapper.selectList("icon");
		if (list != null && list.size() > 0) {
			ImageManage imageManage = list.get(0);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", ImageUrlUtil.getImageUrl(imageManage.getImage1()));
			map.put("url", imageManage.getUrl());
			return map;
		}
		return null;
	}

	@Override
	public Map<String, Object> getImage() {
		List<ImageManage> list = imageManageExtMapper.selectList("image");
		if (list != null && list.size() > 0) {
			ImageManage imageManage = list.get(0);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("headerImage", ImageUrlUtil.getImageUrl(imageManage.getImage1()));
			map.put("headerWidth", imageManage.getWidth1());
			map.put("headerHeight", imageManage.getHeight1());
			map.put("footerImage", ImageUrlUtil.getImageUrl(imageManage.getImage2()));
			map.put("footerWidth", imageManage.getWidth2());
			map.put("footerHeight", imageManage.getHeight2());
			return map;
		}
		return null;
	}
}
