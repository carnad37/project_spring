package com.di.anno_autowired_properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarModel {
	public static void main(String[] args) {
		  ApplicationContext context = new ClassPathXmlApplicationContext("autowiredProperties.xml");
		  Car car = (Car)context.getBean("car");

		  System.out.println(car.getTireBrand());
	 }

		
}
