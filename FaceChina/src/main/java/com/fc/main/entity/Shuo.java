package com.fc.main.entity;

import java.util.Date;

public class Shuo {
	private int shuo_id;
	private String shuo_text;
	private Date shuo_createtime;
	private int shuo_likecount;
	private String picture_src;
	public String getPicture_src() {
		return picture_src;
	}
	public void setPicture_src(String picture_src) {
		this.picture_src = picture_src;
	}
	public int getShuo_id() {
		return shuo_id;
	}
	public void setShuo_id(int shuo_id) {
		this.shuo_id = shuo_id;
	}
	public String getShuo_text() {
		return shuo_text;
	}
	public void setShuo_text(String shuo_text) {
		this.shuo_text = shuo_text;
	}
	public Date getShuo_createtime() {
		return shuo_createtime;
	}
	public void setShuo_createtime(Date shuo_createtime) {
		this.shuo_createtime = shuo_createtime;
	}
	public int getShuo_likecount() {
		return shuo_likecount;
	}
	public void setShuo_likecount(int shuo_likecount) {
		this.shuo_likecount = shuo_likecount;
	}
	
	@Override
	public String toString() {
		return "Shuo [shuo_id=" + shuo_id + ", shuo_text=" + shuo_text + ", shuo_createtime=" + shuo_createtime
				+ ", shuo_likecount=" + shuo_likecount + ", picture_src=" + picture_src + "]";
	}

	
	
}
