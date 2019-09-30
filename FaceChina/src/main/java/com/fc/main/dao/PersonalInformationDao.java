package com.fc.main.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.PersonalInformation;


public interface PersonalInformationDao {
	//将数据库获取的类封装到Dao对象
	//@Param指定sql中的可变参数
	PersonalInformation showPersonalInformation(@Param("user_id") Integer user_id);
	int modifyPersonalInformation(PersonalInformation pi);
}
