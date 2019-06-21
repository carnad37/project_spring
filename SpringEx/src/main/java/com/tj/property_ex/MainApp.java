package com.tj.property_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bmi_bean.xml");
		MyInfo myInfo = (MyInfo)context.getBean("myInfo");
		myInfo.getInfo();		
	}
}
