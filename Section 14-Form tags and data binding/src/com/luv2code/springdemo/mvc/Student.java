package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystems;
	
	private LinkedHashMap<String, String> countryOptions;
	
	//for dynamic radio button values
	private LinkedHashMap<String, String> favouriteLanguageOptions;
	
	//constructor
	public Student() {
		
		//controller will read country options from here and
		//populate the form to choose from
		//we can also read from a file, web service etc
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("SL", "Sri Lanka");
		
		//favourite language
		favouriteLanguageOptions = new LinkedHashMap<>();
		
		favouriteLanguageOptions.put("Java", "Java");
		favouriteLanguageOptions.put("Python", "Python");  
		favouriteLanguageOptions.put("C#", "C#");
		favouriteLanguageOptions.put("PHP", "PHP");
		favouriteLanguageOptions.put("Ruby", "Ruby");  
	}
	
	//Getters & Setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//Spring MVC will use this get method to populate the form with 
	//country options from linked hash map
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	
	//Spring MVC will use this get method to populate the form with 
	//favouriteLanguage from linked hash map
	public LinkedHashMap<String, String> getFavouriteLanguageOptions() {
		return favouriteLanguageOptions;
	}	
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

		
	
}
