package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dto.PostData;
import com.test.service.PostService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("server-side.xml");
		PostService onjService = (PostService)context.getBean("postService");
		
		int maxPostNum = onjService.query_getMaxPostNum();
		System.out.println("maxPostNum : " + maxPostNum + "\n");
		
		int houseNum = onjService.query_getHouseNumByStreetName("춘천로223번길");
		System.out.println("춘천로 223번길의 houseNum : " + 	houseNum + "\n");
		
		PostData parameter = new PostData();
		parameter.setStreetName("삼포길");
		parameter.setHouseNum(307);
		int postNum = onjService.query_getPostNumByStreetNameANDHouseNum(parameter);
		System.out.println("도로명이 삼포길이고, 건물번호가 307인 우편번호 : " + postNum + "\n");
		
//		PostData postData = onjService.query_getPostDataByPostNum(200060);
		List<PostData> postList = onjService.query_getPostDataByPostNum(200060);
		
		for (PostData postData : postList) {
			System.out.println("postNum : " + postData.getPostNum());
			System.out.println("cityDo : " + postData.getCityDo());
			System.out.println("citySi : " + postData.getCitySi());
			System.out.println("houseNum : " + postData.getHouseNum());
			System.out.println("");
		}

	}
	
}
