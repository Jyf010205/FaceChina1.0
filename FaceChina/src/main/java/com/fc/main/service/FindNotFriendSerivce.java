package com.fc.main.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.FindnotfriendUser;

public interface FindNotFriendSerivce {

	List<FindnotfriendUser> findnotfriend();
	int insertfriend(
					Integer friendid);
}
