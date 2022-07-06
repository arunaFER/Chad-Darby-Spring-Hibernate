package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from spring container
		Coach theFootballCoach = context.getBean("footballCoach", Coach.class);
		
		
		//call methods on bean
		System.out.println(theFootballCoach.getDailyWorkout());
			
		//get daily fortune
		System.out.println(theFootballCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
