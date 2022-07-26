package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//add mapping for / list
		@GetMapping("/list")
		public String listEmployees(Model theModel) {
			
			//get employees from db
			List<Employee> theEmployee = employeeService.findAll();
			
			//add to spring model
			theModel.addAttribute("employees", theEmployee);
			
			return "employees/list-employees";
		}
		
	//show for to add employee
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			//model attribute to bind data
			Employee theEmployee = new Employee();
			
			theModel.addAttribute("employee", theEmployee);
			
			return "employees/employee-form";
		}
		
	//save employee
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
			
			//save employee
			employeeService.save(theEmployee);
			
			//use redirect to prevent duplicate submissions
			return "redirect:/employees/list";
		}
		
	//show form for update
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("employeeId") int theId,
										Model theModel) {
			
			//get employee from service
			Employee theEmployee = employeeService.findById(theId);
			
			//set employee as attribute to pre-populate form
			theModel.addAttribute("employee", theEmployee);
			
			return "employees/employee-form";
		}
		
	//delete employee
		@GetMapping("/delete")
		public String delete(@RequestParam("employeeId") int theId) {
			
			//delete employee
			employeeService.deleteById(theId);
			
			return "redirect:/employees/list";
		}
		

}
