package com.thzm.eye025wx.bean;

import java.sql.Date;

public class Abstract {
		
	private int id;
	private String picture1,picture2,picture3;
	private String conten;
	private boolean publish_status;
	private Date publish_data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getPicture3() {
		return picture3;
	}
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	public String getConten() {
		return conten;
	}
	public void setConten(String conten) {
		this.conten = conten;
	}
	public boolean isPublish_status() {
		return publish_status;
	}
	public void setPublish_status(boolean publish_status) {
		this.publish_status = publish_status;
	}
	public Date getPublish_data() {
		return publish_data;
	}
	public void setPublish_data(Date publish_data) {
		this.publish_data = publish_data;
	}
	public Abstract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Abstract(int id, String picture1, String picture2, String picture3, String conten, boolean publish_status,
			Date publish_data) {
		super();
		this.id = id;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
		this.conten = conten;
		this.publish_status = publish_status;
		this.publish_data = publish_data;
	}
	@Override
	public String toString() {
		return "Abstract [id=" + id + ", picture1=" + picture1 + ", picture2=" + picture2 + ", picture3=" + picture3
				+ ", conten=" + conten + ", publish_status=" + publish_status + ", publish_data=" + publish_data + "]";
	}
	
	
	
	
}
