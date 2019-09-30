package com.fc.main.service;

import java.util.List;

import com.fc.main.vo.GeRenPingLunVO;
import com.fc.main.vo.GeRenShuoVO;
import com.fc.main.vo.PageObject;

public interface GeRenDongTaiService {
	
	PageObject<GeRenShuoVO> findGeRenShuo(String userEmail);
	
	PageObject<GeRenPingLunVO> findGeRenPingLun(Integer shuoId);
	
	int deleteGeRenDongTai(Integer shuoId);
	
}
