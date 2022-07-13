package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		
		try {			
			
			//start a transaction
			session.beginTransaction();
			
			//get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print course
			System.out.println("Deleting the course.....");
			System.out.println(tempCourse);
			
			//delete the course
			//cascadeType.ALL will delete all associated reviews too
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();			
			
			System.out.println("Done!");			
			
		}
		finally {
			//clean up code
			session.close();
			
			factory.close();
		}
		
		
	}

}
