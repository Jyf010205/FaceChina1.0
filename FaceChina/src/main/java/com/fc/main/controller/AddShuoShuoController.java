package com.fc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.main.entity.Shuo;
import com.fc.main.service.AddShuoShuoService;
import com.fc.main.vo.JsonResult;

@Controller
public class AddShuoShuoController {
	@Autowired
	private AddShuoShuoService addShuoShuoService;
	
	@RequestMapping("doAddShuo")
	@ResponseBody
	public JsonResult doAddShuo(Shuo s,Integer pricture_id) {
		System.out.println("从前端发来参数中pricture_id是"+pricture_id);
		addShuoShuoService.AddShuoShuo(s,pricture_id);
		return new JsonResult("发表说说成功");
	}
}
