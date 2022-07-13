package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerrLazyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {			
			
			//start a transaction
			session.beginTransaction();
			
			//get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			
			//retrieve courses from instructor
			//lazy loading
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());			
			
					
			//commit transaction
			session.getTransaction().commit();			
			
			session.close();
			
			System.out.println("\nluv2code: Session is now closed!\n");
			
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());			
			
			
			//how to get around  lazyInitialisationException issue :-)?
			//Option 1: call getter before session is closed
		
			
			System.out.println("luv2code: Done!");			
			
		}
		finally {
			//clean up code
			session.close();
			
			factory.close();
		}
		
		
	}

}
