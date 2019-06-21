package com.springlec.aop.xml_pointcut;


import org.aspectj.lang.JoinPoint;

public class MyAspect {
 
 public void ownerBefore(JoinPoint joinPoint){
  System.out.println("owner before()");
 }

 public void maidBefore(JoinPoint joinPoint){
	  System.out.println("maid before()");
	 }

}

