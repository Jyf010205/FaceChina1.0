package com.fc.main.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.AddShuoShuoDao;
import com.fc.main.dao.ShuoPictureDao;
import com.fc.main.dao.ShuoUserDao;
import com.fc.main.entity.Shuo;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.AddShuoShuoService;
@Service
public class AddShuShuoServiceImpl implements AddShuoShuoService{
	@Autowired
	private AddShuoShuoDao addShuoShuoDao;
	@Autowired
	private ShuoUserDao shuoUserDao;
	@Autowired
	private ShuoPictureDao shuoPictureDao;
	@Override
	public String AddShuoShuo(Shuo shuo ,Integer pricture_id) {
		//参数合法性检查
		if(pricture_id==null||pricture_id<1)
			throw new IllegalArgumentException("请先添加一张图片来表达此刻的心情吧");
		if(shuo.getShuo_text()==null||shuo.getShuo_text()=="")
			throw new IllegalArgumentException("添加说说内容不能为空");
		addShuoShuoDao.addShuoShuo(shuo);
		//添加shiro安全认证后从token里获取userid，目前暂时写死7:测试用户
		ZhuCeUser userEmail = (ZhuCeUser)SecurityUtils.getSubject().getPrincipal();
		int user_id = userEmail.getUser_id();
		shuoUserDao.insertReleationShip(user_id, shuo.getShuo_id());
		//插入说说和图片的关系表
		shuoPictureDao.insertShuoPicture(shuo.getShuo_id(), pricture_id);
		return "添加说说成功";
	}
}

