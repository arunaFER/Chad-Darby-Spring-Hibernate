package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		// Array of random fortunes
		String fortunes[] = {"Fortune 1", "Fortune 2", "Fortune 3"};
		
		// Create Random generator
		Random rand = new Random();
		
		//Pick random index
		int randIndex = rand.nextInt(fortunes.length);
		return fortunes[randIndex];
	}

}
