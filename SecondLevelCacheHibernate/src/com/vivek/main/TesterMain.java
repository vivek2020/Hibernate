package com.vivek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.stat.Statistics;

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
		e.setName("Fin");
		e.setQualification("BSC");
		
		int id=(Integer)session.save(e);
		
        System.out.println("Employee Saved of id "+id);
		
         tc.commit();
	    session.close();
	    
	   session=sessionfactory.openSession();
	   tc=session.beginTransaction();
	    
	   Statistics stats = sessionfactory.getStatistics();
		//System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		
		//First Time Database will be Hit
	    Employee e1=(Employee)session.load(Employee.class, 1);
	    System.out.println("Retreiving Employee using Load Method First Time from database");
	    
	    System.out.println(e1.getName());
	    System.out.println(stats.getSecondLevelCachePutCount());
	    System.out.println(stats.getSecondLevelCacheHitCount());
	    
	    //It will get from First Level Cache
	    e1=(Employee)session.load(Employee.class, 1);
	    System.out.println("Retreiving Employee using Load Method using 2nd time");
	    System.out.println(e1.getName());
	    System.out.println(stats.getSecondLevelCachePutCount());
	    System.out.println(stats.getSecondLevelCacheHitCount());
	    
	    //Removing the Object from First Level Cache
	    session.evict(e1); 
	    
	    //It will first hit First Level Cache and it will not get it.Then
	    //it will hit Second level cache and get from there
	    //Before Displaying it will store it first level cache too.
	    e1=(Employee)session.load(Employee.class, 1);
	    System.out.println(e1.getName());
	    System.out.println(stats.getSecondLevelCachePutCount());
	    System.out.println(stats.getSecondLevelCacheHitCount());

	    /*
	     e1.setName("Jacob");
	     session.saveOrUpdate(e1);
	     
	     e1=(Employee)session.load(Employee.class,1);
	     System.out.println("After Updating");
	     System.out.println(e1.getName());
	     System.out.println(stats.getSecondLevelCachePutCount());
		 System.out.println(stats.getSecondLevelCacheHitCount());  
		 */
		 tc.commit();
		 session.close();
	   
		 //Creating New Session
		 Session anotherSession=sessionfactory.openSession();
		 Transaction newTc=anotherSession.beginTransaction();
		 
		  //First Level Cache is associated with session.
		  //This will get from second level cache.
		  e1=(Employee) anotherSession.load(Employee.class,1);
		  System.out.println("New Session and Transaction");
		  System.out.println(e1.getName());
		  System.out.println(stats.getEntityFetchCount());
		  System.out.println(stats.getSecondLevelCachePutCount());
		  System.out.println(stats.getSecondLevelCacheHitCount());
		
		
		  newTc.commit();
		  anotherSession.close();
		
	}

}
