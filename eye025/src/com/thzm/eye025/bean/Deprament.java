package com.thzm.eye025.bean;

public class Deprament {
	
	private String sname;
	private String piam;
	private String content;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPiam() {
		return piam;
	}
	public void setPiam(String piam) {
		this.piam = piam;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Deprament() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deprament(String sname, String piam, String content) {
		super();
		this.sname = sname;
		this.piam = piam;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Deprament [sname=" + sname + ", piam=" + piam + ", content=" + content + "]";
	}
	
	
}
