package com.fc.main.dao;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.ZhuCeUser;
/**
 * 处理注册
 * @author 000
 *
 */
public interface ZhuCeDao {
	/**
	 * 注册新用户，
	 * @param zhuCeUser 封装注册页面的字段信息
	 * @return 影响行数
	 */
	int insert(ZhuCeUser zhuCeUser);
	ZhuCeUser findZhuCeUser(@Param("user_name")String user_name);
	ZhuCeUser findUserByUserEmail(@Param("user_email")String user_email);
}
