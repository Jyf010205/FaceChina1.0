package com.test.myBatis;

import java.util.List;

import org.junit.Test;

import com.fc.main.dao.ReiMenDao;
import com.fc.main.entity.Shuo;
import com.fc.main.vo.ShuoPicture;
import com.test.TestBase;

public class TestReiMenDao extends TestBase {
	@Test
	public void dogetShuosOrderByLikecount() {
		ReiMenDao reiDao = ctx.getBean("reiMenDao", ReiMenDao.class);
		List<Shuo > objects = reiDao.getShuosOrderByLikecount();
		for (Shuo shuo : objects) {
			System.out.println(shuo.toString());
		}
	}
	
}
