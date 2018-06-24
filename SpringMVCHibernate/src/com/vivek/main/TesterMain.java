package com.vivek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vivek.entity.Instructor;
import com.vivek.entity.InstructorDetail;

public class TesterMain {

	public static void main(String[] args) {
	
	//	InstructorDetail instructordetail=new InstructorDetail("MS","Data Science");
	//	Instructor instructor=new Instructor("John","Indiana",instructordetail);
		
       AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
		SessionFactory sessionfactory=configuration.buildSessionFactory();
		Session session=sessionfactory.openSession();
		 Transaction tc=session.beginTransaction();
	//	 session.persist(instructor);
		 
		 Instructor instructor= (Instructor)session.load(Instructor.class,1);
		 System.out.println(instructor.getInstructordetail().getQualification());
		 
		 InstructorDetail instructordetail=(InstructorDetail)session.load(InstructorDetail.class,1);
		 System.out.println(instructordetail.getInstructor().getName());
		 
		 tc.commit();
		 session.close();


	}

}
