package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDempApp {

	public static void main(String[] args) {
		
		//load the Spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		//instance one
		Coach theCoach = context.getBean("myCoach", Coach.class);
		//instance two
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		
		//Process switch scope between prototype and singleton and check output
		
		//check if two objects refer to same singleton instance
		boolean result = (theCoach == alphaCoach);
		
		//print out result
		System.out.println("Ponting to same result?: " + result);
		
		//print out memory locations of the two objects
		System.out.println("Memory location of theCoach: "+theCoach);
		System.out.println("Memory location of alphaCoach: "+alphaCoach);
		
		//close context
		context.close();
		
	}
	
}