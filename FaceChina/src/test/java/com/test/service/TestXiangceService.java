package com.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.fc.main.service.XiangCeSerivce;
import com.test.TestBase;

public class TestXiangceService extends TestBase{
	@Test
	public void TestinsertImage() throws Exception {
		XiangCeSerivce xiangCeSerivce = ctx.getBean(XiangCeSerivce.class);
		MultipartFile pictureFile = null;
		int rows = xiangCeSerivce.insertImage(pictureFile);
		System.out.println(rows);
	}
	@Test
	public void TestFindSrc() {
		XiangCeSerivce xiangCeSerivce = ctx.getBean(XiangCeSerivce.class);
		List<String> list = xiangCeSerivce.findSrc();
		System.out.println(list);
	}
}
