package com.test.jdbc;

import java.util.List;
import java.util.Map;

public interface JdbcDao {
	public List getName();
	public List<Map<String, Object>> getDataListSearchById(String id);
}
