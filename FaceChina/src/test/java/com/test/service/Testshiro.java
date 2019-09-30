package com.test.service;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.TestBase;

public class Testshiro extends TestBase{
	@Test
	public void testshiro() {
		 ctx = new ClassPathXmlApplicationContext("spring-shiro.xml");
		ShiroFilterFactoryBean bean = ctx.getBean(ShiroFilterFactoryBean.class);
		System.out.println(bean);
	}
}
