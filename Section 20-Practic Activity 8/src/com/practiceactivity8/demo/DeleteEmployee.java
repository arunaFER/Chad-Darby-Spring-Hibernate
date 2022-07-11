package com.practiceactivity8.demo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteEmployee {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class)
					.buildSessionFactory();
				
		try {
			int empId = 1;
			
			//start session and transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve employee to be deleted
			Employee employee = session.get(Employee.class, empId);
			
			System.out.println("Employee to be deleted: " + employee);
			
			//delete employee with id = empId
			Query deleteEmpQuery =session.createQuery("delete Employee e where e.id =:e");
			deleteEmpQuery.setParameter("e", empId);
			deleteEmpQuery.executeUpdate();
			
			
			//commit session
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
