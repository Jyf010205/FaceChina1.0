package com.test.service;

import org.junit.Test;

import com.fc.main.entity.PersonalInformation;
import com.fc.main.service.PersonalInformationService;
import com.fc.main.service.impl.PersonalInformationServiceImpl;
import com.test.TestBase;

public class TestPIService extends TestBase {

	@Test
	public void showPI() {
		PersonalInformationService pfs = 
				ctx.getBean("personalInformationServiceImpl", 
						PersonalInformationServiceImpl.class );
		PersonalInformation fpb = pfs.findPersonalInformationById(1);
		System.out.println(fpb);
	}
	
}
