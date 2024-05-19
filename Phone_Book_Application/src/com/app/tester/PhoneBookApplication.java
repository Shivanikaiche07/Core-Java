package com.app.tester;

import java.util.HashSet;
import java.util.Scanner;

import com.app.classes.PhoneBook;
import com.app.custom_exception.PhoneBookException;
import com.app.custom_validations.PhoneBookValidations;
import com.app.utils.PhoneBookUtility;

public class PhoneBookApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		try(Scanner in=new Scanner(System.in)){
		HashSet<PhoneBook> phonebooks= new HashSet<>();
		
		boolean exist=false;
		try {
		while(!exist)
		{
			System.out.println("1. Add Person's Information");
			System.out.println("2. Display All Person's Information");
			System.out.println("3. Update Phone Number ");
			System.out.println("4. Update  Email");
			System.out.println("5. Exit");
            System.out.println("Enter the choice");
            switch (in.nextInt()) {
			case 1://Adding person in phone book
				System.out.println("Enter the details");
				System.out.println("PhoneNumber"+" "+"Name"+" "+"DateOfBirth"+" "+"Email");
				
				try {
					PhoneBook Phnbk = PhoneBookValidations.validateUserInputs(in.next(), in.next(), in.next(), in.next(), phonebooks);
					phonebooks.add(Phnbk);
					System.out.println(Phnbk);
				} catch (PhoneBookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 2:// display details
				PhoneBookUtility.displayDetails(phonebooks);
				break ;

			case 3://update phone number
				 
				  System.out.println("Enter the Name,DateOfBirth, old PhoneNumber & new PhoneNumber which you want to update ");
				  String updatePhoneNumber=PhoneBookUtility.updatePhnNum(in.next(),in.next(),in.next(), in.next(), phonebooks);
				  System.out.println(updatePhoneNumber);
				break;
			case 4:// update email
				System.out.println("Enter the Name,DateOfBirth, old Email & new Email which you want to update ");
				  String updatemails=PhoneBookUtility.updateEmail(in.next(),in.next(),in.next(), in.next(), phonebooks);
				  System.out.println(updatemails);
				break;
			case 5:// delete record of phonebook
				System.out.println("Enter Name and DateOfBirth to delete the PhoneBook Record");
				String deleterecord=PhoneBookUtility.deletePhoneBookrecord(in.next(), in.next(), phonebooks);
				System.out.println(deleterecord);
				break;
			default:
				break;
			}
			
			
		}
		} catch (Exception e) {
            System.out.println(e.getMessage());
            in.nextLine();
		
	}
	}
}
}
