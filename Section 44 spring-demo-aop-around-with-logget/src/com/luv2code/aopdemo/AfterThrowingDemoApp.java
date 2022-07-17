package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			//add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}
		

		// display the accounts
		System.out.println("\n\nMain Prigram: AfterThrowing Demo\n");

		System.out.println(theAccounts);
		
		
		//close context
		context.close();
	}

}
