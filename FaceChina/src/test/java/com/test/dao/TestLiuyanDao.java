package com.test.dao;

import java.util.List;

import org.junit.Test;

import com.fc.main.dao.LiuyanDao;
import com.fc.main.entity.Liuyan;
import com.test.TestBase;

public class TestLiuyanDao extends TestBase{
	@Test
	public void testFindData(){

		LiuyanDao dao = ctx.getBean("liuyanDao",LiuyanDao.class);
		List<Liuyan> findLiuyan = dao.findLiuyan(1);
		for (Liuyan liuyan : findLiuyan) {
			
			System.out.println(liuyan);
		}
				
	}
}
