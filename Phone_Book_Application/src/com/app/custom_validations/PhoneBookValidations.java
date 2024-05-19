package com.app.custom_validations;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.classes.PhoneBook;
import com.app.custom_exception.PhoneBookException;

public class PhoneBookValidations {
	
	public static PhoneBook  validateUserInputs(String phoneNumber,String name,String dob,String email,HashSet<PhoneBook> phonebooks) throws PhoneBookException
	{
		
		LocalDate dateofbirth=LocalDate.parse(dob);
		String validatedPhoneNumber = validatePhoneNumber(phoneNumber);
		String validatename=validateName(name);
		String validatemail=validateEmail(email);
		duplicateNameDob(name,dob,phonebooks);
        return new PhoneBook(validatedPhoneNumber, validatename, dateofbirth, validatemail);

		
	}
	
	public static void duplicateNameDob(String name,String birthdate,HashSet<PhoneBook> phonebooks) throws PhoneBookException
	{
		LocalDate dateOfBirth=parsedate(birthdate);
		PhoneBook newphnbook= new PhoneBook(name,dateOfBirth);
		
		if(phonebooks.contains(newphnbook))
		{
			
			throw new PhoneBookException("Duplicate PhoneBook ");
		}
	}
	
	public static LocalDate parsedate(String dob)
	{
		return LocalDate.parse(dob);
	}
	
	public static String validatePhoneNumber(String phoneNumber)throws PhoneBookException
	{
		String phnum="\\d{10}";
		if(phoneNumber.matches(phnum))
		{
			return phoneNumber;
		}
		throw new PhoneBookException("Invalid Phone Number ");
	}
	
	public static String validateName(String name)throws PhoneBookException
	{
		String phname="^[a-zA-Z]+[a-zA-Z]+$";
		if(name.matches(phname))
		{
			return name;
		}
		throw new PhoneBookException("Invalid Name Entered ");
	}
	
	public static String validateEmail(String email) throws PhoneBookException
	{
		
		String mail="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if(email.matches(mail))
		{
			return email;
		}
		throw new PhoneBookException("Invalid Email Entered");
	}


}
