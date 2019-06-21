package com.springlec.aop.xml_joinPoint;

public class Student {

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getStudentInfo() {
		System.out.println("이름 : " + getName());
		
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
