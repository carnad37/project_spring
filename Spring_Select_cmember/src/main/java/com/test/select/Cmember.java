package com.test.select;

public class Cmember {

	private String id;
	private String pw;
	private String name;
	private int cNum;
	
	public Cmember() {
		
	}
	
	public Cmember(String id, String pw, String name, int cNum) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.cNum = cNum;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public int getcNum() {
		return cNum;
	}	
}
