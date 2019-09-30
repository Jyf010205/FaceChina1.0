package com.fc.main.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ShuoShuoPingLunResult implements Serializable{
	private static final long serialVersionUID = 6706392116469208297L;
	private Integer shuo_id;				//说说id
	private String user_name;				//评论者名字
	private Integer user_shuo_shuoid;		//用户对应的说说id
	private Integer shuo_ping_pingid;		//说说对应的评论id
	private Integer ping_userid;			//评论者id
	private Timestamp ping_createtime;		//评论时间
	private String ping_content;			//评论内容
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_shuo_shuoid() {
		return user_shuo_shuoid;
	}
	public void setUser_shuo_shuoid(Integer user_shuo_shuoid) {
		this.user_shuo_shuoid = user_shuo_shuoid;
	}
	public Integer getShuo_ping_pingid() {
		return shuo_ping_pingid;
	}
	public void setShuo_ping_pingid(Integer shuo_ping_pingid) {
		this.shuo_ping_pingid = shuo_ping_pingid;
	}
	public Integer getPing_userid() {
		return ping_userid;
	}
	public void setPing_userid(Integer ping_userid) {
		this.ping_userid = ping_userid;
	}
	public Timestamp getPing_createtime() {
		return ping_createtime;
	}
	public void setPing_createtime(Timestamp ping_createtime) {
		this.ping_createtime = ping_createtime;
	}
	public String getPing_content() {
		return ping_content;
	}
	public void setPing_content(String ping_content) {
		this.ping_content = ping_content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getShuo_id() {
		return shuo_id;
	}
	public void setShuo_id(Integer shuo_id) {
		this.shuo_id = shuo_id;
	}
	@Override
	public String toString() {
		return "ShuoShuoPingLunResult [shuo_id=" + shuo_id + ", user_name=" + user_name + ", user_shuo_shuoid="
				+ user_shuo_shuoid + ", shuo_ping_pingid=" + shuo_ping_pingid + ", ping_userid=" + ping_userid
				+ ", ping_createtime=" + ping_createtime + ", ping_content=" + ping_content + "]";
	}
	
	
}
