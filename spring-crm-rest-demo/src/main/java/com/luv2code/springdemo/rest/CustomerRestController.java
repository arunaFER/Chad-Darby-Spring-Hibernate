package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//autowire the CustomerService
	/*@Autowired
	private CustomerService customerService;*/
	
	
	private CustomerService customerService;
	
	//constructor injection
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		
		this.customerService = theCustomerService;
	}
	
	
	//endpoint for GET /customers
	@GetMapping("/customers")
	private List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	
	//endpoint for GET /customer
	@GetMapping("/customers/{customerId}")
	private Customer getCustomer(@PathVariable int customerId){
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}
		
		return theCustomer;
	}
	
	
	//endpoint for POST  (add) customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//to save a customer
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	
	
	//endpoint for PUT (update) customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	
	
	//endpoint for DELETE customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		//to check for customer before dleteing
			Customer tempCustomer = customerService.getCustomer(customerId);
			
			if(tempCustomer == null) {
				throw new CustomerNotFoundException("Customer id not found: " + customerId);
			}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer: " + customerId;
	}
	

}
