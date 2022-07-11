package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {
			//use the session object to query java objects
			
				// start a transaction
				session.beginTransaction();
				
				//query the students into a list
				List<Student> theStudents = 
						session.createQuery("from Student").getResultList();
				
				//display the students > refractor>extract method
				displayStudents(theStudents);
				
					//theStudents.forEach(System.out::println);
					
					//or
					
					/*for(Student tempStudent : theStudents) {
					System.out.println(tempStudent);
					}
					*/
					
				
				//query student with last name = Doe
				theStudents = 
					session.createQuery("from Student s where s.lastName='Doe'").getResultList();	
					
				//display the students
				System.out.println("\n\nStudents with lastName=Doe");
				displayStudents(theStudents);
				
				
				//query student with last name = Doe or first name = Daffy
				theStudents =
						session.createQuery("from Student s where"
								+ " s.lastName='Doe' or s.firstName='Daffy'").getResultList();
				
				System.out.println("\n\nStudents with lastName=Doe or firstNmame=Daffy");
				displayStudents(theStudents);
				
	
				//query student with email like %luv2code.com
				theStudents =
						session.createQuery("from Student s where"
								+ " s.email like '%luv2code.com'").getResultList();
				
				System.out.println("\n\nStudents with email like %luv2code.com");
				displayStudents(theStudents);
				
	
				// commit transaction
				session.getTransaction().commit();
	
			System.out.println("Done!");			
			
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
