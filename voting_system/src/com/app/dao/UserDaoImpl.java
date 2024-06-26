package com.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.app.utils.DBUtils.*;

import com.app.entities.User;

public class UserDaoImpl implements UserDao {
	// state
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3,pst4,pst5,pst6,pst7,pst8;

	// def ctor of the DAO layer
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		cn = openConnection();
		// pst1 : sign in
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		// pst2 : get user details
		pst2 = cn.prepareStatement("select * from users where role='voter' and dob between ? and ?");
		// pst3 : voter reg
		/*
		 * id | first_name | last_name | email | password | 
		 * dob | status | role
		 */
		pst3 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created...");
		
		//pst4 :update voter's password
		pst4=cn.prepareStatement("update users set password=? where email=? and password=? and role='voter'");
		
		pst5=cn.prepareStatement("delete from users where email=? and role='voter'");
		
		
		pst6=cn.prepareStatement("update users set status=1 where email=?");
		
		pst7=cn.prepareStatement("update candidates set votes=votes+1 where name=?");

		
		
	
	    pst8=cn.prepareStatement("select status from users where email=? and role='voter'");
	}

	@Override
	public User signIn(String email, String password) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		// 2. exec query
		try (ResultSet rst = pst1.executeQuery()) {
			// rst cursor : before the 1st row
			
			if (rst.next()) // => successful login
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	@Override
	public List<User> getUserDetails(Date begin, Date end) throws SQLException {
		// 0. create empty list
		List<User> users = new ArrayList<>();
		// 1. set IN params
		pst2.setDate(1, begin);
		pst2.setDate(2, end);
		// 2 . exec -- exec query
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
		}
		return users;// dao rets populated list of users to the caller
	}

	@Override
	public String voterRegistration(User newVoter) throws SQLException {
		// 1. set IN params
		/*
		 * int userId, String firstName, String lastName, 
		 * String email, String password,
		 * Date dob, boolean status, String role
		 */
		pst3.setString(1, newVoter.getFirstName());
		pst3.setString(2, newVoter.getLastName());
		pst3.setString(3, newVoter.getEmail());
		pst3.setString(4, newVoter.getPassword());
		pst3.setDate(5, newVoter.getDob());
		pst3.setBoolean(6, newVoter.isStatus());
		pst3.setString(7, newVoter.getRole());
		//exec : executeUpdate
		int rows=pst3.executeUpdate();
		if(rows == 1)
			return "Voter registered....";
		return "Voter registration failed !";
	}
	
	public String updatePassword(String newPassword,String email,String oldPassword) throws SQLException
	{
		pst4.setString(2, email);
		pst4.setString(3, oldPassword);
		pst4.setString(1, newPassword);
		
		int rows= pst4.executeUpdate();
		
			if(rows==1)
				return "Password Updated";
			return "Updation failed";
				
	}
		
	public String deletevoter(String email) throws SQLException
	{
		pst5.setString(1, email);
		int rows=pst5.executeUpdate();
		if(rows==1)
		  return "User Deleted";
		
		  return "Deletion Failed";
	}
	
	
	
	public String vote(String name, String email) throws SQLException {
	    // Check if the user has already voted
	    pst8.setString(1, email);
	    try(ResultSet rst = pst8.executeQuery())
	    {
	    rst.next();
	    int stat = rst.getInt(1);
	    if (stat > 0) {
	        return "You have already voted";
	    } else {
	        
	    	// User hasn't voted yet, proceed with the vote
	        pst6.setString(1, email); // Update voter status
	        int row1 = pst6.executeUpdate();
	        if (row1 > 0) {
	            // Update candidate's vote count
	            pst7.setString(1, name);
	            int row2 = pst7.executeUpdate();
	            if (row2 > 0) {
	                return "Voted Successfully";
	            } else {
	                return "Failed to update candidate's vote count.";
	            }
	        } else {
	            return "Failed to update voter status.";
	        }
	    }
	    }
	}


	
	
//	public String vote(String name,String email) throws SQLException
//	{
//		pst8.setString(1, email);
//		ResultSet rst=pst8.executeQuery();
//		rst.next();
//		int cnt=rst.getInt(1);
//		if(cnt>0)
//		{
//			return "You have already voted";
//		}
//		else
//		{
//
//		pst6.setString(1, email); // voter updated status
//		
//		int row1=pst6.executeUpdate();
//		
//		if(row1>0)
//		{
//			pst7.setString(1,name);// candidate update status 
//			int row2=pst7.executeUpdate();
//			return "Voted Successfully";
//		}else {
//		
//			return "Failed to record vote.";
//		}
//		}
//		
//	}


	// add clean up method to close DB resources
	public void cleanUp() throws SQLException {
		System.out.println("user dao cleaned up");
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if(pst4 !=null)
			pst4.close();
		if(pst5 !=null)
			pst5.close();
		closeConnection();
	}

}
