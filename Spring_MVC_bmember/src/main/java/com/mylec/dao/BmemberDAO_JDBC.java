package com.mylec.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mylec.dto.Bmember;

public class BmemberDAO_JDBC implements BmemberDAO {

	private JdbcTemplate JdbcTemplate;
	
	public BmemberDAO_JDBC(JdbcTemplate jdbcTemplate) {
		super();
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public String getPwById(String id) {
		String pw = null;
		String SQL = "SELECT pw FROM bmember WHERE id = ?";
		try {
			pw = JdbcTemplate.queryForObject(SQL, new Object[] {id}, String.class);
		} catch (EmptyResultDataAccessException e) { 
			System.out.println("DAO_JDBC : getPwById, No Data");			
		} catch (DataAccessException e) {
			System.out.println("DAO_JDBC : getPwById Fail...");
		}
		System.out.println("data : " + pw);
		return pw;
	}

	@Override
	public Bmember getDataById(String id) {
		Bmember bmember = null;
		String SQL = "SELECT pw, name FROM bmember WHERE id = ?";
		try {
			bmember = JdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Bmember>(Bmember.class));
		} catch (EmptyResultDataAccessException e) { 
			System.out.println("DAO_JDBC : getDataById, No Data");			
		} catch (DataAccessException e) {
			System.out.println("DAO_JDBC : getDataById Fail...");
		}
		return bmember;
	}

	@Override
	public List<String> getIdByName(String name) {
		List<String> idList= null;
		String SQL = "SELECT id FROM bmember WHERE name = ?";
		try {
			idList = JdbcTemplate.queryForList(SQL, new Object[] {name}, String.class);
		} catch (EmptyResultDataAccessException e) { 
			System.out.println("DAO_JDBC : getIdByName, No Data");			
		} catch (DataAccessException e) {
			System.out.println("DAO_JDBC : getIdByName Fail...");
		}
		return idList;
	}

	@Override
	public List<Bmember> getDataByName(String name) {
		List<Bmember> memberList= null;
		String SQL = "SELECT id, pw FROM bmember WHERE name = ?";
		try {
			memberList = JdbcTemplate.query(SQL, new Object[] {name}, new BeanPropertyRowMapper<Bmember>(Bmember.class));
		} catch (DataAccessException e) {
			System.out.println("DAO_JDBC : getDataByName Fail...");
		}
		return memberList;
	}

}
