package com.test.xml_bean;

public class RemoteControl {
	private VodPlayer vp = null;
	private String name = null;
	private int ch;

	public VodPlayer getVp() {
		return vp;
	}
	public void setVp(VodPlayer vp) {
		this.vp = vp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}
	
	public int getChannNum() {
		return this.ch;
	}
}
