package com.fc.main.vo;

import java.util.List;

import com.fc.main.entity.Shuo;

public class ShuoPicture {
	private Shuo shuo;
	private List<Integer> pictureId;
	public Shuo getShuo() {
		return shuo;
	}
	public void setShuo(Shuo shuo) {
		this.shuo = shuo;
	}
	
	public List<Integer> getPicture() {
		return pictureId;
	}
	public void setPicture(List<Integer> picture) {
		this.pictureId = picture;
	}
	@Override
	public String toString() {
		return "ShuoPicture [shuo=" + shuo + ", picture=" + pictureId + "]";
	}
	

}
