package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
			//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
			
			//default bean id for footballCoach
			Coach theFootballCoach = context.getBean("footballCoach", Coach.class);
		
		
		//call methods on bean
			//System.out.println(theCoach.getDailyWorkout());
			System.out.println(theFootballCoach.getDailyWorkout());
			
			//get daily fortune
			System.out.println(theFootballCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
