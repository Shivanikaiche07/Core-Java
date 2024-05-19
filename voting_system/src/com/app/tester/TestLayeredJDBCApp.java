package com.app.tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.app.dao.AccountDaoImpl;
import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

public class TestLayeredJDBCApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. init phase --invoked once @ beginning of app
			// created dao instance (i.e Tester :
			// dependent is creating it's own dependency)
			UserDaoImpl userDao = new UserDaoImpl();
			// create a Candidate dao instance
			CandidateDaoImpl candDao=new CandidateDaoImpl();
			//create account dao 
			AccountDaoImpl acctDao=new AccountDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Voter Login \n" + "2 : Display user details by DoB\n"
						+ "3. Voter registration \n" +"4.Update Voter's password \n"+"5.Delete voter \n"+"6.Transfer Funds \n"+"7.Candidate Login \n"+"8.Voting\n"+ "0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // login
						System.out.println("Enter email n password");
						User user = userDao.signIn(sc.next(), sc.next());
						if (user != null) {
							System.out.println("Voter Login Successful !!!");
							System.out.println(user);
						} else
							System.out.println("Invalid email or password!!!!");
						break;
					case 2:
						System.out.println("Enter start n end DoBs(yr-mon-day)");
						List<User> list = userDao.getUserDetails(Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						System.out.println("Users -");
						list.forEach(System.out::println);// u -> sop(u)
						break;
					case 3:
						System.out.println("Enter Voter's details - firstName,  lastName, email,  password,  dob");
						//create transient(not yet persistent in DB) user instance 
						user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
						System.out.println("Reg status " + userDao.voterRegistration(user));
						break;
						
					case 4:
						System.out.println("Enter Voter's details- email,oldpassword and newpasseord ");
					    String userpass=userDao.updatePassword(sc.next(), sc.next(), sc.next());
					    System.out.println("update password"+userpass);
						
						break;
					case 5:
						System.out.println("Enter Voter's details- email");
					    String deluser=userDao.deletevoter(sc.next());
					    System.out.println(deluser);
						break;

					case 6:
						System.out.println("Enter src AccNo, desc AccNo and amount");
						System.out.println(acctDao.transferFunds(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
						break;
						
					case 7:// candidate login
						System.out.println("Enter CandidateName and PartyName of user");
						Candidate cand= candDao.signIn(sc.next(), sc.next());
						if(cand != null)
						{
							System.out.println("Voter Login Successful !!!");
                            System.out.println(cand);
						}
						else
							System.out.println("Invalid CandidateName or PartyName");
						break;
						
					case 8:
						System.out.println("Enter candidate Name and Email ");
						
						System.out.println(userDao.vote(sc.next(), sc.next()));
						
						
					break;

						
					case 0:
						exit = true;
						// destroy (shutdown/terminate app)
						userDao.cleanUp();
						acctDao.cleanUp();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
