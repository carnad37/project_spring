package com.springlec.aop.xml_pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("pointcut_xml.xml");
		IPerson owner = (IPerson)context.getBean("owner");			  
		IPerson maid = (IPerson)context.getBean("maid");
		owner.job();
		owner.callToOffice();
		
		maid.job();

		
		
	}

}
