package com.fc.main.entity;

import java.io.Serializable;
import java.util.Date;




public class Liuyan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 156591069636168736L;
	private Integer id;
	private Integer user_id;
	private Integer friend_id;
	private String content;
	private Date createtime;
	private Integer readstate;
	private String user_name;
	
	
	@Override
	public String toString() {
		return "Liuyan [id=" + id + ", user_id=" + user_id + ", friend_id=" + friend_id + ", content=" + content
				+ ", createtime=" + createtime + ", readstate=" + readstate + ", user_name=" + user_name + "]";
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(Integer friend_id) {
		this.friend_id = friend_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getReadstate() {
		return readstate;
	}
	public void setReadstate(Integer readstate) {
		this.readstate = readstate;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
