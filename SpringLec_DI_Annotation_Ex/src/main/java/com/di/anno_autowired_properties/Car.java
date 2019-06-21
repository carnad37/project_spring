package com.di.anno_autowired_properties;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	@Autowired
	Tire tire;

	public Tire getTire() {
	    return tire;
	}
	
	public String getTireBrand() {
		return "장착된 타이어: " + tire.getBrand();
	}
	
}
