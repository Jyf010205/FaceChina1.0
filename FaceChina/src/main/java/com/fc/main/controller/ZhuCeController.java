package com.fc.main.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.ZhuCeService;
import com.fc.main.utils.JavaEmailSender;
import com.fc.main.vo.JsonResult;

@Controller
public class ZhuCeController {
	@Autowired
	private ZhuCeService zhuCeService;
	Integer intFlag1 = (int)(Math.random() * 1000000);
	@RequestMapping("doSaveZhuCeUser")
	@ResponseBody
	public JsonResult doSaveZhuCeUser(ZhuCeUser zhuCeUser,String secondPwd,String intFlag){
		String s1 = Integer .toString(intFlag1);
		/*if(intFlag==null||intFlag=="")
			throw new IllegalArgumentException("请输入验证码");*/
		System.out.println(intFlag);
		System.out.println(intFlag1);
		System.out.println(s1.equals(intFlag));
		if(!s1.equals(intFlag)){
			throw new IllegalArgumentException("验证码不正确");
		}else{
			
			zhuCeService.saveZhuCeUser(zhuCeUser, secondPwd);
		}
		
		return new JsonResult("注册成功");
	}
	
	@RequestMapping("mail")
	@ResponseBody
    public JsonResult mailSucc(HttpServletRequest request) throws Exception{
         String toEMAIL = request.getParameter("mail");         //对方邮箱
          String TITLE = "FaceChina官网账号注册验证码";       //标题
          String CONTENT ="您的验证码为："+intFlag1+"            如非本人操作，请忽略...";        //内容
          JavaEmailSender.sendEmail(toEMAIL, TITLE, CONTENT);
        return new JsonResult("/mailSucc");
    }
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doEnter(String user_email,String user_password){
		//1.获取Subject对象
		   Subject subject=SecurityUtils.getSubject();
		   //2.通过Subject提交用户信息,交给shiro框架进行认证操作
		   //2.1对用户进行封装
		   UsernamePasswordToken token=
		   new UsernamePasswordToken(
				   user_email,//身份信息
				   user_password);//凭证信息
	
		   //2.2对用户信息进行身份认证
		   System.out.println("token:"+token);
		   subject.login(token);
		   //分析:
		   //1)token会传给shiro的SecurityManager
		   //2)SecurityManager将token传递给认证管理器
		   //3)认证管理器会将token传递给realm
		   return new JsonResult("登录成功");
	}
	
}
	 
	
	

