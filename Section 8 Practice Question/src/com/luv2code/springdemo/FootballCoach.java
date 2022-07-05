package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	
	FortuneService fortuneService;
	
	//Constructor injection
	@Autowired
	public FootballCoach(@Qualifier("trueFileFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice the rondo";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

}
