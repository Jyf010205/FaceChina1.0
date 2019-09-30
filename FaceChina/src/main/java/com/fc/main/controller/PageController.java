package com.fc.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("update")
	public String update() {
		return "update";
	}
	@RequestMapping("hello")
	public String test() {
		return "首页";
	}
	@RequestMapping("login")
	public String login() {
		return"login/注册";
	}
	
	@RequestMapping("xiangce")
	public String xiangce(){
		return"div/相册";
	}
	@RequestMapping("reimendt")
	public String reimendt() {
		return "div/热门动态";
	}
	@RequestMapping("tianjiahaoyou")
	public String tianjiahaoyou() {
		return "div/添加好友";
	}
	@RequestMapping("xiugaimima")
	public String xiugaimima() {
		return "div/用户密码修改";
	}
	@RequestMapping("chakanhaoyou")
	public String chakanhaoyou() {
		return "div/好友列表";
	}
	
	@RequestMapping("fenye")
	public String fenye() {
		return "div/分页";
	}
	@RequestMapping("tianjiaxiangpian")
	public String tianjiaxiangpian() {
		return "div/添加相片";
	}
	@RequestMapping("tianjiashuoshuo")
	public String tianjiashuoshuo() {
		return "div/添加说说";
	}
	@RequestMapping("gerenxinxi")
	public String gerenxinxi() {
		return "div/个人信息呈现";
	}
	@RequestMapping("bianjigerenxinxi")
	public String bianjigerenxinxi() {
		return "div/编辑个人信息";
	}
	@RequestMapping("haoyoudongtai")
	public String haoyoudongtai() {
		return "div/好友动态";
	}
	@RequestMapping("xiugaitouxiang")
	public String xiugaitouxiang() {
		return "div/修改个人头像";
	}
	@RequestMapping("showview")
	public String showview() {
		return "div/showview";
	}
	
	@RequestMapping("enter")
	public String enter(){
		return "login/登录";
	}
	@RequestMapping("reset")
	public String reset(){
		return "login/重设密码";
	}
	@RequestMapping("write")
	public String write(){
		return "login/请先登录";
	}
	
	
}
