package com.fc.main.service.impl;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.ZhaoHuiPwdDao;
import com.fc.main.dao.ZhuCeDao;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.ZhaoHuiPwdService;
@Service
public class ZhaoHuiPwdServiceImpl implements ZhaoHuiPwdService {
	@Autowired
	private ZhuCeDao zhuCeDao;
	@Autowired
	private ZhaoHuiPwdDao zhaoHuiPwdDao;
	@Override
	public int updatePassword(ZhuCeUser zhuCeUser, String newPwd, String SecondPwd){
		ZhuCeUser user = zhuCeDao.findUserByUserEmail(zhuCeUser.getUser_email());
		System.out.println(user);
		if(user==null){
			throw new IllegalArgumentException("用户不存在");
		}
		if(newPwd==null||newPwd=="")
			throw new IllegalArgumentException("请输入新密码");
		if(SecondPwd==null||SecondPwd=="")
			throw new IllegalArgumentException("请输入确认密码");
		if(!newPwd.equals(SecondPwd)) throw 
		new IllegalArgumentException("输入密码两次不一致");
		String salt = UUID.randomUUID().toString();
		SimpleHash newsh = new SimpleHash("MD5",
				newPwd,
				salt, 
				1);
		int rows = zhaoHuiPwdDao.updatePassword(user.getUser_email(),
					newsh.toHex(), salt);
		return rows;
	}

	
}
