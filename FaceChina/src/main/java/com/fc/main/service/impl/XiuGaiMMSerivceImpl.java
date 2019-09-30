package com.fc.main.service.impl;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.XiuGaiMMDao;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.XiuGaiMMSerivce;
@Service
public class XiuGaiMMSerivceImpl implements XiuGaiMMSerivce{
	@Autowired
	private XiuGaiMMDao xiuGaiMMDao;
	
	@Override
	public int updatePassword(String password,
			String newpassword,String cfgpassword) {
		//1.对参数进行非空验证
		//2.验证密码的合法性
		//2.1判定两次输入密码是否一致	
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh = new SimpleHash("MD5", password,
				user.getUser_salt(),1);
		SimpleHash newsh = new SimpleHash("MD5", newpassword,
				user.getUser_salt(),1);
		
		if(!user.getUser_password().equals(sh.toHex())) 
			throw new IllegalArgumentException("输入原密码不正确");
		if(!newpassword.equals(cfgpassword)) throw 
		new IllegalArgumentException("输入密码两次不一致");
		
		if(user.getUser_password().equals(newsh.toHex())) throw 
		new IllegalArgumentException("新密码不能与原密码一致");
		
	
		String salt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",newpassword,salt,1);
		int rows=xiuGaiMMDao.updatePassword(user.getUser_name(),sh.toHex(), salt);	
		return rows;
	}
	
}
	
	
	
	

