package com.active.dao;

import com.active.entity.Temp;

public interface TempMapper {
    int deleteByPrimaryKey(String id);

    int insert(Temp record);

    int insertSelective(Temp record);

    Temp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Temp record);

    int updateByPrimaryKey(Temp record);
}