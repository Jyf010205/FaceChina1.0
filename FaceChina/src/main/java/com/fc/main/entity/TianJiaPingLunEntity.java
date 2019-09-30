package com.fc.main.entity;

import java.io.Serializable;
import java.util.Date;

public class TianJiaPingLunEntity implements Serializable{

	private static final long serialVersionUID = 4017800580054942294L;
	private Integer shuo_id;		//说说id
	private Integer ping_id;		//评论id
	private Integer ping_userid;	//评论人id
	private String ping_content;	//评论内容
	private Date ping_creattime;	//评论时间
	public Integer getShuo_id() {
		return shuo_id;
	}
	public void setShuo_id(Integer shuo_id) {
		this.shuo_id = shuo_id;
	}
	public Integer getPing_id() {
		return ping_id;
	}
	public void setPing_id(Integer ping_id) {
		this.ping_id = ping_id;
	}
	public Integer getPing_userid() {
		return ping_userid;
	}
	public void setPing_userid(Integer ping_userid) {
		this.ping_userid = ping_userid;
	}
	public String getPing_content() {
		return ping_content;
	}
	public void setPing_content(String ping_content) {
		this.ping_content = ping_content;
	}
	public Date getPing_creattime() {
		return ping_creattime;
	}
	public void setPing_creattime(Date ping_creattime) {
		this.ping_creattime = ping_creattime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TianJiaPingLunEntity [shuo_id=" + shuo_id + ", ping_id=" + ping_id + ", ping_userid=" + ping_userid
				+ ", ping_content=" + ping_content + ", ping_creattime=" + ping_creattime + "]";
	}
	
}
