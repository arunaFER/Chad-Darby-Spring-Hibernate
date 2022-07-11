package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {
			//use the session object to save Java object
			
				// create a student object
				System.out.println("Creating new student object....");
				Student tempStudent = new Student("Daffy", "Duck", "john@luv2code.com");
	
				// start a transaction
				session.beginTransaction();
	
				// save the student object
				System.out.println("Saving student object");
				System.out.println(tempStudent);
				session.save(tempStudent);
	
				// commit transaction
				session.getTransaction().commit();
	
				System.out.println("Saved student generated ID: " + tempStudent.getId());
			
			//retrieve Daffy duck
				
				//start new session 
				session = factory.getCurrentSession();
				
				//start transaction
				session.beginTransaction();
				
				//retrieve student by id(pk)
				System.out.println("\n Getting student with id: " + tempStudent.getId());
				
				//get the student and save in Student object
				Student myStudent = session.get(Student.class, tempStudent.getId());
				
				System.out.println("Dump student to console: " + myStudent);
				
				//commit transaction
				session.getTransaction().commit();			
			
			System.out.println("Done!");			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
