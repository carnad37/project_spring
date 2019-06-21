package com.test.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.test.dto.PostData;

public class PostDAO {

	private JdbcTemplate jdbcTemplate;

	public PostDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	queryForList, query 두가지로 구현,
	BeanPropertyRowMapper를 이용 구현하세요

	*/
//	1.postNum이 200060 인 모든 레코드 정보를 출력하세요

	public List<PostData> getByPostNum(int postNum) {
		String SQL = "SELECT * FROM postNum WHERE postNum = ?";
		List<PostData> postList = null;
		try {
			postList = jdbcTemplate.query(SQL, new Object[] {postNum}, new BeanPropertyRowMapper<PostData>(PostData.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postList;
	}
	
	public List<Map<String, Object>> getByPostNum_QFL(int postNum) {
		String SQL = "SELECT * FROM postNum WHERE postNum = ?";
		List<Map<String, Object>> postMap = null;
		try {
			postMap = jdbcTemplate.queryForList(SQL, new Object[] {postNum});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postMap;
	}
	
//	2.streetName 이 '길'로 끝나는 레코드들의 postNum,houseNum을 출력하세요 

	public List<PostData> getByStreetName(String lastWord) {
		String SQL = "SELECT * FROM postNum WHERE streetName like ?";
		List<PostData> postList = null;
		try {
			postList = jdbcTemplate.query(SQL, new Object[] {"%" + lastWord}, new BeanPropertyRowMapper<PostData>(PostData.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postList;
	}
	
	public List<Map<String, Object>> getByStreetName_QFL(String lastWord) {
		String SQL = "SELECT * FROM postNum WHERE streetName like ?";
		List<Map<String, Object>> postMap = null;
		try {
			postMap = jdbcTemplate.queryForList(SQL, new Object[] {"%" + lastWord});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postMap;
	}
	
//	3.houseNum이 307, 793인 postNum을 모두 출력하세요 

	public List<PostData> getByHouseNum(int fisrtNum, int secondNum) {
		String SQL = "SELECT * FROM postNum WHERE houseNum = ? OR houseNum = ?";
		List<PostData> postList = null;
		try {
			postList = jdbcTemplate.query(SQL, new Object[] {fisrtNum, secondNum}, new BeanPropertyRowMapper<PostData>(PostData.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postList;
	}
	
	public List<Map<String, Object>> getByHouseNum_QFL(int fisrtNum, int secondNum) {
		String SQL = "SELECT * FROM postNum WHERE houseNum = ? OR houseNum = ?";
		List<Map<String, Object>> postMap = null;
		try {
			postMap = jdbcTemplate.queryForList(SQL, new Object[] {fisrtNum, secondNum});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postMap;
	}
}
