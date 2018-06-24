package com.vivek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name = "employee_name",nullable=false)
	private String name;
	@Column(name = "employee_email",unique=true,nullable=false)
	private String email;
	@Column(name = "employee_address",nullable=false)
	private String address;
	@Column(name = "employee_salary",nullable=false)	
	private double salary;
	
	public Employee()
	{}
	
	public Employee(String name,String email, String address,double salary)
	{
		this.name=name;
		this.email=email;
		this.address=address;
		this.salary=salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}

