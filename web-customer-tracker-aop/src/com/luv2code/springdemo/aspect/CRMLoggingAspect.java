package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger =
			Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	
		//for controller	
		@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
		private void forControllerPackage() {}
		
		//for service
		@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
		private void forSevicePackage() {}
		
		//for DAO
		@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
		private void forDaoPackage() {}
		
		//combine pointcut declarations
		@Pointcut("forControllerPackage() || forSevicePackage() || forDaoPackage()")
		private void forAppFlow() {}
		
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//Display method to be called
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("---> @Before: calling method: " + theMethod);
		
		//display method argumemts
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("---> arguments: " + tempArg);
		}
	}
		
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//Display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("---> @AfterReturning: from method: " + theMethod);
		
		//display data returned
		myLogger.info("---> result: " + theResult);
		
	}

}
