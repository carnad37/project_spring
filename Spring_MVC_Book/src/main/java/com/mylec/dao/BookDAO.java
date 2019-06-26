package com.mylec.dao;

import java.util.List;

import com.mylec.dto.BookData;

public interface BookDAO {

	public List<BookData> getDataByCheckOuted(boolean checkOuted);
	
	public List<String> getNameByPriceOver(int price);
	
	public List<BookData> getDataByBookNum(String bookNum);
	
	public List<String> getPublisherByAuthor(String author);

}
