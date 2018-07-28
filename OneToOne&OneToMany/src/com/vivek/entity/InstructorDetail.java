package com.vivek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name="InstructorDetailId",nullable=false)
	private int id;
	
	
	@Column(name="Instructor_Hobbies",nullable=false)
    private String hobbies;
	
	@Column(name="Youtube_Channel_Name",nullable=false)
	private String youtubeChannel;
	
    @OneToOne(cascade=CascadeType.ALL,mappedBy="instructorDetail")
	private Instructor instructor;

	public int getId() {
		return id;
	}


    public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobbies=" + hobbies + ", youtubeChannel=" + youtubeChannel
				+ "]";
	}


	
	

	
	
	
}
