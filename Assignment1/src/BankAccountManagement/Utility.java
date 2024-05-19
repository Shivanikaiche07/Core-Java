package BankAccountManagement;

import java.util.Scanner;

public class Utility {
	
	public double depositeMoney()
	{
		Scanner in =new Scanner(System.in);
		System.out.println("Enter Money to deposite");
		double deposite=in.nextDouble();
		return deposite;
	}
	
	public double withdrawMoney()
	{
		Scanner n=new Scanner(System.in);
		System.out.println("Enter Money to withdraw");
		double withdraw=n.nextDouble();
		return withdraw;
	}
	

}
