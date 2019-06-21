package com.test.dto;

public class BookData {
	/*
	 checkOuted가 false인 모든 레코드 정보를 출력하세요 
	 price가  10000 이상인 인 모든 레코드의 name를 출력하세요
	 bookNum에  390이 들어가 있는 모든 레코드들의 name, checkOuted를 출력하세요 
	 author에  red 가 들어가 있는 모든 레코드들의  publisher를 출력하세요 
	*/
	private String bookNum;
	private String name;
	private String author;
	private String publisher;
	private int price;
	private boolean checkOuted;	
	
	
	public BookData() {
		// TODO Auto-generated constructor stub
	}

	public BookData(String bookNum, String name, String author, String publisher, int price, boolean checkOuted) {
		this.bookNum = bookNum;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.checkOuted = checkOuted;
	}
	
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isCheckouted() {
		return checkouted;
	}
	public void setCheckouted(boolean checkouted) {
		this.checkouted = checkouted;
	}
	
	
	
}
