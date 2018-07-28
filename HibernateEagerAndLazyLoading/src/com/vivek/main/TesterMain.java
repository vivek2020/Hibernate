package com.vivek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vivek.entity.Employee;

public class TesterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
	    SessionFactory sessionfactory=configuration.buildSessionFactory();
	    
	    //Creating new Session 
		Session session=sessionfactory.openSession();
		Transaction tc=session.beginTransaction();
		
		Employee e=new Employee();
		e.setName("Johnny");
		e.setQualification("BA");
		
		int id=(Integer)session.save(e);
		
        System.out.println("Employee Saved of id "+id);
		
    	tc.commit();
	    session.close();
	    
	    //Creating new Session 
	     session=sessionfactory.openSession();
	  	 tc=session.beginTransaction();
	  		
		Employee e1=(Employee)session.load(Employee.class, 1);
		System.out.println("Retreived Employee using  Load method");
		
		System.out.println("Employee Name "+e1.getName());
		
		tc.commit();
	    session.close();
	    
		  session=sessionfactory.openSession();
		  tc=session.beginTransaction();
		Employee e2=(Employee)session.get(Employee.class, 1);
		
        System.out.println("Retreived Employee using  Get method");
		
		System.out.println("Employee Name "+e2.getName());
		tc.commit();
	    session.close();
		
		
		
	}

}
