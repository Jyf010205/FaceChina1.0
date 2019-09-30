package com.fc.main.service;


import com.fc.main.entity.Liuyan;
import com.fc.main.vo.PageObject;

public interface LiuyanService {
	PageObject<Liuyan> findLiuyanPage(Integer user_id);
	
	PageObject<Liuyan> findLiuyanAllPage(Integer user_id);
	
}
