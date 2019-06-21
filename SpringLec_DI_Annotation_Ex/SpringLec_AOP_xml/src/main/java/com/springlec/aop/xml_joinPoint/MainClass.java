package com.springlec.aop.xml_joinPoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:joinPoint.xml");
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
			
		ctx.close();
		
	}	
}
