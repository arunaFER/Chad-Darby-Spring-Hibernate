package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	//setting foreign key relation to a instructorDetail object
	//also adds cascade
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	//mapping to instructor field in course class
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="instructor",
			   cascade={CascadeType.PERSIST, CascadeType.MERGE,
					    CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	
	//Constructors
	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

	//toString
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
	//add convenience method for bi directional relationship
	
	public void add(Course tempCourse) {
		
		//if null create new arraylist
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		//add courses to course list
		courses.add(tempCourse);
		
		//for each course add this instructor to their instructor field
		//we are setting up the bidirectional relationship
		tempCourse.setInstructor(this);
	}

}
