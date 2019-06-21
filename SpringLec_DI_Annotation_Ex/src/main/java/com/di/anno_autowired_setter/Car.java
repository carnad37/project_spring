package com.di.anno_autowired_setter;

import org.springframework.beans.factory.annotation.Autowired;


public class Car {
	
	Tire tire;

	public Tire getTire() {
	    return tire;
	}
	@Autowired
	public void setTire(Tire tire) {
	    this.tire = tire;
	}

	public String getTireBrand() {
		return "장착된 타이어: " + tire.getBrand();
	}		
}
