package com.fc.main.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.FSSDao;
import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.entity.ShuoShuoPingLunResult;
import com.fc.main.entity.TianJiaPingLunEntity;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.HaoYouDongTaiService;

@Service
public class HaoYouDongTaiServiceImpl implements HaoYouDongTaiService {

	@Autowired
	private FSSDao fSSDao;

	@Override
	public List<FriendShuoShuoDaoResult> findHaoYouShuo(Integer userid) {
		List<Integer> friendIds = fSSDao.findFSSFriendIdsByUserId(userid);//查好友id
		//Integer[] friend_friendids=(Integer[]) friendIds.toArray();
		System.out.println(friendIds.toString());
		List<FriendShuoShuoDaoResult> zhengheshuoshuo = new ArrayList<FriendShuoShuoDaoResult>();
		for (Integer friend_friendids : friendIds) {
			List<FriendShuoShuoDaoResult> findShuoShuo = fSSDao.findShuoShuo(friend_friendids);//好友id查好友说说
			for (FriendShuoShuoDaoResult friendShuoShuoDaoResult : findShuoShuo) {
				if(friendShuoShuoDaoResult.getUser_shuo_shuoid()==null) {
					continue;
				}
					zhengheshuoshuo.add(friendShuoShuoDaoResult);//每一个说说放进了总说说集合
			}
		}
		return zhengheshuoshuo;
	}
	
	@Override
	public List<ShuoShuoPingLunResult> findALLPingLun(Integer shuo_id) {
		List<ShuoShuoPingLunResult> findPingLun = fSSDao.findPingLun(shuo_id);
		System.out.println(findPingLun);
		return findPingLun;
	}

	@Override
	//userid 从shiro获取
	public int saveObject(String ping_content,Integer shuo_ping_shuoid) {
		TianJiaPingLunEntity entity = new TianJiaPingLunEntity();
		ZhuCeUser zhuCeUser = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		int ping_userid = zhuCeUser.getUser_id();
		entity.setPing_userid(ping_userid);
		entity.setPing_content(ping_content);
		int rows = fSSDao.insertObject(entity);
		fSSDao.insertObjects(shuo_ping_shuoid, entity.getPing_id());
		return rows;
	}

	@Override
	public void dianZan(Integer shuo_id) {
		Integer rowCount = fSSDao.updateLikeCount(shuo_id);
		if (rowCount==0||rowCount==null) {
			throw new IllegalArgumentException("没查找到对应说说，有可能已被作者删除");
		}
	}

	@Override
	public int insert(Integer ping_id, Integer shuo_id) {
		int rows = fSSDao.insertObjects(ping_id, shuo_id);
		return rows;
	}

	@Override
	public int insertObject(TianJiaPingLunEntity entity) {
		entity.setPing_userid(1);
		fSSDao.insertpinglun(entity);
		int ping_id = fSSDao.findPingshuo(entity.getPing_userid(),entity.getPing_content());
		entity.setPing_id(ping_id);
		int rows = fSSDao.insertpingshuo(entity);
		return rows;
	}
}




