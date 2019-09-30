package com.test;

import java.util.List;
import org.junit.Test;
import com.fc.main.dao.FSSDao;
import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.entity.ShuoShuoPingLunResult;

public class TestFSSDao extends TestBase{

	@Test
	public void testShuo() {
		FSSDao dao=ctx.getBean("FSSDao", FSSDao.class);
		List<FriendShuoShuoDaoResult> shuo = dao.findShuoShuo(1,2);
		for (FriendShuoShuoDaoResult friendShuoShuoDaoResult : shuo) {
			System.out.println(friendShuoShuoDaoResult);
		}
	}
	
	@Test
	public void testShuoShuoPingLun() {
		FSSDao dao=ctx.getBean("FSSDao", FSSDao.class);
		List<ShuoShuoPingLunResult> findPingLun = dao.findPingLun(3);
		for (ShuoShuoPingLunResult shuoShuoPingLunVo : findPingLun) {
			System.out.println(shuoShuoPingLunVo);
		}
	}
}
