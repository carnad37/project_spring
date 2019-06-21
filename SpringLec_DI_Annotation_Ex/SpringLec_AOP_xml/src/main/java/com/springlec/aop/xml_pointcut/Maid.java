package com.springlec.aop.xml_pointcut;

public class Maid implements IPerson {
	static final int WORKING_HOUR = 9;
	 public void job() {
		  System.out.println("청소한다.");
	 }
	public int callToOffice()
	{
		int ret=0;
		System.out.println("maid 사무실에 전화한다.");
		return ret;
	}

}
