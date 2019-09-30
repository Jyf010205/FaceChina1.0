package com.fc.main.dao;

import org.apache.ibatis.annotations.Param;

public interface ShuoPictureDao {
	int insertShuoPicture(@Param("shuo_picture_shuoid")int userid,
							@Param("shuo_picture_pictureid")int pricture_id);
}
