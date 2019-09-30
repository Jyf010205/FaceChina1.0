package com.fc.main.controller;
/**
 * wangwei
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fc.main.entity.ViewFriendsEntity;
import com.fc.main.service.FcViewFriendsService;
import com.fc.main.vo.JsonResult;

@Controller
public class ViewFriendsController {
	@Autowired
	private FcViewFriendsService fcViewFriendsService;

	@RequestMapping("doFindFriends")
	@ResponseBody
	public JsonResult doFindFriends() {
		List<ViewFriendsEntity> list = fcViewFriendsService.findFriends();
		return new JsonResult(list);
	}
	
	@RequestMapping("doDeleteFriends")
	@ResponseBody
	public JsonResult doDeleteFriends(Integer friend_friendid) {
		fcViewFriendsService.deleteFriends(friend_friendid);
		return new JsonResult("取消关注成功");
	}
	
	@RequestMapping("doInsertLiuyan")
	@ResponseBody
	public JsonResult doInsertLiuyan(@RequestParam("user_id")Integer friend_id,String content) {
		System.out.println("控制层的friend_id"+friend_id);
		fcViewFriendsService.insertLiuyan(friend_id, content);
		return new JsonResult("留言成功");
	}
}
