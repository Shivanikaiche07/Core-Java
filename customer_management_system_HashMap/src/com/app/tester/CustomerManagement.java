package com.app.tester;

import static comm.app.utils.CustomerValidation.validateCustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.app.custom_exception.CustomerException;
import com.app.customer_management.Customer;
import com.app.customer_management.ServicePlan;

import comm.app.utils.CustomerUtility;
import comm.app.utils.CustomerValidation;
import comm.app.utils.IOUtils;

public class CustomerManagement {

    public static void main(String[] args) {
        try(Scanner in= new Scanner(System.in))
        {
        	boolean exit = false;
        	
        	Map<String,Customer> customerMap= new HashMap<>();
        	
        	
        	while (!exit) {
                System.out.println("1.SignUp (If you are new to account)");
                System.out.println("2 SignIn (If you have already account)");
                System.out.println("3. Change our Password");
                System.out.println("4.Unsubscribe the Service");
                System.out.println("5. Customer Details");
                System.out.println("6. Sorting according to Email");
                System.out.println("7. Display customer details sorted as per the dob n last name ");
                System.out.println("8. Remove all customer details from specified plan born after specified date.\r\n"
                		+ "");
                System.out.println("9. Exit");

                System.out.println(" ");
                System.out.println("Enter your choice !!!!");
                try {
                    int choice = in.nextInt();

                    switch (choice) {
                        case 1:
                             // SignUP
                               
                                System.out.println("Enter Customer's FirstName:");
                                String fname = in.next();

                                System.out.println("Enter Customer's LastName:");
                                String lname = in.next();

                                System.out.println("Enter Customer's Email-Id:");
                                String email = in.next();

                                System.out.println("Enter Customer's Password:");
                                String pass = in.next();

                                System.out.println("Enter Customer's Registration Amount:");
                                double ramt = in.nextDouble();

                                System.out.println("Enter Customer's Date Of Birth (YYYY-MM-DD):");
                                String dob = in.next();

                                System.out.println("Enter Customer's Service Plan:");
                                String plan = in.next().toUpperCase();

                              
                                  Customer  customers = validateCustomer(fname, lname, email, pass, ramt, dob, plan, customerMap);
                                  
                                  customerMap.put(customers.getEmail(),customers);
                                    System.out.println("Customer signed up successfully!");
                                    
                                    
                                  
                                
                           
                            
                            
                            break;
                        case 2:// SignIn
                        	System.out.println("Enter email and password");
                        	Customer cust1=CustomerUtility.login(in.next(), in.next(), customerMap);
                        	System.out.println(cust1);
                        	break;
//                        	
                        case 3://Change password
                        	System.out.println("Enter email ,old password & new password");
                            String cngpass=CustomerUtility.changePassword(in.next(),in.next(), in.next(), customerMap);
                        	System.out.println(cngpass);
                        	break;
//                        	
                       case 4:  //unsubscribe customer
                            System.out.println("Enter email id of customer to delete:");
                            String deletecust = CustomerUtility.unsubscribeCustomer(in.next(), customerMap);
                            System.out.println(deletecust);

                            break;
//                            
//                        
                        case 5:// Display all Customer's Details
                        	System.out.println("Display Customers Details");
                        	for (Customer customer : customerMap.values()) {
								System.out.println(customer);
							}
                        	break;
                        	
                        case 6://writeCustomerDetails method call
                        	System.out.println("Enter file name");
                        	IOUtils.writeDetails(customerMap,in.next());
                        	System.out.println("data Stored!!!");
                        	break;
                        	
                        case 7://read details 
                        	Map<String,Customer>custmap=IOUtils.readDetails(in.next());
                        	System.out.println("Customer Details");
                        	custmap.forEach((k,v)->System.out.println(v));
                        	
                        	break;
//                        case 6://Display customer details sorted as per the email (asc) : using natural ordering
//                        	 Collections.sort(customerList);
//                        	
//                        	break;
//                        	
//                        case 7://Display customer details sorted as per the dob n last name  : using custom ordering , using anonymous inner class.
//                        	
//                        	  Collections.sort(customerList, new Comparator<Customer>()
//                        	  {
//                        		  @Override
//                        		  public int compare(Customer c1,Customer c2)
//                        		  {
//                        			  int retVal=c1.getDob().compareTo(c2.getDob());
//                        			  if(retVal==0)
//                        			  {
//                        				  return c1.getLastName().compareTo(c2.getLastName());
//                        			  }
//                        			  return retVal;
//                        		  }
//                        	  });
//                        	
//                        	
//                        	break;
//                        	
                        case 8://Remove all customer details from specified plan born after specified date.
                        	System.out.println("Enter email ,old password & new password");
                            CustomerUtility.removeSpecifiedCustomerDOBPlan(in.next(),in.next(), customerMap);
                                break;
                        case 9:
                             exit=true;
                             break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    in.nextLine(); 
                }
            }
    }
        }

	
		
}


