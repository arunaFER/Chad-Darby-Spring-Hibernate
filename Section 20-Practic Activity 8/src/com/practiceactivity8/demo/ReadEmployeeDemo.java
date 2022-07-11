package com.practiceactivity8.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadEmployeeDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										 .configure("hibernate.cfg.xml")
										 .addAnnotatedClass(Employee.class)
										 .buildSessionFactory();
				
				
				try {
					int employeeId = 2;
					
					//create session 
					Session session = factory.getCurrentSession();
					
					//begin transaction					
					session.beginTransaction();
					
					//retrieve employee
					Employee employee = session.get(Employee.class, employeeId);
					
					//output employee
					System.out.println("Retrieved employee: " + employee);
				
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}

}
