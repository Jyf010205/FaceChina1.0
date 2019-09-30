package com.test.service;

import org.junit.Test;

import com.fc.main.entity.Shuo;
import com.fc.main.service.impl.AddShuShuoServiceImpl;
import com.test.TestBase;

public class TestAddShuoShuo extends TestBase {
	@Test
	public void doAddShuo() {
		AddShuShuoServiceImpl addShuobean = ctx.getBean("addShuShuoServiceImpl", AddShuShuoServiceImpl.class);
		Shuo shuo=new Shuo();
		//shuo.setShuo_text("test添加说说，数据不具有真实性 again");
		addShuobean.AddShuoShuo(shuo, null);
	}
}
