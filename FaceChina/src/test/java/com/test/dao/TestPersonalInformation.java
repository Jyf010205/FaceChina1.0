package com.test.dao;

import org.junit.Test;

import com.fc.main.dao.PersonalInformationDao;
import com.fc.main.entity.PersonalInformation;
import com.test.TestBase;

public class TestPersonalInformation extends TestBase {
	
	@Test
	public void showPersonalInformation() {
		PersonalInformationDao pid = 
				ctx.getBean("personalInformationDao",PersonalInformationDao.class);
	
		System.out.println("个人信息如下：");
		PersonalInformation pif = pid.showPersonalInformation(1);
		System.out.println(pif);
	}
}
