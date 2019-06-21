package com.tj.di_ex;

public class Coffee {

	private Americano americano;
	
	public void setAmericano(Americano americano) {
		this.americano = americano;
	}
	public void coffeeType() {
		System.out.println(americano.getName());
	}

}
