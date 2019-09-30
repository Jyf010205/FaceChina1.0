package com.fc.main.entity;

/**
 * wangwei
 */

public class ViewFriendsEntity {
	private int user_id;
	private int user_pictureid;
	private String user_name;
	private String user_gender;
	private int user_age;
	private String user_colleage;
	private Integer[] friend_ids;

	public int getUser_pictureid() {
		return user_pictureid;
	}

	public void setUser_pictureid(int user_pictureid) {
		this.user_pictureid = user_pictureid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_colleage() {
		return user_colleage;
	}

	public void setUser_colleage(String user_colleage) {
		this.user_colleage = user_colleage;
	}

	public Integer[] getFriend_ids() {
		return friend_ids;
	}

	public void setFriend_ids(Integer[] friend_ids) {
		this.friend_ids = friend_ids;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
