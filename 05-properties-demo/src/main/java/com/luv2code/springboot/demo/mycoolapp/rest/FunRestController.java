package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//inject application properties
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	
	//endpoint for app properties
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		
		return "Coach :" + coachName + ", team name: " + teamName;
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World! Time on the server is: " + LocalDateTime.now();
	}
	
	
	@GetMapping("/reload")
	public String autoReload() {
		
		return "Auto reload! Time on the server is: " + LocalDateTime.now();
	}

}
