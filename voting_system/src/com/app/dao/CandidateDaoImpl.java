package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.app.utils.DBUtils.*;
import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao{

	// state
	private Connection cn;
	private PreparedStatement ps1,ps2;
	
	// default ctor of the DAO layer
public 	CandidateDaoImpl() throws SQLException{
	
	cn=openConnection();
	ps1=cn.prepareStatement("select * from candidates where name=? and party=?");
	ps2=cn.prepareStatement("update candidates set votes=votes+1 where name=?");
	
}
	
	@Override
	public Candidate signIn(String candidateName, String partyName) throws SQLException {
		ps1.setString(1,candidateName);
		ps1.setString(2, partyName);
		
		try(ResultSet rst=ps1.executeQuery())
		{
			if(rst.next())
				return new Candidate(rst.getInt(1),candidateName,partyName,rst.getInt(4));
		}
		
		
		
		return null;
	}

	
	public void cleanUP() throws SQLException
	{
		System.out.println("user Dao cleaned up");
          if(ps1!=null)
        	  ps1.close();
	closeConnection();
	}
	
	
}
