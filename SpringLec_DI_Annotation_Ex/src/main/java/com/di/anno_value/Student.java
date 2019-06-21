package com.di.anno_value;



import org.springframework.beans.factory.annotation.Value;

public class Student {
	  	@Value("John")
	   private String name;
	  	@Value("11")
	  	private Integer age;
	   
	   public void setAge(Integer age) {
	      this.age = age;
	   }
	   public Integer getAge() {
	      return age;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }
}