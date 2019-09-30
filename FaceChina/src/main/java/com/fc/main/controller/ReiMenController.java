package com.fc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.main.entity.Shuo;
import com.fc.main.service.ReiMenService;
import com.fc.main.vo.JsonResult;

@RestController
public class ReiMenController {
	@Autowired
	private ReiMenService reiMenService;
	
	@RequestMapping("doGetReiMen")
	public JsonResult doGetReiMen() {
		List<Shuo> shuos = reiMenService.getShuosOrderByLikecount();
		return new JsonResult(shuos);
		
	}
	
	@RequestMapping("doDianZan")
	public JsonResult doDianZan(int shuo_id) {
		System.out.println("shuo_id"+shuo_id);
		reiMenService.dianZan(shuo_id);
		return new JsonResult("点赞成功");
	}
}
