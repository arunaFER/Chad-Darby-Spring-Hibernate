package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		
		System.out.println(getClass() + 
				": DOING MY DB WORK: ADDING AN ACCOUNT");
		
		return true;
		
	}
	
	
	public void goToSleep() {

		System.out.println(getClass() + ": Go To Seelp!");

	}

}
