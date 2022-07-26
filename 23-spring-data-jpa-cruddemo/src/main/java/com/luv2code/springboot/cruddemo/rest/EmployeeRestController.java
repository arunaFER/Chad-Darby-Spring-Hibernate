package com.luv2code.springboot.cruddemo.rest;

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

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//inject employee dao
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	//endpoint for return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	
	//endpoint for employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found: "
										+ employeeId);
		}
		
		return employee;
	}
	
	
	//endpoint for save customer
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//set id to 0 to save employee
		theEmployee.setId(0);
		
		//save employee
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	
	//endpoint to update employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		//save employee
		employeeService.save(theEmployee);
		
		return theEmployee;
	}

	
	//endpoint for delete
	@DeleteMapping("/employees/{employeeId}")
	public Employee deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
				
		//throw exception if null
		if(tempEmployee == null) {
			throw new RuntimeException("No empoyee found with ID: " + employeeId);
		}
		
		//delete employee
		employeeService.deleteById(employeeId);
		
		return tempEmployee;
	}

}
