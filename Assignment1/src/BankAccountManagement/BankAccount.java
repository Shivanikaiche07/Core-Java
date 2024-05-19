package BankAccountManagement;

public class BankAccount {
	
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	public BankAccount()
	{
		accountNumber="N.A";
		accountHolderName="N.A";
		balance=00;
	}
	public BankAccount(String accountNumber,String accountHolderName ,double balance)
	{
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
	}

	public String toString()
	{
		return accountNumber+accountHolderName+balance;
	}
	public double getBalance() {
		return balance;
	}

}
