package comm.app.utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.app.custom_exception.CustomerException;
import com.app.customer_management.Customer;
import com.app.customer_management.ServicePlan;

public class CustomerUtility {

	// method for login customer  
	public static String login(String email,String password,List<Customer> cust) throws CustomerException {
		Customer customer=new Customer(email);
		int index=cust.indexOf(customer);
			if(index == -1)
		throw new CustomerException("Invalid Email ");
			
			if(cust.get(index).getPassword().equals(password))
			{	
			
			return "Login Successfully";
			}
			throw new CustomerException("Invalid Password");
	}
		
//	public static String unsubscribeCustomer(String email,List<Customer> cust)throws CustomerException
//	{
//		for (Customer customer : cust) {
//			if(customer.getEmail().contains(email))
//			{
//				cust.remove(customer);
//				return "Customer deleted Successfully";
//			}
//		}
//		throw new CustomerException(email+"Not found");
//	}
	// unsubscribe customers
	public static String unsubscribeCustomer (String email,List<Customer> cust) throws CustomerException {
		Customer customer=new Customer(email);
		int index=cust.indexOf(customer);
			if(index == -1)
		throw new CustomerException("Invalid Email ");
			
			cust.remove(index);
			return "Customer deleted Successfully";
			
			
	}
	
	
//	change password method
	public static String changePassword(String email,String oldPassword,String newPassword,List<Customer> customerList) throws CustomerException{
		for (Customer customer : customerList) {
			if(customer.getEmail().contains(email) && customer.getPassword().contains(oldPassword))
			{
				customer.setPassword(newPassword);
				return "Password Changed Successfully";
			}
		}
		throw new CustomerException("Invalid Email or Password");
	}
	
	
//	public static Customer changePassword(String email,String oldPassword,String newPassword,List<Customer> cust) throws CustomerException {
//		Customer customer=new Customer(email);
//		int index=cust.indexOf(customer);
//			if(index == -1)
//		throw new CustomerException("Invalid Email ");
//			
//			if(cust.get(index).getPassword().equals(oldPassword))
//			{	
//				customer.setPassword(newPassword);
//			return customer;
//			}
//			throw new CustomerException("Invalid Password");
//	}
	

//	Remove all customer details from specified plan born after specified date.
    public static void removeSpecifiedCustomerDOBPlan (String date,String Plan,List<Customer> cust) 
    {
      Iterator<Customer> custItr=cust.iterator();
      System.out.println("Customer via iterator");
      while(custItr.hasNext())
      {
        Customer customer=custItr.next();
         ServicePlan pn=ServicePlan.valueOf(Plan.toUpperCase());
         LocalDate d=LocalDate.parse(date);
         if(customer.getPlan()==pn && customer.getDob().isAfter(d))
        	 custItr.remove();
      }
    }
//	
	
	
}
