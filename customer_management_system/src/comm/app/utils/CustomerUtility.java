package comm.app.utils;

import java.util.List;

import com.app.custom_exception.CustomerException;
import com.app.customer_management.Customer;

public class CustomerUtility {

	public static String login(String email,String password,List<Customer>cust) throws CustomerException {
		Customer customer=new Customer(email,password);
		for (Customer c : cust) {
			if(c!=null && c.equals(customer))
			return "Login Successfully";	
			
		}
		throw new CustomerException("Invalid Email or Password");
	}
}
