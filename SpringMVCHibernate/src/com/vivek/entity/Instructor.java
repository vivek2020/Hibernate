package com.vivek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {

	@Id
	@Column(name="Instructor_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Instructor_Name")
	private String name;
	@Column(name="Instructor_Address")
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructorDetailId")
	private  InstructorDetail instructordetail;
	
	public Instructor(String name,String city,InstructorDetail instructordetail)
	{
		this.name=name;
		this.city=city;
		this.instructordetail=instructordetail;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public InstructorDetail getInstructordetail() {
		return instructordetail;
	}
	
	
	
	
}
