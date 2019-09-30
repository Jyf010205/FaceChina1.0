package com.fc.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.ReiMenDao;
import com.fc.main.entity.Shuo;
import com.fc.main.exception.ServiceException;
import com.fc.main.service.ReiMenService;
@Service
public class ReiMenServiceImpl implements ReiMenService {

	@Autowired
	private ReiMenDao reiMenDao;
	@Override
	public List<Shuo> getShuosOrderByLikecount() {
		List<Shuo> shuos = reiMenDao.getShuosOrderByLikecount();
		//System.out.println("service层"+shuos);
		return shuos;
	}
	@Override
	public void dianZan(int shuo_id) {
		Integer rowCount = reiMenDao.updateLikeCount(shuo_id);
		if (rowCount==0||rowCount==null) {
			throw new ServiceException("没查找到对应说说，有可能已被作者删除");
		}
		
	}

}
