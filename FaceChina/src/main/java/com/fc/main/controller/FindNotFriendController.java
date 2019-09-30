package com.fc.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fc.main.entity.FindnotfriendUser;
import com.fc.main.service.FindNotFriendSerivce;
import com.fc.main.vo.JsonResult;

@Controller
public class FindNotFriendController {

	@Autowired
	private FindNotFriendSerivce findNotFriendSerivce;

	@RequestMapping("FindNotFriend")
	@ResponseBody
	public JsonResult FindNotFriend() {
		List<FindnotfriendUser> file = findNotFriendSerivce.findnotfriend();
		return new JsonResult(file);
	}
	@RequestMapping("insertfriend")
	@ResponseBody
	public JsonResult insertfriend(Integer friend_friendid) {
		findNotFriendSerivce.insertfriend(friend_friendid);
		return new JsonResult("add ok");
	}
	
}
