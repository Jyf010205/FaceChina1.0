package com.fc.main.entity;

import java.util.List;

public class FindnotfriendUser {
	
	private Integer user_id;
	private String user_name;
	private String user_age;
	private String user_gender;
	private String user_colleage;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_colleage() {
		return user_colleage;
	}
	public void setUser_colleage(String user_colleage) {
		this.user_colleage = user_colleage;
	}
	@Override
	public String toString() {
		return "FindnotfriendUser [user_id=" + user_id + ", user_name=" + user_name + ", user_age=" + user_age
				+ ", user_gender=" + user_gender + ", user_colleage=" + user_colleage + "]";
	}
	
	
	
	
	
}
