package com.fc.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.main.dao.FcViewFriendsDao;
import com.fc.main.entity.ViewFriendsEntity;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.FcViewFriendsService;

@Service
public class FcViewFriendsServiceImpl implements FcViewFriendsService {
	@Autowired
	private FcViewFriendsDao fcViewFriendsDao;
	ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
	Integer user_id = user.getUser_id();

	@Override
	public List<ViewFriendsEntity> findFriends() {
		// 判断数据有效性
		System.out.println(user_id);
		if (user_id == null || user_id == 0) {
			System.out.println(user_id);
			throw new IllegalArgumentException("用户不能为空");
		}
		Integer[] ids = fcViewFriendsDao.findFriendByUserId(user_id);
		ViewFriendsEntity ff = fcViewFriendsDao.findFriends(user_id);
		if (ff == null) { 
			throw new IllegalArgumentException("没有查询到数据");
		}
		// 获取数据
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("没有关注的好友");
		}
		List<ViewFriendsEntity> list = new ArrayList<ViewFriendsEntity>();
		for (int i = 0; i < ids.length; i++) {
			int c = ids[i];
			list.add(fcViewFriendsDao.findFriends(c));
		}

		return list;
	}

	@Override
	public int deleteFriends(Integer friend_friendid) {
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		Integer friend_userid = user.getUser_id();
		//判断数据有效性
		if(friend_userid==0||friend_friendid==0) {
			throw new IllegalArgumentException("数据不正确");
		}
		if(friend_userid==null||friend_friendid==null) {
			throw new IllegalArgumentException("数据不正确");
		}
		int rows = 
				fcViewFriendsDao.deleteFriends(friend_userid, friend_friendid);
		if(rows==0) {
			throw new IllegalArgumentException("好友已经被删除了");
		}
		return rows;
	}

	@Override
	public int insertLiuyan( Integer friend_id, String content) {
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		Integer user_id = user.getUser_id();
		if(content==null) {
			throw new IllegalArgumentException("留言不能为空");
		}
		int rows = fcViewFriendsDao.insertLiuByUserId(friend_id,user_id , content);
		if(rows==0) {
			throw new IllegalArgumentException("留言失败，请稍后重试");
		}
		return rows;
	}

}
