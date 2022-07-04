package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define constructor for dependency
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
