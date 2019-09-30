package com.test;
import java.util.List;
import org.junit.Test;
import com.fc.main.dao.FSSDao;

public class TestFindFriendId extends TestBase {

	@Test
	public void testFindFriendIdsByUserId() {
		FSSDao dao=ctx.getBean(
				"FSSDao", FSSDao.class);
		List<Integer> ids = dao.findFSSFriendIdsByUserId(2);
		for (Integer id : ids) {
			System.out.println(id);
		}
	}
}
