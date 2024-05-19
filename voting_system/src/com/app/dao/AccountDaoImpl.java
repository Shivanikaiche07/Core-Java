package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AccountDaoImpl implements AccountDao {
	
	private Connection cn;
	private CallableStatement cst1;
	
	public AccountDaoImpl() throws SQLException {
		// get DB connection from DB Utils
		cn=openConnection();
		//create callable statement
		cst1=cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//register OUT parameters 
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("acct dao created ......");

	}

	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		// 1.set IN parameters
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		
		cst1.execute();
		return "Updated src balance"+cst1.getDouble(4)+"dest balance"+cst1.getDouble(5);
		
		
	}
	
	//cleanup
	public void cleanUp() throws SQLException
	{
		if(cst1!=null)
			cst1.close();
		closeConnection();
		System.out.println("Account Dao cleanup");
	}

}
