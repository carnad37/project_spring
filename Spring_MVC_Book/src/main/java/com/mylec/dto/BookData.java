package com.mylec.dto;

public class BookData {

	private String bookNum;
	private String name;
	private String author;
	private String publisher;
	private int price;
	private boolean checkOuted;
	
	public BookData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookData(String bookNum, String name, String author, String publisher, int price, boolean checkOuted) {
		super();
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
	public boolean isCheckOuted() {
		return checkOuted;
	}
	public void setCheckOuted(boolean checkOuted) {
		this.checkOuted = checkOuted;
	}
	
	
	
}
