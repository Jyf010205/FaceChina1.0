package com.fc.main.entity;

import java.io.Serializable;

public class Image implements Serializable{
	private static final long serialVersionUID = 1775733287678538036L;
	private Integer picture_id;
	private String picture_name;
	private String picture_src;
	
	public int getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
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
	public Image(String picture_name, String picture_src) {
		super();
		this.picture_name = picture_name;
		this.picture_src = picture_src;
	}
	@Override
	public String toString() {
		return "Image [picture_id=" + picture_id + ", picture_name=" + picture_name + ", picture_src=" + picture_src
				+ "]";
	}
	
	
}
