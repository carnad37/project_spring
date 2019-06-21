package com.di.anno_list_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainApp {

	public static void main(String[] args) {
	    ApplicationContext context =
	            new ClassPathXmlApplicationContext("annoListInjection.xml");
	        SampleBean sample = context.getBean(SampleBean.class);

	        sample.showFruits();
	        sample.showPrefs();
	        sample.showTimetable();
	        sample.showFruitMap();

	}

}
