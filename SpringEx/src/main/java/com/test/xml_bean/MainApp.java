package com.test.xml_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test_xml_bean.xml");
		RemoteControl rc = (RemoteControl)context.getBean("remote_control");
		String movieName = rc.getVp().getMovieName();
		System.out.println("getMovieName() : " + movieName);
		System.out.println("getPrice() : " + rc.getVp().getPrice(movieName));
		
	}
}
