package com.fc.main.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.entity.PersonalInformation;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.PersonalInformationService;
import com.fc.main.vo.JsonResult;

@Controller

public class PersonalInformationController {
	@Autowired
	PersonalInformationService personalInformationService;
	@ResponseBody
	@RequestMapping("doPersonalInformaitonUI")
	public JsonResult PersonalInformationUI() {
		ZhuCeUser user = (ZhuCeUser)SecurityUtils.getSubject().getPrincipal();
		int userid=user.getUser_id();
		PersonalInformation fpib = 
				personalInformationService.findPersonalInformationById(userid);
		return new JsonResult(fpib);
	}
	
	
	@ResponseBody
	@RequestMapping("doPersonalInformationUI2") 
	public JsonResult PersonalInformationUI2(PersonalInformation pi) {
		//PersonalInformation pi=new PersonalInformation();
		personalInformationService.modifyPersonalInformationById(pi);
		System.out.println("ok");
	return new JsonResult("update ok")	;
	}
}
