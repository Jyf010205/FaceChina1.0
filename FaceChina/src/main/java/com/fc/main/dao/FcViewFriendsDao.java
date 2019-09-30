package com.fc.main.dao;

import org.apache.ibatis.annotations.Param;
import com.fc.main.entity.ViewFriendsEntity;

/**
 * wangwei
 */

public interface FcViewFriendsDao {

	ViewFriendsEntity findFriends(Integer user_id);
	
	int deleteFriends(
			@Param("friend_userid") Integer friend_userid,
			@Param("friend_friendid") Integer friend_friendid);
	
	Integer[] findFriendByUserId(
			@Param("friend_userid") Integer friend_userid);
	
	int insertLiuByUserId(
			@Param("user_id")Integer user_id,
			@Param("friend_id")Integer friend_id,
			@Param("content")String content);
}