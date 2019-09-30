package com.fc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.service.FindNotFriendSerivce;
import com.fc.main.service.XiuGaiMMSerivce;
import com.fc.main.vo.JsonResult;

@Controller
public class XiuGaiMMController {

	@Autowired
	private XiuGaiMMSerivce xiuGaiMMSerivce;
	@RequestMapping("XiuGaiMM")
	@ResponseBody
	public JsonResult XiuGaiMM(String username,
			String password,
			String newpassword,
			String cfgpassword){
		xiuGaiMMSerivce.updatePassword(password, newpassword, cfgpassword);
		return new JsonResult("修改成功");
	}
	
	
}
