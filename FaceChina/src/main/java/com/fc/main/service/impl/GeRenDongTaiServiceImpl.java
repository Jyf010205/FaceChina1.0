package com.fc.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fc.main.dao.GeRenDongTaiDao;
import com.fc.main.exception.ServiceException;
import com.fc.main.service.GeRenDongTaiService;
import com.fc.main.vo.GeRenPingLunVO;
import com.fc.main.vo.GeRenShuoVO;
import com.fc.main.vo.PageObject;

@Service
public class GeRenDongTaiServiceImpl implements GeRenDongTaiService{
	@Autowired
	private GeRenDongTaiDao geRenDongTaiDao;
	
	public PageObject<GeRenShuoVO> findGeRenShuo(
			String userEmail){
		PageObject<GeRenShuoVO> po = new PageObject<GeRenShuoVO>();
		List<GeRenShuoVO> list = geRenDongTaiDao.findGeRenShuo(userEmail);
		for (GeRenShuoVO geRenShuoVO : list) {
			if(geRenShuoVO.getShuo_text()==null)
//				throw new ServiceException("您的个人空间没有说说发表");
				System.out.println(geRenShuoVO.getUser_name()+"的个人空间没有说说");
		}
			
		po.setRecodes(list); 
		int shuoCount=geRenDongTaiDao.getShuoCount(userEmail);
		po.setRowCount(shuoCount);
		return po;
	}
	
	public int deleteGeRenDongTai(Integer shuoId){
		
		int rows=geRenDongTaiDao.deleteShuoByShuoId(shuoId);
		geRenDongTaiDao.deleteUserShuoByShuoId(shuoId);
		
		Integer picture_id = geRenDongTaiDao.findPictureIdByShuoId(shuoId);
		if(picture_id!=null){
			geRenDongTaiDao.deletePictureByPictureId(picture_id);		
			geRenDongTaiDao.deleteShuoPictureByShuoId(shuoId);
		}else{
			System.out.println("被删除的"+shuoId+"号说说没有对应图片");
		}
		
		List<Integer> pingIds = geRenDongTaiDao.findPingIdsByShuoId(shuoId);
		Boolean flag=false;
		for (Integer pingId : pingIds) {
			if(pingId!=null){
				flag=true;
			}
		}
		if(flag){
			geRenDongTaiDao.deleteShuoPingByShuoId(shuoId);
			geRenDongTaiDao.deletePingByPingIds(pingIds);		
		}else{
			System.out.println("被删除的"+shuoId+"号说说没有对应评论");
		}
		return rows;
		
	}

	@Override
	public PageObject<GeRenPingLunVO> findGeRenPingLun(Integer shuoId) {
		PageObject<GeRenPingLunVO> po = new PageObject<GeRenPingLunVO>();
		List<GeRenPingLunVO> list = geRenDongTaiDao.findGeRenPingLun(shuoId);	
		if(list.isEmpty()){
//			throw new ServiceException(shuoId+"号说说暂无评论");
			System.out.println(shuoId+"号说说暂无评论");
		}

		po.setRecodes(list);
		int pingCount=geRenDongTaiDao.getPingCount(shuoId);
		po.setRowCount(pingCount);
		return po;
	}

}
