package com.active.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.active.dao.TempMapper;
import com.active.entity.Temp;
import com.active.service.TempService;

@Service
public class TempServiceImpl implements TempService {

	@Autowired
	TempMapper TempMapper;

	@Override
	public Temp selectTempById(String id) {
		return TempMapper.selectByPrimaryKey(id);
	}
}
