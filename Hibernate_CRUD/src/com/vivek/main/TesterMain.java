package com.vivek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vivek.entity.Employee;


public class TesterMain {

	public static void main(String[] args) {
	 
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
	    SessionFactory sessionfactory=configuration.buildSessionFactory();
	    
	    //Creating new Session 
		Session session=sessionfactory.openSession();
		Transaction tc=session.beginTransaction();
		 
		//Creating a new Employee 
		Employee employee=new Employee("Airey","airey@gmail.com","London",90000);
		int id=(Integer)session.save(employee);
         System.out.println("New Employee Added of id "+id);
		
        //Reading the Employee
		
		employee=(Employee)session.load(Employee.class,id);
		System.out.println("Employee Read of id "+employee.getId());
		System.out.println(employee.getName() +" "+ employee.getSalary());
		
         //updating the employee 
		employee=(Employee)session.load(Employee.class,id);
		employee.setSalary(80000);
        session.saveOrUpdate(employee);
        System.out.println("Employee Updated of id "+employee.getId());
        System.out.println(employee.getName()+" "+employee.getSalary());
        
           //deleting the employee
        
           employee=(Employee)session.load(Employee.class,id); 
           System.out.println("Deleting employee of id"+employee.getId());
           session.delete(employee);
		
		
		
		
		 tc.commit();
		 session.close();
		 
		
			
		
			
			
			
		
			
		 
		 


	}

}
