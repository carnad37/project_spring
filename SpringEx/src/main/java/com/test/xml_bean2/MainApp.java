package com.test.xml_bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"student_bean_1.xml","student_bean_2.xml"});
		Student student1 = context.getBean("student1", Student.class);
		printStudent(student1);

		
		StudentInfo studentInfo = context.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		printStudent(student2);
		
		if (student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = context.getBean("student3", Student.class);
		printStudent(student3);
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = context.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		context.close();
	}
	
	public static void printStudent(Student student) {
		System.out.println(student.getName());
		System.out.println(student.getHobbys());
	}
}

