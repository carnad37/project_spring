package com.springlec.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;

public class MyAspect {
 
 public void beforeJob(JoinPoint joinPoint){
  System.out.println("문을 열고 들어간다.");
 }

}

