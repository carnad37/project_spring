package com.test.dto;

public class Cmember {
	
	private String id;
	private String pw;
	private String name;
	private int cNum;
	
	
	public Cmember() {
	}

	public Cmember(String id, String pw, String name, int cNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.cNum = cNum;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	
}
