package com.fc.main.service;
import java.util.List;
import com.fc.main.entity.FriendShuoShuoDaoResult;
import com.fc.main.entity.ShuoShuoPingLunResult;
import com.fc.main.entity.TianJiaPingLunEntity;

public interface HaoYouDongTaiService {
	/**
	 * @param userid 当前用户id
	 * @return
	 */
	List<FriendShuoShuoDaoResult> findHaoYouShuo(Integer userid);
	
	List<ShuoShuoPingLunResult> findALLPingLun(Integer shuoId);
	
	int saveObject(String ping_content,Integer shuo_ping_shuoid);
	/**点赞*/
	void dianZan(Integer shuo_id);
	
	int insert(Integer ping_id,Integer shuo_id);
	
	int insertObject(TianJiaPingLunEntity entity);
	
}
