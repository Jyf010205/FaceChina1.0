package com.fc.main.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class GeRenPingLunVO implements Serializable{
	
	private Integer shuo_id;		//说说id
	private Integer shuo_ping_pingid;		//说说对应的评论id
	private Integer ping_userid;			//评论者id
	private Timestamp ping_createtime;		//评论时间
	private String ping_content=" ";			//评论内容
	private String user_name;
	public Integer getShuo_id() {
		return shuo_id;
	}
	public void setShuo_id(Integer shuo_id) {
		this.shuo_id = shuo_id;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "GeRenPingLunVO [shuo_id=" + shuo_id + ", shuo_ping_pingid=" + shuo_ping_pingid + ", ping_userid="
				+ ping_userid + ", ping_createtime=" + ping_createtime + ", ping_content=" + ping_content
				+ ", user_name=" + user_name + "]";
	}

}
