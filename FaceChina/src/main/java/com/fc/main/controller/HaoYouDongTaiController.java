package com.fc.main.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.entity.ShuoShuoPingLunResult;
import com.fc.main.entity.TianJiaPingLunEntity;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.HaoYouDongTaiService;
import com.fc.main.vo.JsonResult;

@Controller
public class HaoYouDongTaiController {
	@Autowired
	HaoYouDongTaiService haoYouDongTaiService;
	@RequestMapping("doFindHaoYouShuo.fc")
	@ResponseBody
	public JsonResult doFindHaoYouShuo() {
		ZhuCeUser zhuCeUser = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		int user_id = zhuCeUser.getUser_id();
		List<FriendShuoShuoDaoResult> list = haoYouDongTaiService.findHaoYouShuo(user_id);
		return new JsonResult(list);
	}
	@RequestMapping("doFindALLPingLun.fc")
	@ResponseBody
	public JsonResult doFindALLPingLun(Integer shuoId) {
		List<ShuoShuoPingLunResult> list = haoYouDongTaiService.findALLPingLun(shuoId);
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@ResponseBody
	@RequestMapping("doSavePingLun.fc")
	public JsonResult doSavePingLun(String ping_content,Integer shuo_ping_shuoid) {
		haoYouDongTaiService.saveObject(ping_content, shuo_ping_shuoid);
		return new JsonResult("评论成功");
	}
	
	@RequestMapping("doHaoYouDianZan")
	@ResponseBody
	public JsonResult doHaoYouDianZan(Integer shuo_id) {
		System.out.println("shuo_id"+shuo_id);
		haoYouDongTaiService.dianZan(shuo_id);
		return new JsonResult("点赞成功");
	}
	
	@ResponseBody
	@RequestMapping("doinsertObjects")
	public JsonResult doinsertObjects(TianJiaPingLunEntity entity) {
		haoYouDongTaiService.insertObject(entity);
		return new JsonResult("评论成功");
	}
}
