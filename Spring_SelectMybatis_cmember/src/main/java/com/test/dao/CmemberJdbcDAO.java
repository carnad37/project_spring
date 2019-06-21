package com.test.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dto.Cmember;

public class CmemberJdbcDAO implements CmemberDAO {

	private JdbcTemplate jdbcTemplate;

	public CmemberJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Integer getRecordNum() {
		String SQL = "SELECT * FROM cmember";
		int count = 0;
		try {
			count = jdbcTemplate.queryForList(SQL).size();
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public List<String> getPwById(String id) {
		String SQL = "SELECT pw FROM cmember WHERE id = ?";
		List<String> list = new LinkedList<String>();
		try {
			list = jdbcTemplate.queryForList(SQL, new Object[] {id}, String.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<String> getIdByCNum(int cNum) {
		String SQL = "SELECT id FROM cmember WHERE cNum = ?";
		List<String> list = new LinkedList<String>();
		try {
			list = jdbcTemplate.queryForList(SQL, new Object[] {cNum}, String.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<Cmember> getDataByNameANDCNum(Cmember cmember) {
		String SQL = "SELECT * FROM cmember WHERE name = ? AND cNum =?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = jdbcTemplate.query(SQL, new Object[] {cmember.getName(), cmember.getcNum()}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			
		}
		return memberList;
	}

	@Override
	public int setRecord(Cmember cmember) {
		String SQL = "INSERT INTO cmember(id, pw, name,cNum) VALUES(?, ?, ?, ?)";
		int retval = 0;
		try {
			retval = jdbcTemplate.update(SQL, new Object[] {cmember.getId(), cmember.getPw(), cmember.getName(), cmember.getcNum()});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return retval;
	}

	@Override
	public void delRecordByPw(String pw) {
		String SQL = "DELETE FROM cmember WHERE pw = ?";	
		try {
			jdbcTemplate.update(SQL, new Object[] {pw});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void setPwById(Cmember cmember) {
		String SQL = "UPDATE cmember SET pw = ? WHERE id = ?";	
		try {
			jdbcTemplate.update(SQL, new Object[] {cmember.getPw(), cmember.getId()});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Cmember> getDataByPw(String pw) {
		String SQL = "SELECT * FROM cmember WHERE pw = ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = jdbcTemplate.query(SQL, new Object[] {pw}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			
		}
		return memberList;
	}

}
