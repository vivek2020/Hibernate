package com.vivek.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vivek.entity.Account;
import com.vivek.entity.Customer;

public class TesterMain {

	public static void main(String[] args) {
	 
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure("hibernateconfig.xml");
	    SessionFactory sessionfactory=configuration.buildSessionFactory();
	    
	    //Creating new Session 
		Session session=sessionfactory.openSession();
		Transaction tc=session.beginTransaction();
		 
		Account account=new Account();
	    Account account1=new Account();
	    Account account2=new Account();
	    
	    
	    account1.setAccountType("Saving");
	Customer customer1=new Customer("Airey","James","Denmark","14/05/1986");
	    account1.setCustomer(customer1);
	    
	    account2.setAccountType("Salary");
	    account2.setCustomer(customer1);
	    
	    Set <Account> accountsOfCustomer1=new HashSet <Account>();
	    accountsOfCustomer1.add(account1);
	    accountsOfCustomer1.add(account2);
	    
	    customer1.setAccounts(accountsOfCustomer1);
	   
         session.save(customer1);
         tc.commit();
		 session.close();
		 
	

	}

}
