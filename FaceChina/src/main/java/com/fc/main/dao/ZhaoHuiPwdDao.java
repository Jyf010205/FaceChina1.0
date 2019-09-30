package com.fc.main.dao;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.ZhuCeUser;

public interface ZhaoHuiPwdDao {

	//ZhuCeUser findUserByUserEmail(@Param("user_email")String user_email);
	
	int updatePassword(
			@Param("user_email")String user_email,
			@Param("user_password")String password,
			@Param("user_salt")String salt
			);
}
