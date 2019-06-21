package com.test.init_destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void destroy() throws Exception {
		System.out.println("destroy()");

	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}	
}
