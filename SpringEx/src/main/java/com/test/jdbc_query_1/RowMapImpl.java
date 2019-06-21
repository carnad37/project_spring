package com.test.jdbc_query_1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapImpl implements RowMapper<Emp> {

	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		int empno = rs.getInt("empno");
		String ename = rs.getString("ename");
		int deptno = rs.getInt("deptno");
		
		return new Emp(empno, ename, deptno);
	}

}
