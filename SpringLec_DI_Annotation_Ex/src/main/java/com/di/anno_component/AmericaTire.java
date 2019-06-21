package com.di.anno_component;

import org.springframework.stereotype.Component;

@Component("aTire")
public class AmericaTire implements Tire{
	public String getBrand() {
		return "미국 타이어";
	}

}
