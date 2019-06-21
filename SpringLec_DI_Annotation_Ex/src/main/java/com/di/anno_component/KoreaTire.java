package com.di.anno_component;

import org.springframework.stereotype.Component;

@Component("kTire")
public class KoreaTire implements Tire {

	@Override
	public String getBrand() {
		return "코리아 타이어";
	}

}
