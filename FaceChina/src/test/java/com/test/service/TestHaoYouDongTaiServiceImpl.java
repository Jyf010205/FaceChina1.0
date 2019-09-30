package com.test.service;

import java.util.List;

import org.junit.Test;
import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.service.impl.HaoYouDongTaiServiceImpl;
import com.fc.main.vo.PageObject;
import com.test.TestBase;

public class TestHaoYouDongTaiServiceImpl extends TestBase{

	@Test
	public void testHaoYouDongTaiServiceImpl() {
		HaoYouDongTaiServiceImpl service = 
				ctx.getBean("haoYouDongTaiServiceImpl", HaoYouDongTaiServiceImpl.class);
		List<FriendShuoShuoDaoResult> findHaoYouShuo = service.findHaoYouShuo(1);
		for (FriendShuoShuoDaoResult friendShuoShuoDaoResult : findHaoYouShuo) {
			System.out.println(friendShuoShuoDaoResult);
		}
	}
}
