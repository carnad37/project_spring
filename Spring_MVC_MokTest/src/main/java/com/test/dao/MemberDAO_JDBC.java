package com.test.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.dto.Member;

public class MemberDAO_JDBC implements MemberDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MemberDAO_JDBC(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Member selectById(String id) {
		List<Member> members = jdbcTemplate.query("select * from MEMBER where ID = ?",
				new Object[] {id}, new BeanPropertyRowMapper<Member>(Member.class));
		return members.isEmpty() ? null : members.get(0);
	}

	@Override
	public void insert(Member member) {
		jdbcTemplate.batchUpdate("INSERT into Member(id, password, name) values(?, ?, ?)");
		
	}

}
