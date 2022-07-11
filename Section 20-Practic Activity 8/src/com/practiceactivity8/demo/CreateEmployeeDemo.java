package com.practiceactivity8.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployeeDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										 .configure("hibernate.cfg.xml")
										 .addAnnotatedClass(Employee.class)
										 .buildSessionFactory();
				
				
				try {
					//create session 
					Session session = factory.getCurrentSession();
					
					//create employee objects
					Employee emp1 = new Employee("Ann", "Harr", "BMW");
					Employee emp2 = new Employee("Tom", "Hardy", "Audi");
					Employee emp3 = new Employee("Chris", "Cammisa", "Audi");
					
					//begin transaction					
					session.beginTransaction();
					
					//save employee objects
					System.out.println("Saving employees...");
					session.save(emp1);
					session.save(emp2);
					session.save(emp3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}

}
