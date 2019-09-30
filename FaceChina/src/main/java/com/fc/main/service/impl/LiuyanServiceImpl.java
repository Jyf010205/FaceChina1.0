package com.fc.main.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.LiuyanDao;
import com.fc.main.entity.Liuyan;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.LiuyanService;
import com.fc.main.vo.PageObject;
@Service
public class LiuyanServiceImpl implements LiuyanService{
	@Autowired
	private LiuyanDao liuyanDao;
	@Override
	public PageObject<Liuyan> findLiuyanPage(Integer user_id) {
		//1.验证参数合法性
		//获取页面的用户id
		
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		user_id=user.getUser_id();
		
		List<Liuyan> recodes = liuyanDao.findLiuyan(user_id);
		
//		for (Liuyan liuyan : recodes) {
//			System.out.println(liuyan);
//		}
		//for (Liuyan liuyan : recodes) {
			//if (liuyan.getReadstate()==0) {
				
			//}
		//}
		PageObject<Liuyan> pageObject = new PageObject<Liuyan>();
		pageObject.setRecodes(recodes);
		return pageObject;
	}
	@Override
	public PageObject<Liuyan> findLiuyanAllPage(Integer user_id) {
		ZhuCeUser user = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		user_id=user.getUser_id();
		List<Liuyan> findLiuyanAll = liuyanDao.findLiuyanAll(user_id);
		PageObject<Liuyan> pageObject = new PageObject<Liuyan>();
		pageObject.setRecodes(findLiuyanAll);
		return pageObject;
	}
	
	

}
