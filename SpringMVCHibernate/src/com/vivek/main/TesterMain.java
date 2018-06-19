package com.vivek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vivek.entity.Instructor;
import com.vivek.entity.InstructorDetail;

public class TesterMain {

	public static void main(String[] args) {
	
		InstructorDetail instructordetail=new InstructorDetail("MS","Data Science");
		Instructor instructor=new Instructor("John","Indiana",instructordetail);
		
       AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
		SessionFactory sessionfactory=configuration.buildSessionFactory();
		Session session=sessionfactory.openSession();
		 Transaction tc=session.beginTransaction();
		 session.persist(instructor);
		 tc.commit();
		 session.close();


	}

}
