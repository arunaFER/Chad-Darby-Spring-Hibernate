package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define a private field for the dependency
	private  FortuneService fortuneService;
	
	public BaseballCoach() {
		
	}
	
	//define constructor for dependency
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//get a fortune
		return fortuneService.getFortune();
	}

}
