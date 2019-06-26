package com.mylec.service;

import java.util.List;

import com.mylec.dao.BookDAO;
import com.mylec.dto.BookData;

public class BookService {

	private BookDAO dao;

	public BookService(BookDAO dao) {
		super();
		this.dao = dao;
	}
	
	public List<String> getPublisherByAuthor(String author) {
		return dao.getPublisherByAuthor(author);
	}
		
	public List<BookData> getNameANDCheckOutedByBookNum(String bookNum) {
		return dao.getDataByBookNum(bookNum);
	}

	public List<String> getNameByPriceOver(int price) {
		return dao.getNameByPriceOver(price);
	}

	public List<BookData> getDataByCheckOuted(boolean checkOuted) {
		return dao.getDataByCheckOuted(checkOuted);
	}

}
