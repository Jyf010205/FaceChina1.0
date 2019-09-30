package com.fc.main.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.main.dao.FindnotfriendDao;
import com.fc.main.entity.FindnotfriendUser;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.FindNotFriendSerivce;

@Service
public class FindNotFriendImpl implements FindNotFriendSerivce{
	@Autowired
	private FindnotfriendDao findnotfriend;

	@Override 
	public List<FindnotfriendUser> findnotfriend() {
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		
		List<FindnotfriendUser> not = findnotfriend.findnotfriend(user.getUser_id());
		if(not==null) throw new IllegalArgumentException("id值无效");
		System.out.println(not);
		return not;
	}
	@Override
	public int insertfriend( Integer friendid) {
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		int a = findnotfriend.insertfriend(user.getUser_id(), friendid);
		return a;
	}
	
	
}
