package com.practiceactivity8.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryEmployeeDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										 .configure("hibernate.cfg.xml")
										 .addAnnotatedClass(Employee.class)
										 .buildSessionFactory();
				
				
				try {
					//create session 
					Session session = factory.getCurrentSession();
					
					//begin transaction					
					session.beginTransaction();
					
					//retrieve employees by company = Audi
					List<Employee> emps = session.createQuery("from Employee e where"
															+ " e.company = 'Audi'").getResultList();
					
					//output employee
					for(Employee emp : emps) {
						System.out.println(emp);
					}
				
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}

}
