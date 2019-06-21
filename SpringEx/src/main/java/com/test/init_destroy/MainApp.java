package com.test.init_destroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		String conf = "initdestroy_bean.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(conf);
		
		context.refresh();
		
		Student student = context.getBean("student", Student.class);
		System.out.println(student.getName());
		System.out.println(student.getAge());
		
		context.close();
	}
}
