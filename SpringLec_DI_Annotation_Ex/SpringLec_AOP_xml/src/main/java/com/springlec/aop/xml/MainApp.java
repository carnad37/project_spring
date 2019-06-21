package com.springlec.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop_xml.xml");
		IPerson romeo = (IPerson)context.getBean("boy");			  
		romeo.job();
		
		
		
	}

}
