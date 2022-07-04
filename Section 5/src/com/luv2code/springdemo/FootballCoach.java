package com.luv2code.springdemo;

public class FootballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define constructor for dependency
	public FootballCoach(FortuneService theFortuneService) {
			fortuneService = theFortuneService;
		}

	@Override
	public String getDailyWorkout() {
		return "Rondo practice 10 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
