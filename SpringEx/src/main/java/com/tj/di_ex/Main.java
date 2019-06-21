package com.tj.di_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Coffee coff = (Coffee)context.getBean("coffee");
		coff.coffeeType();
	}
	
}
