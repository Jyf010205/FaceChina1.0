package com.fc.main.dao;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.apache.ibatis.annotations.Param;
import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.entity.ShuoShuoPingLunResult;
import com.fc.main.entity.TianJiaPingLunEntity;
public interface FSSDao {

	List<Integer> findFSSFriendIdsByUserId(Integer user_id);//对的
	
	List<FriendShuoShuoDaoResult> findShuoShuo(
			@Param("friend_friendids")Integer...friend_friendids);
	
	List<ShuoShuoPingLunResult> findPingLun(
			@Param("shuo_id")Integer shuo_id);
	
	/*int getShuoCount(
			@Param("user_ids")Integer... friend_friendids);*/
	
	List<Integer> findPingIdsByShuoId(
			@Param("shuo_ping_shuoid")Integer shuo_ping_shuoid);
	
	int insertObjects(
			@Param("shuo_ping_shuoid")Integer shuo_ping_shuoid,
			@Param("shuo_ping_pingid")Integer shuo_ping_pingid);
	
	
	int insertObject(TianJiaPingLunEntity entity);
	
	/**点赞*/
	int updateLikeCount(Integer shuo_id);
	
	int insertpinglun(TianJiaPingLunEntity entity);
	
	int insertpingshuo(TianJiaPingLunEntity entity);
	
	int findPingshuo(
			@Param("user_id")Integer user_id,
			@Param("ping_content")String ping_content);
}
