package com.app.classes;

import java.time.LocalDate;
import java.util.Objects;

public class PhoneBook {

	private String phoneNumber;
    private final String name;
    private final LocalDate dob;
    private String email;
    
  
    
    public PhoneBook(String phoneNumber,String name,LocalDate dob,String email) {
    	this.phoneNumber=phoneNumber;
    	this.name=name;
    	this.dob=dob;
    	this.email=email;
    }
    
    //add overloaded ctor 
     public PhoneBook(String name,LocalDate dob){
    	this.name=name;
    	this.dob=dob;

    }
    @Override
    public boolean equals(Object o)
    {
    	if(o instanceof PhoneBook)
    	{
    		PhoneBook phb=(PhoneBook)o;
    		return this.name.equals(phb.name)&& this.dob.equals(phb.dob);
    	}
    	return false;
    }
    
    @Override
    public int hashCode()
    {
    	return 17*name.hashCode()+dob.hashCode();
    }
//    


	@Override
	public String toString() {
		return "PhoneBook [phoneNumber=" + phoneNumber + ", name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}


//
//	@Override
//	public int hashCode() {
//		return Objects.hash(dob, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PhoneBook other = (PhoneBook) obj;
//		return Objects.equals(dob, other.dob) && Objects.equals(name, other.name);
//	}

	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public LocalDate getDob() {
		return dob;
	}

public void setEmail(String email )
{
	this.email=email;
}



	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}
    
 
	
	
}
