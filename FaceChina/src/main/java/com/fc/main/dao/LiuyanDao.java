package com.fc.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.main.entity.Liuyan;

public interface LiuyanDao {
	List<Liuyan> findLiuyan(@Param("user_id")Integer user_id);
	List<Liuyan> findLiuyanAll(@Param("user_id")Integer user_id);
}
