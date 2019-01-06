package com.thzm.eye025.bean;

public class Professor {
	
	private String Name;
	private String content;
	private String photo;
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professor(String name, String content, String photo, int id) {
		super();
		Name = name;
		this.content = content;
		this.photo = photo;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Professor [Name=" + Name + ", content=" + content + ", photo=" + photo + ", id=" + id + "]";
	}
	
	
	
}
