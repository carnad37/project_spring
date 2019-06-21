package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.service.Service;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:server-connect.xml");
		Service onjService = (Service)context.getBean("cMemberService");
		
		System.out.println("id가 a로 시작하는 Recored 전체 출력:");
		onjService.query_getByIdStartWord("a");
		
		int val2 = 8500; 
		System.out.println("cNum이 " + val2 + "이상인 Recored의 id와 이름 출력: ");
		onjService.query_getByOvercNum(8500);
		
		System.out.println("name이 k로 끝나는 Recored의 cNum출력: ");
		onjService.query_getByNameLast("k");

		System.out.println("pw가 b로 시작하는 Record의 name과 cNum 출력: ");
		onjService.query_getByPWStartWord("b");
	}
	
}
