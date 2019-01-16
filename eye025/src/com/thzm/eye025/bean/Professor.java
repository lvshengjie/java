package com.thzm.eye025.bean;

public class Professor {
	
	private String Name;
	private String content;
	private String photo;
	private int depid;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professor(String name, String content, String photo, int depid) {
		super();
		Name = name;
		this.content = content;
		this.photo = photo;
		this.depid = depid;
	}
	@Override
	public String toString() {
		return "Professor [Name=" + Name + ", content=" + content + ", photo=" + photo + ", depid=" + depid + "]";
	}

	
	
	
}
