package com.test.dao;

import org.junit.Test;

import com.fc.main.dao.PersonalInformationDao;
import com.fc.main.entity.PersonalInformation;
import com.test.TestBase;

public class TestmodifyPI extends TestBase {
	@Test
	public void showPI() {
		PersonalInformationDao dao = 
				ctx.getBean("personalInformationDao", 
						PersonalInformationDao.class);
		System.out.println("当前的PI");
		PersonalInformation cpi = dao.showPersonalInformation(1);
		System.out.println(cpi);
		
	}
	@Test
	public void modifyPI() {
		PersonalInformationDao dao = 
				ctx.getBean("personalInformationDao", 
						PersonalInformationDao.class);
		 PersonalInformation pI = new PersonalInformation();
		 pI.setUser_id(1);
		 pI.setUser_age("18");
		 pI.setUser_birthday("1988-12-22");	
		 pI.setUser_colleage("北京大学");
		 pI.setUser_email("123456@qq.com");
		 pI.setUser_gender("女");
		 pI.setUser_name("张小仙");
		 pI.setUser_note("我是小仙女！");
		 pI.setUser_phonenum("1234567890");
		 pI.setUser_pictureid(123456);
		 pI.setUser_star("摩羯座");
		int rows = dao.modifyPersonalInformation(pI );
		System.out.println(rows);
		
	}
}
