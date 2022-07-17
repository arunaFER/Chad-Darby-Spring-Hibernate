package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay sleep 5s
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expect heavy traffic this morning";
	}

	
	public String getFortune(boolean tripWire) {


		if (tripWire) {
			throw new RuntimeException("Major accident! Highway closed!");
		}
		
		return getFortune();
	}

}
