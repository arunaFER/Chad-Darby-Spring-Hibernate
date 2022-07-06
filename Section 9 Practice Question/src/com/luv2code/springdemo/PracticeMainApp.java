package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeMainApp {

	public static void main(String[] args) {
		
		//Load config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans
		Coach theCoach = context.getBean("footballCoach", Coach.class);
		
		//Do
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();
	}

}
