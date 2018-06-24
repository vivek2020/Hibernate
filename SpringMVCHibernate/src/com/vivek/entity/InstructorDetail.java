package com.vivek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="InstructorDetail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorDetailId;
	private String qualification;
	private String subject;
	@OneToOne(mappedBy="instructordetail")
	private Instructor instructor;
	public InstructorDetail() {}
	
	
	public InstructorDetail(String qualification,String subject)
	{
		this.qualification=qualification;
		this.subject=subject;
	}

	public int getInstructorDetailId() {
		return instructorDetailId;
	}

	public String getQualification() {
		return qualification;
	}

	public String getSubject() {
		return subject;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	

}
