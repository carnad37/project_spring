package com.test.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.dao.PostDAO;
import com.test.dto.PostData;
//import com.test.service.Service;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:server-connect.xml");
//		Service onjService = (Service)context.getBean("service");
		PostDAO dao = (PostDAO)context.getBean("postDAO");
		
//		onjService.query_qfl_getByPostNum(200060);
		printAllList(dao.getByPostNum(200060));
		printAllMap(dao.getByPostNum_QFL(200060));

		printPostANDHouseNumList(dao.getByStreetName("길"));
		printPostANDHouseNumMap(dao.getByStreetName_QFL("길"));
		
		printPostNumList(dao.getByHouseNum(307, 793));
		printPostNumMap(dao.getByHouseNum_QFL(307, 793));
	}
	
	public static void printAllList(List<PostData> postList) {
		for (PostData postData : postList) {
			System.out.println("postNum : " + postData.getPostNum());
			System.out.println("Do : " + postData.getDO());
			System.out.println("Si : " + postData.getSI());
			System.out.println("StreetName : " + postData.getStreetName());
			System.out.println("houseNum : " + postData.getHouseNum());
			System.out.println("");
		}
	}
	
	public static void printPostANDHouseNumList(List<PostData> postList) {
		for (PostData postData : postList) {
			System.out.println("postNum : " + postData.getPostNum());
			System.out.println("houseNum : " + postData.getHouseNum());
			System.out.println("");
		}
	}
	
	public static void printAllMap(List<Map<String, Object>> postMapList) {
		for (Map<String, Object> postMap : postMapList) {
			Set<Map.Entry<String, Object>> entryPostMap = postMap.entrySet();
			for (Map.Entry<String, Object> entryData : entryPostMap) {
				System.out.println(entryData.getKey() + " : " + entryData.getValue());
			}
			System.out.println("");
		}
	}

	public static void printPostANDHouseNumMap(List<Map<String, Object>> postMapList) {
		for (Map<String, Object> postMap : postMapList) {
			String key = "postNum";
			System.out.println(key + " : " + postMap.get(key));
			key = "houseNum";
			System.out.println(key + " : " + postMap.get(key));
			System.out.println("");
		}
	}
	
	public static void printPostNumList(List<PostData> postList) {
		for (PostData postData : postList) {
			System.out.println("postNum : " + postData.getPostNum());
		}
	}
	
	public static void printPostNumMap(List<Map<String, Object>> postMapList) {
		for (Map<String, Object> postMap : postMapList) {
			System.out.println("postNum : " + postMap.get("postNum"));
		}
	}
}
