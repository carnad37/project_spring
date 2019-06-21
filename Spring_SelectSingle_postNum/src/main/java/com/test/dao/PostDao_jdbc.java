package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.dto.PostData;

public class PostDao_jdbc {

	private JdbcTemplate jdbcTemplate;

	public PostDao_jdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	/*
	 	1.postNum이 가장 큰수를 출력하세요 
		2.streetName 이 춘천로223번길인 레코드의 houseNum을 출력하세요 
		3.streetName 이 삼포길, houseNum이 307인 레코드의 postNum을 출력하세요 
		4.postNum이 200060 인 레코드 모든 정보를 출력하세요 
	*/
	public int getMaxPostNum() {
		int maxPostNum = 0;
		String SQL = "SELECT MAX(postNum) AS max_postNum FROM postNum";
		try {
			maxPostNum = jdbcTemplate.queryForObject(SQL, Integer.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return maxPostNum;
	}
	
	public int getHouseNumByStreetName(String streetName) {
		int houseNum = 0;
		String SQL = "SELECT houseNum FROM postNum WHERE streetName = ?";
		try {
			houseNum = jdbcTemplate.queryForObject(SQL, new Object[] {streetName}, Integer.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return houseNum;
	}
	
	public int getPostNumByStreetNameANDHouseNum(String streetName, int houseNum) {
		int postNum = 0;
		String SQL = "SELECT postNum FROM postNum WHERE streetName = ? AND houseNum = ?";
		try {
			postNum = jdbcTemplate.queryForObject(SQL, new Object[] {streetName, houseNum}, Integer.class);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return postNum;
	}
	
	public List<PostData> getPostDataByPostNum(int postNum) {
		List<PostData> dataList = new LinkedList<PostData>();
//		PostData postData = null;
		String SQL = "SELECT * FROM postNum WHERE postNum = ?";
		try {
			dataList = jdbcTemplate.query(SQL, new Object[] {postNum}, 
					new RowMapper<PostData>() {
						public PostData mapRow(ResultSet rs, int index) throws SQLException {
							int postNum = rs.getInt("postNum");
							String cityDo = rs.getString("Do");
							String citySi = rs.getString("Si");
							String streetName = rs.getString("streetName");
							int houseNum = rs.getInt("houseNum");
							return new PostData(postNum, cityDo, citySi, streetName, houseNum);						
						} 
					});
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		System.out.println(dataList.get(0).getPostNum());
		return dataList;
	}

}