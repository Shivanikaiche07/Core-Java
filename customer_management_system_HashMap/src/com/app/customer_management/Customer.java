package com.app.customer_management;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer  implements Serializable{

	private int customerId ;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	static int idGenerator;
	
	
	
	public Customer(String firstName,String lastName,String emailId,String password, double registrationAmount,LocalDate dob,ServicePlan plan) {
		super();
		this.customerId = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan=plan;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + ", registrationAmount=" + registrationAmount
				+ ", dob=" + dob + "]";
	}
   
   
	
   public ServicePlan getPlan() {
	return plan;
}
public void setPlan(ServicePlan plan) {
	this.plan = plan;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail()
   {
	   return emailId;
   }
	public Customer(String emailId)
	{
		this.emailId=emailId;
	}
	public void setEmail(String emailId)
	{
		this.emailId=emailId;
	}
	public static int getIdGenerator() {
		return idGenerator;
	}
	public static void setIdGenerator(int idGenerator) {
		Customer.idGenerator = idGenerator;
	}

	
}
