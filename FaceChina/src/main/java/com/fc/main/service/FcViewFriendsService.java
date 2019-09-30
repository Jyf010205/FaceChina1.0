package com.fc.main.service;

import java.util.List;
import com.fc.main.entity.ViewFriendsEntity;

/**
 * wangwei
 */

public interface FcViewFriendsService {
	List<ViewFriendsEntity> findFriends();
	
	int deleteFriends(Integer friend_friendid);
	
	int insertLiuyan(Integer user_id,String content);
}
