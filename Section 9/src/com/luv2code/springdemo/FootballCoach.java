package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//default bean id > footballCoach

@Component
//@Scope("prototype")
public class FootballCoach implements Coach {
	
	//Field injection - no need for setter/constructor/method injection - uses Java Reflection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//default constructor
	public FootballCoach() {
		System.out.println("FootballCoach: inside default constructor");
	}
	
	
	//init method
	@PostConstruct
	public void startupStuff() {
		System.out.println("FootballCoach: inside init method");
	}
	
	//destroy method
	@PreDestroy
	public void destroyStuff() {
		System.out.println("FootballCoach: inside destory method");
	}
	
	//constructor injection
	/*@Autowired
	public FootballCoach(FortuneService theFortuneServce) {
		fortuneService = theFortuneServce;
	}
	*/
	
	//Setter injection
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("FootballCoach: inside setFortuneService");
		fortuneService = theFortuneService;
	}
	*/
	
	//Method injection
	/*@Autowired
	public void doSomeCrazyShit(FortuneService theFortuneService) {
		System.out.println("FootballCoach: inside doSomeCrazyShit");
		fortuneService = theFortuneService;
	}
	*/
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice the rondo";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

}
