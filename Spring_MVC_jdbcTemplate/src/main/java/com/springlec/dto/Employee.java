package com.springlec.dto;

public class Employee {
	
	private String name;
	private String dept;
	private int id;
	private int age;
	
	public Employee() {

	}
	
	public Employee(String name, String dept, int id, int age) {
		this.name = name;
		this.dept = dept;
		this.id = id;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
