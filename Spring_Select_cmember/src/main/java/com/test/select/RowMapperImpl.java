package com.test.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Cmember> {

	@Override
	public Cmember mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("id");
		String pw = rs.getString("pw");
		String name = rs.getString("name");
		int cNum = rs.getInt("cNum");
		return new Cmember(id, pw, name, cNum);
	}
	
	
	
}
