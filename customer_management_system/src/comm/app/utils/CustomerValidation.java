package comm.app.utils;
import java.time.LocalDate;

import com.app.custom_exception.CustomerException;
import com.app.customer_management.Customer ;
import com.app.customer_management.ServicePlan;


public class CustomerValidation {
	
	public static void validatePlan(ServicePlan plan, double registrationAmount) throws CustomerException {
		for (ServicePlan servicePlan : ServicePlan.values()) {
            if (servicePlan.name().equals(plan)) {
                return;
            }
		}
            throw new CustomerException("Invalid service plan") ;
	}
	
	public static Customer validateCustomer(String firstName,String lastName,String emailId,String password, double registrationAmount,String dob,String plan,Customer []customers) throws CustomerException
	{
		duplicateEmail(emailId,customers);
		
		LocalDate birthdate=parseDate(dob);
		
		ServicePlan serviceplan=parseService(plan);

		return new Customer(firstName,lastName,emailId,password,registrationAmount,birthdate,serviceplan);
	}
	
	public static ServicePlan parseService(String plan)
	{
		return ServicePlan.valueOf(plan);
	}
	
	public static LocalDate parseDate(String date)
	{
		return LocalDate.parse(date);
	}

  public static void duplicateEmail(String emailId, Customer[] cust) throws CustomerException
  {
	  Customer email=new Customer(emailId);
	  
	  for (Customer customer : cust) {
		  if(customer !=null && customer.equals(email))
				throw new CustomerException("Duplicate Email_ID");
	}
  }
  
  public static Customer checkForEmail(String email,Customer[]cust)throws CustomerException{
	  Customer custid= new Customer(email);
	  for (Customer customer : cust) {
		if (customer!=null && customer.equals(customer))
		{
			return customer;
		}
	}
	  throw new CustomerException("Invalid User Email");
  }
	
}
