package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add exception to catch CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){
		
		//create error response entity
		CustomerErrorResponse error = 
				new CustomerErrorResponse(
						HttpStatus.NOT_FOUND.value(),
						e.getMessage(),
						System.currentTimeMillis());
		
		//return response object
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//add exception to find generic exceptions
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
		
		//create error response entity
		CustomerErrorResponse error = 
				new CustomerErrorResponse(
						HttpStatus.BAD_REQUEST.value(),
						e.getMessage(),
						System.currentTimeMillis());
		
		//return response object
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
