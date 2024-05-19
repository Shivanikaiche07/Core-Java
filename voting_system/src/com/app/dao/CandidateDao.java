package com.app.dao;

import java.sql.SQLException;

import com.app.entities.Candidate;

public interface CandidateDao {
	
	// add a method for Candidate login 

	Candidate signIn(String candidateName,String partyName ) throws SQLException;
	
}
