package com.fc.main.dao;

import java.util.List;

import com.fc.main.entity.Shuo;

public interface ReiMenDao {
	List<Shuo> getShuosOrderByLikecount();
	
	int updateLikeCount(int shuo_id);
}
