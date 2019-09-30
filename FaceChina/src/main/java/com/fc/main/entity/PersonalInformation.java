package com.fc.main.entity;

import java.io.Serializable;
import java.util.Date;

public class PersonalInformation implements Serializable {
	private static final long serialVersionUID = -2638348446009670158L;
	private Integer user_id;
	private String user_name;
	private String user_email;
	private String user_phonenum;
	private String user_gender;
	private String user_birthday;
	private String user_age;
	private String user_star;
	private String user_colleage;
	private String user_note;
	private Integer user_pictureid;
	
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phonenum() {
		return user_phonenum;
	}
	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getUser_star() {
		return user_star;
	}
	public void setUser_star(String user_star) {
		this.user_star = user_star;
	}
	public String getUser_colleage() {
		return user_colleage;
	}
	public void setUser_colleage(String user_colleage) {
		this.user_colleage = user_colleage;
	}
	public String getUser_note() {
		return user_note;
	}
	public void setUser_note(String user_note) {
		this.user_note = user_note;
	}
	public Integer getUser_pictureid() {
		return user_pictureid;
	}
	public void setUser_pictureid(Integer user_pictureid) {
		this.user_pictureid = user_pictureid;
	}
	@Override
	public String toString() {
		return "PersonalInformation [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_phonenum=" + user_phonenum + ", user_gender=" + user_gender + ", user_birthday="
				+ user_birthday + ", user_age=" + user_age + ", user_star=" + user_star + ", user_colleage="
				+ user_colleage + ", user_note=" + user_note + ", user_pictureid=" + user_pictureid + "]";
	}
	
}
