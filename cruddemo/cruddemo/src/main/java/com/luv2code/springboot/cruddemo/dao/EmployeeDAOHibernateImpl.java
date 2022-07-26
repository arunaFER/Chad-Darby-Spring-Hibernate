package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//firld for entity manager
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	//get employee list
	@Override
	public List<Employee> findAll() {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//(Using hibernate API)
		//create a query
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
		
		//exec query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return results		
		return employees;
	}

	//get employee
	@Override
	public Employee findById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	//save or update employee
	//if id=0 then save, else if id!=0 the update!!
	@Override
	public void save(Employee theEmployee) {
		
		//get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	//delete employee
	@Override
	public void deleteById(int theId) {

		//get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete the object with primary key
		Query theQuery =
				currentSession.createQuery("delete from Employee where id=:empId");
		theQuery.setParameter("empId", theId);
		
		theQuery.executeUpdate();
		
	}

}
