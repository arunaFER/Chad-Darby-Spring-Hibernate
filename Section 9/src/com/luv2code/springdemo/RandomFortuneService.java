package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	private String data[] = {
			"Beware of the wolf",
			"Diligence",
			"Journey is the reward!"
	};

	@Override
	public String getFortuneService() {
		
		// pick a random string from the array
		Random rand = new Random();
		int randIndex = rand.nextInt(data.length);
		
		return data[randIndex];
	}

}
