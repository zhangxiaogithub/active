package com.active.dao;

import java.util.List;

import com.active.entity.SignIn;

public interface SignInExtMapper extends SignInMapper {

	List<SignIn> selectList(String type);
}