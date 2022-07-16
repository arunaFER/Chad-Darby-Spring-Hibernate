package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	//pointcut declarations
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		//pointcuts for getters
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		//pointcuts for setters
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		public void setter() {}	
		
		//create pointcut:include package and exclude getters/setters
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
		

}
