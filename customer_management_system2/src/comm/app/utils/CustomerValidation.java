package comm.app.utils;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.custom_exception.CustomerException;
import com.app.customer_management.Customer ;
import com.app.customer_management.ServicePlan;


public class CustomerValidation {
	
	// add method to parse and validate plan and it's charges
	public static ServicePlan validatePlan(String plan, double registrationAmount) throws CustomerException {
		ServicePlan servicePlan= ServicePlan.valueOf(plan.toUpperCase());
		
		if(servicePlan.getplanCost()== registrationAmount)
			return servicePlan;
		
            throw new CustomerException("Invalid service plan") ;
	}
	
	
	// method to validate customer
	public static Customer validateCustomer(String firstName,String lastName,String emailId,String password,
			double registrationAmount,String dob,String plan,List<Customer> customerList) throws CustomerException
	{
		
		duplicateEmail(emailId,customerList);
//		String email=validateEmail(emailId);
		LocalDate birthdate=ValidateAge(dob);
		ServicePlan serviceplan=validatePlan(plan,registrationAmount);
        validatePass(password);
		return new Customer(firstName,lastName,emailId,password,registrationAmount,birthdate,serviceplan);
	}
	// method for parsing services
	public static ServicePlan parseService(String plan)
	{
		
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	// method for parsing date
	
	public static LocalDate parseDate(String date)
	{
		return LocalDate.parse(date);
	}
	public static String validateEmail(String emailId)throws CustomerException
	{
		String mail="\\b[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";
		if(emailId.matches(mail))
		{
			return emailId;
		}
		throw new CustomerException("email must contain @ and it should end with either\r\n"
				+ ".com | .org | .net ");
	}
	
	//method for checking duplicate email

  public static void duplicateEmail(String emailId, List<Customer> customerList) throws CustomerException
  {
	  validateEmail(emailId);
	  Customer newCust=new Customer(emailId);
	  
	  if(customerList.contains(newCust))
		  throw new CustomerException("Duplicate Customer");
  }
  
//  validate password
  public static void validatePass(String password) throws CustomerException
	{
	     String pass="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if(password.matches(pass))
		return;
		
		throw new CustomerException("Give a strong password");
	  			
	}
  // validate if enterd correct email form
//  public static String validateMail(String emailId)
//  {
//	  String mail="(())"
//	  return 
//  }
 
	// validate age of customer
 public static LocalDate ValidateAge(String dob)throws CustomerException
 {
	 LocalDate birthDate=parseDate(dob);	 
	 int age=Period.between(birthDate,LocalDate.now()).getYears();
	 
	 if(age<21)
	 
		 throw new CustomerException("Age is below 21");
			
	 
	return birthDate;
 }

}
