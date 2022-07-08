package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	//new controller method to read form data
	//add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read request parameter from HTML form
		String theName = request.getParameter("stdName");
		
		//convert data to upper case
		theName = theName.toUpperCase();
		
		//create a message
		String result = "Yo! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	//new controller method to read form data using @RequestParameter
	//add data to model
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(
			@RequestParam("stdName") String theName, 
			Model model) {
		
		//convert data to upper case
		theName = theName.toUpperCase();
		
		//create a message
		String result = "Hey my friend from v3! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
