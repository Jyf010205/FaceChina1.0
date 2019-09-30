package com.fc.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.ZhaoHuiPwdService;
import com.fc.main.utils.JavaEmailSender;
import com.fc.main.vo.JsonResult;
@Controller
public class ZhaoHuiPwdController {
	@Autowired
	private ZhaoHuiPwdService zhaoHuiPwdService;
	Integer intFlag1 = (int)(Math.random() * 1000000);
	@RequestMapping("doUpDateZhuCeUser")
	@ResponseBody
	public JsonResult doUpDateZhuCeUser(ZhuCeUser zhuCeUser,String newPwd,String SecondPwd,String intFlag){
		String s1 = Integer .toString(intFlag1);
		/*if(intFlag==null||intFlag=="")
			throw new IllegalArgumentException("请输入验证码");*/
		System.out.println(intFlag);
		System.out.println(intFlag1);
		System.out.println(s1.equals(intFlag));
		if(!s1.equals(intFlag)){
			throw new IllegalArgumentException("验证码不正确");
		}else{
			zhaoHuiPwdService.updatePassword(zhuCeUser,
					newPwd, SecondPwd);
			
		}
		
		return new JsonResult("找回成功");
	}
	
	@RequestMapping("mail1")
	@ResponseBody
    public JsonResult mailSucc(HttpServletRequest request) throws Exception{
         String toEMAIL = request.getParameter("mail");         //对方邮箱
          String TITLE = "FaceChina官网账号注册验证码";       //标题
          String CONTENT ="您的验证码为："+intFlag1+"            如非本人操作，请忽略...";        //内容
          JavaEmailSender.sendEmail(toEMAIL, TITLE, CONTENT);
        return new JsonResult("/mailSucc");
    }
}
