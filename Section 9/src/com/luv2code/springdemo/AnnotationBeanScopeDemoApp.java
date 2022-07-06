package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//Load config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean
		Coach coach1 = context.getBean("footballCoach", Coach.class);
		Coach coach2 = context.getBean("footballCoach", Coach.class);
		
		//actions
		boolean result = (coach1 == coach2);
		System.out.println("Pointing to same object? " + result);
		System.out.println("Memory location for coach1: " + coach1);
		System.out.println("Memory location for coach2: " + coach2);
		
		//close context
		context.close();
	}

}
