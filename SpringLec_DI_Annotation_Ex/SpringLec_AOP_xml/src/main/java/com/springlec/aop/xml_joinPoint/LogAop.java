package com.springlec.aop.xml_joinPoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}
		
	}
	
	public void beforeAdvice(JoinPoint joinPoint) {		
		System.out.println("beforeAdvice()");
		System.out.println("toString()"+joinPoint.toString());
		System.out.println("getTarget()"+joinPoint.getTarget());
		System.out.println("getSignature()"+joinPoint.getSignature());
		/*
		Object[] args = joinPoint.getArgs();
		for(Object tmp:args)
		{ 
			if(tmp  instanceof String)
			{
				String str = (String) tmp;
				System.out.println("getArgs() : "+str); 
			}
		}
		*/
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("afterReturningAdvice()");
	}
	
	public void afterThrowingAdvice(JoinPoint joinPoint) {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("afterAdvice()");
	}
	
}
