package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.dao.BookDAO;
import com.test.dto.BookData;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:server-connect.xml");
		BookDAO dao = (BookDAO)context.getBean("bookDAO");
		
		
	}
	
	public static void printAll(List<BookData> bookList) {
		for (BookData bookData : bookList) {
			System.out.println("bookNum : " + bookData.getBookNum());
			System.out.println("name : " + bookData.getName());
			System.out.println("author : " + bookData.getAuthor());
			System.out.println("publisher : " + bookData.getPublisher());
			System.out.println("price : " + bookData.getPrice());
		}
	}
}

