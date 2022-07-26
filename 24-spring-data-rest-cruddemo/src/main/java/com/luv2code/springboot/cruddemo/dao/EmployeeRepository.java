package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path="members")//address path
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//that's it no need to implement crud seperately

}
