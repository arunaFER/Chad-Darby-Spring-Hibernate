package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;

	//constructor injection
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	//get employee list
	@Override
	public List<Employee> findAll() {

		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//exec query get resultlist
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	//get employee
	@Override
	public Employee findById(int theId) {
		
		//get employee
		Employee theEmployee =
				entityManager.find(Employee.class, theId);
		
		//return employee		
		return theEmployee;
	}

	//save or update employee
	@Override
	public void save(Employee theEmployee) {
		
		//save or update employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update new id from db to return back newly saved employee details
		theEmployee.setId(dbEmployee.getId());

	}
	
	//delete by id
	@Override
	public void deleteById(int theId) {

		//delete object
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
