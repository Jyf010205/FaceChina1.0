package com.fc.main.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface XiuGaiMMDao {

	int updatePassword(
			@Param("user_name")String username,
			@Param("user_password")String password,
			@Param("user_salt")String salt
			);
	

	
	
}



