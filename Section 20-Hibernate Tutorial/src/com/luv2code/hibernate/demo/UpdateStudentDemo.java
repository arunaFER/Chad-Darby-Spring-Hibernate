package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int studentId = 1;
			
			//get a new session & transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student
			System.out.println("\n\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//New code for bulk update
				
			// get new session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Updating student emails bulk");
			
			session.createQuery("update Student s set s.email='foo@gmail.com'")
								.executeUpdate();

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}