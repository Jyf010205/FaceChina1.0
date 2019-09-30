package com.fc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.main.entity.Liuyan;
import com.fc.main.service.LiuyanService;
import com.fc.main.vo.JsonResult;
import com.fc.main.vo.PageObject;

@RestController
public class LiuyanController {
	@Autowired
	private LiuyanService liuyanService;
	@RequestMapping("doFindLiuyan")
	public JsonResult doFindLiuyan(Integer user_id){
		PageObject<Liuyan> liuyanpage = liuyanService.findLiuyanPage(user_id);
		return new JsonResult(liuyanpage);
		
	}
	@RequestMapping("doFindLiuyanAll")
	public JsonResult doFindLiuyanAll(Integer user_id){
		PageObject<Liuyan> liuyanallpage = liuyanService.findLiuyanAllPage(user_id);
		return new JsonResult(liuyanallpage);
		
	}
}
