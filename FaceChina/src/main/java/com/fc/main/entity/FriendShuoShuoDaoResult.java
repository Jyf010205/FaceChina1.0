package com.fc.main.entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
public class FriendShuoShuoDaoResult implements Serializable {
	private static final long serialVersionUID = 937256354881599935L;
	private String user_name;						//用户名
	private Integer user_shuo_userid;				//发说说的id=用户id
	private Integer user_shuo_shuoid;				//所有说说id
	private String shuo_text;						//说说内容
	private Timestamp shuo_createtime;				//说说创建时间
	private Integer shuo_likecount;					//说说点赞数
	private Integer shuo_picture_pictureid;			//说说对应图片id
	private String picture_src;						//图片对应url
	private List<FriendShuoShuoDaoResult> findShuoShuo;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_shuo_userid() {
		return user_shuo_userid;
	}
	public void setUser_shuo_userid(Integer user_shuo_userid) {
		this.user_shuo_userid = user_shuo_userid;
	}
	public Integer getUser_shuo_shuoid() {
		return user_shuo_shuoid;
	}
	public void setUser_shuo_shuoid(Integer user_shuo_shuoid) {
		this.user_shuo_shuoid = user_shuo_shuoid;
	}
	public String getShuo_text() {
		return shuo_text;
	}
	public void setShuo_text(String shuo_text) {
		this.shuo_text = shuo_text;
	}
	public Timestamp getShuo_createtime() {
		return shuo_createtime;
	}
	public void setShuo_createtime(Timestamp shuo_createtime) {
		this.shuo_createtime = shuo_createtime;
	}
	public Integer getShuo_likecount() {
		return shuo_likecount;
	}
	public void setShuo_likecount(Integer shuo_likecount) {
		this.shuo_likecount = shuo_likecount;
	}
	public Integer getShuo_picture_pictureid() {
		return shuo_picture_pictureid;
	}
	public void setShuo_picture_pictureid(Integer shuo_picture_pictureid) {
		this.shuo_picture_pictureid = shuo_picture_pictureid;
	}
	public String getPicture_src() {
		return picture_src;
	}
	public void setPicture_src(String picture_src) {
		this.picture_src = picture_src;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<FriendShuoShuoDaoResult> getFindShuoShuo() {
		return findShuoShuo;
	}
	public void setFindShuoShuo(List<FriendShuoShuoDaoResult> findShuoShuo) {
		this.findShuoShuo = findShuoShuo;
	}
	@Override
	public String toString() {
		return "FriendShuoShuoDaoResult [user_name=" + user_name + ", user_shuo_userid=" + user_shuo_userid
				+ ", user_shuo_shuoid=" + user_shuo_shuoid + ", shuo_text=" + shuo_text + ", shuo_createtime="
				+ shuo_createtime + ", shuo_likecount=" + shuo_likecount + ", shuo_picture_pictureid="
				+ shuo_picture_pictureid + ", picture_src=" + picture_src + ", findShuoShuo=" + findShuoShuo + "]";
	}

	
	
	
	
}
