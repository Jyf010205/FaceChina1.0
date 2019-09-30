package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.fc.main.dao.XiangCeDao;
import com.fc.main.entity.Image;

public class TestMybatis extends TestBase{
	@Test
	public void testSqlSession() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		xiangCeDao.insert(new Image("123", "123"));
		
	}
}
