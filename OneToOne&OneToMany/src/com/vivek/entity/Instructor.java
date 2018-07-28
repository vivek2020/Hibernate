package com.vivek.entity;

import java.util.Set;

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
@Table(name="Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="InstructorId",nullable=false)
	private int id;
	@Column(name="InstructorFirstName",nullable=false)
    private String firstName;
	@Column(name="InstructorLastName",nullable=false)
    private String lastName;
	@Column(name="InstructorAddress",nullable=false)
    private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="InstructorDetailId")
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor",cascade=CascadeType.ALL)
    private Set<Course> courses;

	public int getId() {
		return id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", instructorDetail=" + instructorDetail +  "]";
	}


	

	
	
	
    
    
}
