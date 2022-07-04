package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Email Address: " + theCoach.getEmailAddress());
		System.out.println("Team name: " + theCoach.getTeam());
		System.out.println("Owner Email Address: " + theCoach.getOwnerEmail());
		System.out.println("Team Owner name: " + theCoach.getTeamOwner());
		
		
		//close context
		context.close();

	}

}
