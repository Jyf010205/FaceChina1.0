package com.fc.main.service;

import java.util.List;
import java.util.Map;

import com.fc.main.entity.Shuo;

public interface ReiMenService {
	List<Shuo> getShuosOrderByLikecount();
	
	void dianZan(int shuo_id) ;
}
