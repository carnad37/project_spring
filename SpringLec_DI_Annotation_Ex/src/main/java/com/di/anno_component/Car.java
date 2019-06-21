package com.di.anno_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	@Autowired
	@Qualifier("aTire")
	Tire tire;

	public Tire getTire() {
	    return tire;
	}
	public void setTire(Tire tire) {
	    this.tire = tire;
	}
	public String getTireBrand() {
		return "장착된 타이어: " + tire.getBrand();
	}	
}
