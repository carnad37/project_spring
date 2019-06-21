package com.test.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemClient {
		
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		JdbcDao dStuff = context.getBean("bmemberDao", JdbcDao.class);
		System.out.println(dStuff.getName());
		List<Map<String, Object>> dataList = dStuff.getDataListSearchById("apple");
		
		for (Map<String, Object> map : dataList) {
			printName(map);
			System.out.println("");
		}
	}
	
	public static void printFulldata(Map<String, Object> map) {
		Set<Map.Entry<String, Object>> mapData = map.entrySet();
		for (Map.Entry<String, Object> data : mapData) {
			System.out.println(data.getKey() + " : " + data.getValue());
		}
	}
	public static void printNamePw(Map<String, Object> map) {
		System.out.println("name : " + map.get("name"));
		System.out.println("pw : " + map.get("pw"));

	}
	public static void printName(Map<String, Object> map) {
		System.out.println("name : " + map.get("name"));
	}
		
}
