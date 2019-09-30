package com.fc.main.service;

import org.apache.ibatis.annotations.Param;

public interface XiuGaiMMSerivce {

	int updatePassword(
			String password,
			String newpassword,
			String cfgpassword);
}
