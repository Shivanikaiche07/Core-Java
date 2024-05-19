package com.app.tester;

import static comm.app.utils.CustomerValidation.*;
import java.util.Scanner;
import com.app.customer_management.Customer;
import com.app.custom_exception.CustomerException;

import comm.app.utils.CustomerUtility;
import comm.app.utils.CustomerValidation;


public class CustomerManagement {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            System.out.println("Enter the number of customers:");
            Customer[] customers = new Customer[in.nextInt()];
            int counter = 0;

            boolean exit = false;
            while (!exit) {
                System.out.println("1. Customer SignUp");
                System.out.println("2. Customer SignIn");
                System.out.println("0. Exit");

                try {
                    int choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            if (counter < customers.length) {
                               
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

                                try {
                                    customers[counter++] = validateCustomer(fname, lname, email, pass, ramt, dob, plan, customers);
                                   for (Customer customer : customers) {
									
                                	   if(customer!=null)
                                	   System.out.println(customer);
                        
								}
         
                                    System.out.println("Customer signed up successfully!");
                                    
                                } catch (CustomerException e) {
                                    System.out.println( e.getMessage());
                                }
                            } else {
                                System.out.println("Customer System is Full");
                            }
                            
                            
                            break;
                        case 2:
                        	System.out.println("Enter email and password");
                        	String cust1=CustomerUtility.login(in.next(), in.next(), customers);
                        	System.out.println(cust1);
                        	
                               
                            break;
                        case 0:
                            exit = true;
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
