package com.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dto.BookData;

public class BookDAO {

	private JdbcTemplate jdbcTemplate;

	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	
	public List<BookData> getByCheckOuted(boolean checkOuted) {
		String SQL = "SELECT * FROM bookinfo WHERE checkOuted = ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {checkOuted}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookList;
	}
	
	public List<Map<String, Object>> getByCheckOuted_QFL(boolean checkOuted) {
		String SQL = "SELECT * FROM bookinfo WHERE checkOuted = ?";
		List<Map<String, Object>> bookMap = null;
		try {
			bookMap = jdbcTemplate.queryForList(SQL, new Object[] {checkOuted});
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookMap;
	}	
	
	public List<BookData> getByPrice(int price) {
		String SQL = "SELECT * FROM bookinfo WHERE price >= ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {price}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookList;
	}
	
	public List<Map<String, Object>> getByPrice_QFL(int price) {
		String SQL = "SELECT * FROM bookinfo WHERE price >= ?";
		List<Map<String, Object>> bookMap = null;
		try {
			bookMap = jdbcTemplate.queryForList(SQL, new Object[] {price});
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookMap;
	}	
	
	public List<BookData> getByBookNum(String bookNum) {
		String SQL = "SELECT * FROM bookinfo WHERE bookNum = ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {"%" + bookNum + "%"}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookList;
	}
	
	public List<Map<String, Object>> getByBookNum_QFL(String bookNum) {
		String SQL = "SELECT * FROM bookinfo WHERE bookNum = ?";
		List<Map<String, Object>> bookMap = null;
		try {
			bookMap = jdbcTemplate.queryForList(SQL, new Object[] {"%" + bookNum + "%"});
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookMap;
	}	
	
	public List<BookData> getByAuthor(String author) {
		String SQL = "SELECT * FROM bookinfo WHERE author = ?";
		List<BookData> bookList = null;
		try {
			bookList = jdbcTemplate.query(SQL, new Object[] {"%" + author + "%"}, new BeanPropertyRowMapper<BookData>(BookData.class));
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookList;
	}
	
	public List<Map<String, Object>> getByAuthor_QFL(String author) {
		String SQL = "SELECT * FROM bookinfo WHERE author = ?";
		List<Map<String, Object>> bookMap = null;
		try {
			bookMap = jdbcTemplate.queryForList(SQL, new Object[] {"%" + author + "%"});
		} catch (DataAccessException e) {	
			// TODO: handle exception
		}
		return bookMap;
	}	
}
