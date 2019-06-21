package com.test.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemDao implements JdbcDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> getDataListSearchById(String id) {
		return jdbcTemplate.queryForList("SELECT * FROM bmember WHERE Id = ?", id);
	}
	
	public List getName() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForList("SELECT * FROM bmember");
	}
	

}
