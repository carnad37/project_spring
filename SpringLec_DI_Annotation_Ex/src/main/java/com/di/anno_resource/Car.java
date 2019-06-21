package com.di.anno_resource;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

public class Car {
	
	
	@Resource (name="aTire")
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
