package com.di.anno_value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annoValue.xml"); // Container 생성

	      Student student = (Student) context.getBean("student");

	      System.out.println("Name : " + student.getName() );
	      System.out.println("age : " + student.getAge() );

	}

}
