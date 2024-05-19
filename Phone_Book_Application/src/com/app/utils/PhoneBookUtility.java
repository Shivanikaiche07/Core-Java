package com.app.utils;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.classes.PhoneBook;
import com.app.custom_exception.PhoneBookException;
import com.app.custom_validations.PhoneBookValidations;

public class PhoneBookUtility {
//	
	public static void displayDetails(HashSet<PhoneBook>phnset)
	{
		for (PhoneBook phoneBook : phnset) {
			System.out.println(phoneBook);
		}
    
		
	}
	
	public static String updatePhnNum(String name,String dob,String oldphoneNumber,String newphoneNumber,HashSet<PhoneBook>phonebooks) throws PhoneBookException
	{
        LocalDate date=PhoneBookValidations.parsedate(dob);
		PhoneBookValidations.validatePhoneNumber(oldphoneNumber);
		for (PhoneBook phoneBook : phonebooks) {
			if(phoneBook.getName().equals(name)&& phoneBook.getDob().isEqual(date))
					{
				      phoneBook.setPhoneNumber(PhoneBookValidations.validateEmail(newphoneNumber));
				
				      return "PhoneNumber Updated Successfully";
				
					}	
			
		}
		throw new PhoneBookException("Invalid Name or DateOfBirth");
	
	}
	
	public static String updateEmail(String name,String dob,String oldmail,String newmail,HashSet<PhoneBook>phonebooks) throws PhoneBookException
	{
        LocalDate date=PhoneBookValidations.parsedate(dob);
		PhoneBookValidations.validateEmail(oldmail);
		for (PhoneBook phoneBook : phonebooks) {
			if(phoneBook.getName().equals(name)&& phoneBook.getDob().isEqual(date))
					{
				phoneBook.setEmail(PhoneBookValidations.validateEmail(newmail));
				return "Email Updated Successfully";
				
					}	
			
		}
		throw new PhoneBookException("Invalid Name or Email");
	
	}
	
	public static String deletePhoneBookrecord(String name,String dob,HashSet<PhoneBook>phonebooks)throws PhoneBookException
	{
		LocalDate date=PhoneBookValidations.parsedate(dob);
		PhoneBook phnbook=new PhoneBook(name,date);
         phonebooks.remove(phnbook);
		return "PhoneBook Record deleted Successfully";
	}

}
