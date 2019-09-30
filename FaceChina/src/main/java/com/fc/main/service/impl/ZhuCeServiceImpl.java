package com.fc.main.service.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fc.main.dao.ZhuCeDao;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.ZhuCeService;
@Service
public class ZhuCeServiceImpl implements ZhuCeService{
	@Autowired
	private ZhuCeDao zhuCeDao;
	
	@Override
	public int saveZhuCeUser(ZhuCeUser zhuCeUser,String secondPwd){
		//1.判断参数有效性
		if(zhuCeUser==null)
			throw new IllegalArgumentException("注册对象不能为空");
		if(StringUtils.isEmpty(zhuCeUser.getUser_name()))
			throw new IllegalArgumentException("请填写用户名");
		if(StringUtils.isEmpty(zhuCeUser.getUser_email()))
			throw new IllegalArgumentException("请填写邮箱");
		if(StringUtils.isEmpty(zhuCeUser.getUser_phonenum()))
			throw new IllegalArgumentException("请填写您的电话号码");
		if(StringUtils.isEmpty(zhuCeUser.getUser_password()))
			throw new IllegalArgumentException("密码不能为空");
		//判断第一次密码和第二次密码是否一致
		if(!(zhuCeUser.getUser_password()).equals(secondPwd))
			throw new IllegalArgumentException("两次输入的密码不一致");
		//2.保存用户信息
		//2.1创建一个盐值(与密码进行一起加密)
		String salt = UUID.randomUUID().toString();
		//2.2对密码进行加密(SimpleHash为shiro框架提供)
		SimpleHash sHash = new SimpleHash("MD5",//加密算法
								zhuCeUser.getUser_password(),//没有加密的密码
				                salt,//盐值
				                1);//加密次数
		String Pwd = sHash.toHex();//将密码转换为16进制
		//2.3将salt,newPwd存储entity对象
		zhuCeUser.setUser_password(Pwd);
		zhuCeUser.setUser_salt(salt);
		
		//3.将注册用户存入数据库
		//3.1判断用户是否存在
		ZhuCeUser user = zhuCeDao.findZhuCeUser(zhuCeUser.getUser_name());
		int rows = 0;
		if(user==null){
			System.out.println(zhuCeUser.toString());
			rows = zhuCeDao.insert(zhuCeUser);
		}else{
			System.out.println("123");
			throw new IllegalArgumentException("该用户已经存在");
		}
		return rows;
	}

}
