package com.test.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dto.Cmember;

public class CmemberDAO {

	private JdbcTemplate jdbcTemplate;
		
	public CmemberDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getCountRecord() {
		String SQL = "SELECT * FROM cmember";
		int count = 0;
		try {
			count = jdbcTemplate.queryForList(SQL).size();
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public List<String> getPwOfId(String id) {
		String SQL = "SELECT pw FROM cmember WHERE id = ?";
		List<String> list = new LinkedList<String>();
		try {
			list = jdbcTemplate.queryForList(SQL, new Object[] {id}, String.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<String> getIdOfcNum(int cNum) {
		String SQL = "SELECT id FROM cmember WHERE cNum = ?";
		List<String> list = new LinkedList<String>();
		try {
			list = jdbcTemplate.queryForList(SQL, new Object[] {cNum}, String.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Cmember> getRecordByNameAndCNum(String name, int cNum) {
		String SQL = "SELECT * FROM cmember WHERE name = ? AND cNum =?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = jdbcTemplate.query(SQL, new Object[] {name, cNum}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			
		}
		return memberList;
	}
	
	public List<Cmember> getRecordByPw(String pw) {
		String SQL = "SELECT * FROM cmember WHERE pw = ?";
		List<Cmember> memberList = new LinkedList<Cmember>();
		try {
			memberList = jdbcTemplate.query(SQL, new Object[] {pw}, new BeanPropertyRowMapper<Cmember>(Cmember.class));
		} catch (DataAccessException e) {
			
		}
		return memberList;
	}
	
	public void setRecord(List<Cmember> memberList) {
		String SQL = "INSERT INTO cmember(id, pw, name,cNum) VALUES";
		Object[] data = new Object[memberList.size() * 4];
		int dataIndex = 0;
		for (int i = 0; i < memberList.size(); i++) {
			if (i != 0) {
				SQL += ", (?, ?, ?, ?)";			
			} else {
				SQL += "(?, ?, ?, ?)";			
			}
			data[dataIndex++] = memberList.get(i).getId();
			data[dataIndex++] = memberList.get(i).getPw();
			data[dataIndex++] = memberList.get(i).getName();
			data[dataIndex++] = memberList.get(i).getcNum();
		}
			
		try {
			jdbcTemplate.update(SQL, data);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}	
	
	public void delRecordByName(String name) {
		String SQL = "DELETE FROM cmember WHERE name = ?";	
		try {
			jdbcTemplate.update(SQL, new Object[] {name});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}	
	
	public void updateRecordById(String id, String nPw) {
		String SQL = "UPDATE cmember SET pw = ? WHERE id = ?";	
		try {
			jdbcTemplate.update(SQL, new Object[] {nPw, id});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}	
}
