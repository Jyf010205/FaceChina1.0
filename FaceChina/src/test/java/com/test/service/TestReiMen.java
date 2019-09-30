package com.test.service;

import java.util.List;

import org.junit.Test;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import com.fc.main.entity.Shuo;
import com.fc.main.service.impl.ReiMenServiceImpl;
import com.test.TestBase;

public class TestReiMen extends TestBase {
	@Test
	public void getShuosOrderByLikecount() {
		ReiMenServiceImpl sRei = ctx.getBean("reiMenServiceImpl", ReiMenServiceImpl.class);
		List<Shuo> list = sRei.getShuosOrderByLikecount();
		for (Shuo shuo : list) {
			
			System.out.println("service的shuo"+shuo );
		}
	}
}
