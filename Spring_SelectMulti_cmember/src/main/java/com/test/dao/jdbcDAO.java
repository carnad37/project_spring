package com.test.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.test.dto.Cmember;

public class jdbcDAO implements CmemberDAO {

	private JdbcTemplate JdbcTemplate;
	
	public jdbcDAO(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Cmember> getByIdStartWord(String idStartWord) {
		String SQL = "SELECT * FROM cmember WHERE id like ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = JdbcTemplate.query(SQL, new Object[] {idStartWord + "%"}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return memberList;
	}

	@Override
	public List<Cmember> getByOvercNum(int cNum) {
		String SQL = "SELECT * FROM cmember WHERE cNum >= ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = JdbcTemplate.query(SQL, new Object[] {cNum}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return memberList;
	}

	@Override
	public List<Cmember> getByNameLast(String nameLast) {
		String SQL = "SELECT * FROM cmember WHERE name like ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = JdbcTemplate.query(SQL, new Object[] {"%" + nameLast}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}

		return memberList;
	}

	@Override
	public List<Cmember> getByPWStartWord(String pwStartWord) {
		String SQL = "SELECT * FROM cmember WHERE pw like ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = JdbcTemplate.query(SQL, new Object[] {pwStartWord + "%"}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return memberList;
	}

}
