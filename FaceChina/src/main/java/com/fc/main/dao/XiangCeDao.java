package com.fc.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.Image;

public interface XiangCeDao {
	public int insert(Image image);
	int insertSrc(@Param("user_picture_userid") int user_picture_userid,@Param("user_picture_pictureid") int user_picture_pictureid);
	public List<String> findSrc(Integer id);
	public int findpictureidBypicturename(String picture_name);
	String finduserprctureurl(Integer id);
	int updatehead(@Param("user_pictureid")int user_pictureid,@Param("user_id") int user_id);
}
