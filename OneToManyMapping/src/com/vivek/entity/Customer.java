package com.vivek.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="Customer_First_Name",nullable=false)
	private String firstName;
	@Column(name="Customer_Last_Name",nullable=false)
	private String lastName;
	@Column(name="Customer_Address",nullable=false)
	private String address;
	@Column(name="Customer_DateOFBirth",nullable=false)
	private String DOB;
	
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private Set<Account> accounts;
	
	public Customer(String firstName,String lastName,String address,String DOB)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.DOB=DOB;
		this.accounts=accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
