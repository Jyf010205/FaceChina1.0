package com.test;


import javax.sql.DataSource;

import org.junit.Test;

public class TestDataSource extends TestBase{
	@Test
	public void textDruidDataSource() throws Exception {
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		System.out.println(ds.getConnection());
	}
	//DataSource相当于mybatis的数据源，mybatis和这个都是要实现DataSource里面的连接池pool，可以看下DataSource源码
}
