package com.fc.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.FindnotfriendUser;

public interface FindnotfriendDao {

	List<FindnotfriendUser> findnotfriend(
			     Integer id);
	
	int insertfriend(@Param ("friend_userid") Integer friend_userid,
			@Param ("friend_friendid") Integer friend_friendid);
}
