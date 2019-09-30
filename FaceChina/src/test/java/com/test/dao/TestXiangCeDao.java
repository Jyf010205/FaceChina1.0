package com.test.dao;

import java.util.List;

import org.junit.Test;

import com.fc.main.dao.XiangCeDao;
import com.fc.main.entity.Image;
import com.test.TestBase;

public class TestXiangCeDao extends TestBase{
	@Test
	public void insert() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		xiangCeDao.insert(new Image("123", "123"));
	}
	@Test
	public void findUrl() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		List<String> strings = xiangCeDao.findSrc(1);
		System.out.println(strings);
	}
	@Test
	public void findpictureidBypicturename() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		Integer id = xiangCeDao.findpictureidBypicturename("101号图片");
		System.out.println(id);
	}
	@Test
	public void insertSrc() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		Integer id = xiangCeDao.insertSrc(5, 6);
		System.out.println(id);
	}
	@Test
	public void updatehead() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		int rows = xiangCeDao.updatehead(2, 1);
		System.out.println(rows);
	}
	@Test
	public void finduserprctureurl() {
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		String finduserprctureurl = xiangCeDao.finduserprctureurl(1);
		System.out.println(finduserprctureurl);
	}
	
}
