package com.fc.main.dao;

import org.apache.ibatis.annotations.Param;

public interface ShuoUserDao {
	int insertReleationShip(@Param("user_shuo_userid")int userid,
							@Param("user_shuo_shuoid")int shuoid);
}
