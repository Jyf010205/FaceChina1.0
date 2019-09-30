package com.fc.main.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.GeRenDongTaiService;
import com.fc.main.service.impl.GeRenDongTaiServiceImpl;
import com.fc.main.vo.GeRenPingLunVO;
import com.fc.main.vo.GeRenShuoVO;
import com.fc.main.vo.JsonResult;
import com.fc.main.vo.PageObject;

@Controller
public class GeRenDongTaiController {
	
	@Autowired
	private GeRenDongTaiService geRenDongTaiService;
	
	@RequestMapping("findGeRenShuo")
	@ResponseBody
	public JsonResult findGeRenShuo(){
		ZhuCeUser user = (ZhuCeUser)SecurityUtils.getSubject().getPrincipal();
		String userEmail=user.getUser_email();
		System.out.println(userEmail);
		PageObject<GeRenShuoVO> po = 
				geRenDongTaiService.findGeRenShuo(userEmail);
		return new JsonResult(po);
	}
	
	@RequestMapping("findGeRenPingLun")
	@ResponseBody
	public JsonResult findGeRenPingLun(Integer shuoId){
		PageObject<GeRenPingLunVO> po = 
				geRenDongTaiService.findGeRenPingLun(shuoId);
		return new JsonResult(po);
	}
	
	@RequestMapping("deleteGeRenDongTai")
	@ResponseBody
	public JsonResult deleteGeRenDongTai(Integer shuoId){
		geRenDongTaiService.deleteGeRenDongTai(shuoId);
		System.out.println(shuoId+"号说说被删除");
		return new JsonResult("删除个人说说成功");
	}
	
	@RequestMapping("geRenDongTai")
	public String loadGeRenDongTai(){
		return "div/个人动态";
	}
}
