package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/ convert to JAVA pojo
			//data/sample-lite.json
			
			Student theStudent = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			
			//print first and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			System.out.println("TheStudent: " + theStudent);
			
			Address theAddress = theStudent.getAddress();
			System.out.println("\nAddress: " + theAddress);
			
			//System.out.println("\nLanguages :" );
			//theStudent.printLanguages();
			
			for(String theLanguage : theStudent.getLanguages()) {
				System.out.println(theLanguage);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
