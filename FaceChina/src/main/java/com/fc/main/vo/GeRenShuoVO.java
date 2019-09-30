package com.fc.main.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class GeRenShuoVO implements Serializable{
	
	private String user_name;				//用户名
	private String user_shuo_userid;		//用户id
	private Integer user_shuo_shuoid;		//说说id
	private String 	shuo_text;				//说说文字内容，text类型
	private Timestamp	shuo_createtime;	//说说创建时间，datetime类型
	//private Integer	shuo_likecount;		//说说点赞数	
	private Integer shuo_picture_pictureid;	//说说对应的图片id	
	private String picture_name;			//图片名称
	private String picture_src;				//图片路径
//	private Integer shuo_ping_pingid;		//说说对应的评论id
//	private Integer ping_userid;			//评论者id
//	private Timestamp ping_createtime;		//评论时间
//	private String ping_content;			//评论内容
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_shuo_userid() {
		return user_shuo_userid;
	}
	public void setUser_shuo_userid(String user_shuo_userid) {
		this.user_shuo_userid = user_shuo_userid;
	}
	public Integer getUser_shuo_shuoid() {
		return user_shuo_shuoid;
	}
	public void setUser_shuo_shuoid(Integer user_shuo_shuoid) {
		this.user_shuo_shuoid = user_shuo_shuoid;
	}
	public String getShuo_text() {
		return shuo_text;
	}
	public void setShuo_text(String shuo_text) {
		this.shuo_text = shuo_text;
	}
	public Timestamp getShuo_createtime() {
		return shuo_createtime;
	}
	public void setShuo_createtime(Timestamp shuo_createtime) {
		this.shuo_createtime = shuo_createtime;
	}
	public Integer getShuo_picture_pictureid() {
		return shuo_picture_pictureid;
	}
	public void setShuo_picture_pictureid(Integer shuo_picture_pictureid) {
		this.shuo_picture_pictureid = shuo_picture_pictureid;
	}
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
	public String getPicture_src() {
		return picture_src;
	}
	public void setPicture_src(String picture_src) {
		this.picture_src = picture_src;
	}
	@Override
	public String toString() {
		return "GeRenShuoVO [user_name=" + user_name + ", user_shuo_userid=" + user_shuo_userid + ", user_shuo_shuoid="
				+ user_shuo_shuoid + ", shuo_text=" + shuo_text + ", shuo_createtime=" + shuo_createtime
				+ ", shuo_picture_pictureid=" + shuo_picture_pictureid + ", picture_name=" + picture_name
				+ ", picture_src=" + picture_src + "]";
	}

	
	
	
}
