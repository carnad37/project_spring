package com.di.anno_autowired_qualified;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
	
	@Autowired
	@Qualifier("aTire")
	Tire tire;

	@Autowired	
	public Car(@Qualifier("kTire")Tire tire) {
	    this.tire = tire;
	}
	public Tire getTire() {
	    return tire;
	}
	@Autowired
	@Qualifier("aTire")
	public void setTire(Tire tire) {
	    this.tire = tire;
	}
	public String getTireBrand() {
		return "장착된 타이어: " + tire.getBrand();
	}
	
}
