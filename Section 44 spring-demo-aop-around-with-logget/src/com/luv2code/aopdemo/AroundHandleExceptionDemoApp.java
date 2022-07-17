
package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	//give fully qualified class name to logger
	private static Logger myLogger =
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		myLogger.info("\nMain program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		
		//add tripwire to induce exception
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		
		//close context
		context.close();
	}

}
