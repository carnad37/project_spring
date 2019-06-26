package com.mylec.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mylec.dto.BookData;

public class BookDAOImpl implements BookDAO {
	
	private JdbcTemplate jdbcTemplate;

	public BookDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BookData> getDataByCheckOuted(boolean checkOuted) {
		String SQL = "SELECT * FROM bookInfo WHERE checkOuted = ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {checkOuted}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {
			System.out.println("DAO : getDataByCheckOuted Fail...");
		}
		return bookList;
	}
	
	public List<String> getNameByPriceOver(int price) {
		String SQL = "SELECT name FROM bookInfo WHERE price >= ?";
		List<String> nameList = null;
		try {
			nameList = jdbcTemplate.queryForList(SQL, new Object[] {price}, String.class);
		} catch (DataAccessException e) {
			System.out.println("DAO : getNameByPrice Fail...");
		}
		return nameList;
	}
	
	public List<BookData> getDataByBookNum(String bookNum) {
		String SQL = "SELECT * FROM bookInfo WHERE name = ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {bookNum}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {
			System.out.println("DAO : getDataByBookNum Fail...");
		}
		return bookList;
	}
	

	public List<String> getPublisherByAuthor(String author) {
		String SQL = "SELECT publisher FROM bookInfo WHERE author like ?";
		List<String> publList = null;
		try {
			publList = jdbcTemplate.queryForList(SQL, new Object[] {"%" + author + "%"}, String.class);
		} catch (DataAccessException e) {
			System.out.println("DAO : getNameByPrice Fail...");
		}
		return publList;
	}
}
