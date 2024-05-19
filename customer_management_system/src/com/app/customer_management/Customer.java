package com.app.customer_management;

import java.time.LocalDate;

public class Customer {

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
	public Customer(String emailId,String password) {
		super();
		
		this.emailId = emailId;
		this.password = password;
		
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + ", registrationAmount=" + registrationAmount
				+ ", dob=" + dob + "]";
	}

   @Override
	public boolean equals(Object o)
	{
		if (o instanceof Customer)
		{
			Customer c=(Customer)o;
			return this.emailId.equals(c.emailId)&&this.password.equals(password);
		}
		return false;
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
