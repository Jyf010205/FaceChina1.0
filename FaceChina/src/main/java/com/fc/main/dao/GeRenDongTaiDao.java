package com.fc.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.main.vo.GeRenPingLunVO;
import com.fc.main.vo.GeRenShuoVO;

public interface GeRenDongTaiDao {
	
	List<GeRenShuoVO> findGeRenShuo(
			@Param("user_email")String user_email);
	
	List<GeRenPingLunVO> findGeRenPingLun(
			@Param("shuo_id")Integer shuo_id);
	
	int getShuoCount(
			@Param("user_email")String user_email);
	
	int getPingCount(
			@Param("shuo_ping_shuoid")Integer shuo_ping_shuoid);	
	
	int deleteUserShuoByShuoId(
			@Param("user_shuo_shuoid")Integer user_shuo_shuoid);
	
	int deleteShuoByShuoId(
			@Param("shuo_id")Integer shuo_id);
	
	int deleteShuoPingByShuoId(
			@Param("shuo_ping_shuoid")Integer shuo_ping_shuoid);
	
	List<Integer> findPingIdsByShuoId(
			@Param("shuo_id")Integer shuo_id);
	
	int deletePingByPingIds(
			@Param("pingIds")List<Integer> pingIds);
	
	int deleteShuoPictureByShuoId(
			@Param("shuo_picture_shuoid")Integer shuo_picture_shuoid);
	
	Integer findPictureIdByShuoId(
			@Param("shuo_id")Integer shuo_id);
	
	int deletePictureByPictureId(
			@Param("picture_id")Integer picture_id);
	
	
}
