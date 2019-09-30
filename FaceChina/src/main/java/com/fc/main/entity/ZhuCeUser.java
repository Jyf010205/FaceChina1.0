package com.fc.main.entity;

import java.io.Serializable;

public class ZhuCeUser implements Serializable{

	private static final long serialVersionUID = -4120950864284788362L;
	/**ID*/
	private int user_id;
	/**名字*/
	private String user_name;
	/**密码*/
	private String user_password;
	/**邮箱*/
	private String user_email;
	/**电话号码*/
	private String user_phonenum;
	/**盐值*/
	private String user_salt;
	public String getUser_salt() {
		return user_salt;
	}
	public void setUser_salt(String user_salt) {
		this.user_salt = user_salt;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
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
	@Override
	public String toString() {
		return "ZhuCeUser [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_email=" + user_email + ", user_phonenum=" + user_phonenum + ", user_salt=" + user_salt + "]";
	}
	
	
	
}
