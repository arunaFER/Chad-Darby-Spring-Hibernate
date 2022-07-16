package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//add all related advices for logging
	
	//let's start with @Before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//advice 1
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n===>> Executing @Before advice on addAccount()");
	}
	
	
	//advice 2
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n===>> performing api advice");
	}
	

}
