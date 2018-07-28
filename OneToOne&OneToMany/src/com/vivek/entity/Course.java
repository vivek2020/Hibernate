package com.vivek.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CourseId",nullable=false)
	private int id;
	
	@Column(name="CourseName",nullable=false)
    private String courseName;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="InstructorId")
	private Instructor instructor;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CourseId")
    private List <Review> review;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	@JoinTable(name="StudentCourses",joinColumns={@JoinColumn(name="CourseId",referencedColumnName="CourseId")},
	           inverseJoinColumns={@JoinColumn(name="StudentId",referencedColumnName="StudentId")})
	private List <Student> students;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudents(Student student)
	{
		if(students==null)
		{
			students=new ArrayList<Student>();
		}
		students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName +"]";
	}

	
	
	

	
	
	
	
	
	
	
}
