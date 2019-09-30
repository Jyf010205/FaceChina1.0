package com.fc.main.service.impl;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.fc.main.dao.PersonalInformationDao;
import com.fc.main.entity.PersonalInformation;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.PersonalInformationService;

@Service //默认存储对象时名字为“类名” 首字母要小写
public class PersonalInformationServiceImpl 
	implements PersonalInformationService {
	@Autowired
	private PersonalInformationDao personalInformationDao;
	public PersonalInformation findPersonalInformationById(Integer user_id) {
		if(user_id==0||user_id==null) {
			throw new IllegalArgumentException("页码值不正确！");
		}
		PersonalInformation showPersonalInformation = personalInformationDao.showPersonalInformation(user_id);
		return showPersonalInformation;
	}
	@Override
	public int modifyPersonalInformationById(
			PersonalInformation pi) {
		ZhuCeUser user = (ZhuCeUser)SecurityUtils.getSubject().getPrincipal();
		int userid=user.getUser_id();
		pi.setUser_id(userid);
//		//1.参数有效性验证
//		if(pi==null) 
//			throw new IllegalArgumentException("没有填写内容！");
//		if(StringUtils.isEmpty(pi.getUser_name()))
//			throw new IllegalArgumentException("用户名不能为空！");
//		if(StringUtils.isEmpty(pi.getUser_email()))
//			throw new IllegalArgumentException("邮箱不能为空！");
//		if(StringUtils.isEmpty(pi.getUser_phonenum()))
//			throw new IllegalArgumentException("手机号码不能为空！");
		//2.将数据写入数据库
		
		int rows=personalInformationDao.modifyPersonalInformation(pi);
		
		return rows;
	}
}
