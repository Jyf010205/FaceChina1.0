package com.test.dao;


import org.junit.Test;

import com.fc.main.dao.AddShuoShuoDao;
import com.fc.main.dao.ShuoUserDao;
import com.fc.main.entity.Shuo;
import com.test.TestBase;

public class TestAddShuoShuo extends TestBase {
	@Test
	public void doAddShuoShuo() {
		AddShuoShuoDao sdao = ctx.getBean("addShuoShuoDao", AddShuoShuoDao.class);
		Shuo shuo=new Shuo();
		shuo.setShuo_text("test添加说说，数据不具有真实性");
		sdao.addShuoShuo(shuo);
	}
	
	@Test
	public void doAddRelationship() {
		ShuoUserDao dao = ctx.getBean("shuoUserDao", ShuoUserDao.class);
		dao.insertReleationShip(3, 8);
		System.out.println("关系数据保存成功");
		
	}
}
