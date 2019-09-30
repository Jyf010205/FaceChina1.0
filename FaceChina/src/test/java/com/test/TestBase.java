package com.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestBase {
	public  ClassPathXmlApplicationContext ctx;
	@Before//一般用来初始化
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@Test
	public void textCpx() {
		System.out.println(ctx);
	}
	//读取基层配置文件
	@Test
	public void testProperties() {
		//获取bean对象
		Object cfg = ctx.getBean("cfg");
		//获取bean对象的具体类型
		Class<? extends Object> class1 = cfg.getClass();
		System.out.println(cfg);
		System.out.println(class1.getName());
	}
	@After//一般用来销毁的资源
	public void destroy() {
		ctx.close();//spring bean容器
	}
}
