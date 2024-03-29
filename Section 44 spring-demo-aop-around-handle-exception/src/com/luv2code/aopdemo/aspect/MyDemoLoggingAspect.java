package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint)  throws Throwable{
		
		//print method we are advising
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------> Executing @Around on method: " + method);
		
		//get start timestamp
		long begin = System.currentTimeMillis();
		
		//execute method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//computate duration and print it
		long duration = end - begin;
		myLogger.info("\n----> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
		
	}
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out method signature
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------> Executing @After (finally) on method: " + method);	
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountsAdvice(
				JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out method signature
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------> Executing @AfterThrowing on method: " + method);
		
		//log exception
		myLogger.info("The exception is: " + theExc);
		
	}
	
	
	
	//advice for @AfterReturning on findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
		
		
		//print out the method advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------> Executing after returning on method: " + method);
		
		//print out method call results
		myLogger.info("\n-------> Result is: " + result);
		
		
		
		//post process data ... let's modify it :-)
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		//print out method call results
		myLogger.info("\n-------> Result is: " + result);

		
	}
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop through the accounts
		//turn names to uppercase
		//update name on account
		
		for(Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
		
		
	}
	


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n===>> Executing @Before advice on addAccount()");
		
		
		//display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);//will call toString for the method
		
		
		
		//display method arguments
			//get args
			Object[] args = theJoinPoint.getArgs();
		
			
			//loop through and printthe srgs
			for(Object tempArg: args) {
				myLogger.info(tempArg.toString());
				
				if (tempArg instanceof Account) {
					//downcast and print Account specific stuff
					Account theAccount = (Account) tempArg;
							
					myLogger.info("account name: " + theAccount.getName());
					myLogger.info("account level: " + theAccount.getLevel());
				}
			}
		
	}
	

}
