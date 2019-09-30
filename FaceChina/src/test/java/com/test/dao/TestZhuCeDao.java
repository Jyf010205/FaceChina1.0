package com.test.dao;

import org.junit.Test;

import com.fc.main.dao.ZhuCeDao;
import com.fc.main.entity.ZhuCeUser;
import com.test.TestBase;

public class TestZhuCeDao extends TestBase {
	@Test
	public void testZhuCeDao(){
		ZhuCeDao dao = ctx.getBean("zhuCeDao",ZhuCeDao.class);
		ZhuCeUser zhuCeUser =new ZhuCeUser();
		zhuCeUser.setUser_name("qq");
		zhuCeUser.setUser_password("123456");
		zhuCeUser.setUser_phonenum("111111");
		zhuCeUser.setUser_email("auhccj@163.com");
		int rows = dao.insert(zhuCeUser);
		System.out.println(rows);
		
	}
	@Test
	public void testFindZhuCeUser(){
		ZhuCeDao bean = ctx.getBean("zhuCeDao",ZhuCeDao.class);
		ZhuCeUser findZhuCeUser = bean.findZhuCeUser("ccj");
		System.out.println(findZhuCeUser);
	}
}
