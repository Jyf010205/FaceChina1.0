package com.test.service;

import org.junit.Test;

import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.ZhuCeService;
import com.test.TestBase;

public class TestZhuCeService extends TestBase {
	@Test
	public void testSaveZhuCeUser(){
		ZhuCeService zhuCeService = ctx.getBean("zhuCeServiceImpl",ZhuCeService.class);
		ZhuCeUser zhuCeUser=new ZhuCeUser();
		zhuCeUser.setUser_name("qq");
		zhuCeUser.setUser_email("auhccj@163.com");
		zhuCeUser.setUser_phonenum("999999");
		zhuCeUser.setUser_password("123456");
		int rows = zhuCeService.saveZhuCeUser(zhuCeUser, "123456");
		System.out.println(rows);
	}
}
