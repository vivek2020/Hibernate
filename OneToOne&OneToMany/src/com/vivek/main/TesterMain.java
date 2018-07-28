package com.vivek.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.vivek.entity.Course;
import com.vivek.entity.Instructor;
import com.vivek.entity.InstructorDetail;
import com.vivek.entity.Review;
import com.vivek.entity.Student;

public class TesterMain {

	public static void main(String[] args) {
	 
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
	    SessionFactory sessionfactory=configuration.buildSessionFactory();
	    
	    //Creating new Session 
		Session session=sessionfactory.openSession();
		Transaction tc=session.beginTransaction();
	
		
		// Creating Instructor and InstructorDetail and Course
		InstructorDetail instructorDetail1=new InstructorDetail();
		instructorDetail1.setHobbies("Coding");
		instructorDetail1.setYoutubeChannel("CodersHub");
		      
		Instructor instructor1=new Instructor();
		instructor1.setFirstName("John");
		instructor1.setLastName("Hopkins");
		instructor1.setAddress("UK");
		instructor1.setInstructorDetail(instructorDetail1);
		
		Course course1=new Course();
		course1.setCourseName("Java");
		course1.setInstructor(instructor1);
		
		Course course2=new Course();
		course2.setCourseName("Machine Learning");
		course2.setInstructor(instructor1);
		
		Review review1=new Review();
		review1.setComment("Course was Great");
		
		Review review2=new Review();
		review2.setComment("Course was worth it");

		Review review3=new Review();
		review3.setComment("Overall Course was Good");
		
		Review review4=new Review();
		review4.setComment("Course was more of basic level");
		
		List<Review> reviewsOfCourse1=new ArrayList<Review>();
		reviewsOfCourse1.add(review1);
		reviewsOfCourse1.add(review2);
		
		List<Review> reviewsOfCourse2=new ArrayList<Review>();
		reviewsOfCourse2.add(review3);
		reviewsOfCourse2.add(review4);
		
		course1.setReview(reviewsOfCourse1);
		course2.setReview(reviewsOfCourse2);
		
		
		Set<Course> coursesOfInstructor1=new HashSet<Course>();
		coursesOfInstructor1.add(course1);
		coursesOfInstructor1.add(course2);
		
		instructor1.setCourses(coursesOfInstructor1);
		
		Student student1=new Student();
		student1.setName("Ferry");
		student1.setEmail("Ferry@gmail.com");
		
		Student student2=new Student();
		student2.setName("Mbappe");
		student2.setEmail("Mbappe@gmail.com");
		
		Student student3=new Student();
		student3.setName("Venice");
		student3.setEmail("Venice@gmail.com");
		
		
		course1.addStudents(student1);
		course1.addStudents(student2);
		
		
		course2.addStudents(student1);
		course2.addStudents(student2);
        course2.addStudents(student3);
        	
		
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		
		session.persist(course1);
		session.persist(course2);
        
		tc.commit();
		session.close();
		 
		//Getting the courses and its Students
		
		session=sessionfactory.openSession();
		tc=session.beginTransaction();
		
		//Course course=(Course)session.load(Course.class,course2.getId());
		Student student=(Student)session.load(Student.class,student3.getId());
	
		
		
		
	//	session.delete(course);

       //Instructor instructor=(Instructor)session.load(Instructor.class,instructor1.getId());
//	   System.out.println("DEtails of Courses of student of ID "+student.getId());
//	   System.out.println(student.getCourses());
//	   List<Student> students=course.getStudents();
//	   Iterator <Student>itr=students.iterator();
//	   while(itr.hasNext())
//	   System.out.println(itr.next());
	    
	 //  Course course=(Course)session.load(Course.class, +course1.getId());
     //   System.out.println(course.getReview());


		 tc.commit();
	    session.close();
	     
	    // session=sessionfactory.openSession();
		//	tc=session.beginTransaction();
			
			//  course=(Course)session.load(Course.class, course1.getId());
			//  System.out.println("Deleting course");
            //   session.delete(course);
			
			// tc.commit();
		  //   session.close();
	    // System.out.println(instructor.getFirstName());
/*
	      session=sessionfactory.openSession();
			tc=session.beginTransaction();
			instructor=(Instructor)session.load(Instructor.class,instructor1.getId());
	         System.out.println(instructor.getLastName());
             tc.commit();
		     session.close();*/
	      //  System.out.println(course.getInstructor().getFirstName());

	     
	     //Deleting the courses/instructor/instructorDetail
	     //session=sessionfactory.openSession();
		 //tc=session.beginTransaction();
		// session.delete(course);
	    //session.delete(instructor);
	    //session.delete(instructorDetail);
	
	
        //  tc.commit();	
        //  session.close();
	

	}

}
