package com.app.entities;

public class Candidate {
	
//	 id | name    | party    | votes
	
  private int candid;
  private String candidateName;
  private String partyName;
  private int votes=0;
  
  public Candidate(int candid,String candidateName,String partyName,int votes)
  {
	  this.candid=candid;
	  this.candidateName=candidateName;
	  this.partyName=partyName;
	  this.votes=votes;
  }
  
  //ctor for candidate registration
  public Candidate(String candidateName,String partyName)
  {
	  super();
	  this.candidateName=candidateName;
	  this.partyName=partyName;

  }


public int getCandid() {
	return candid;
}

public void setCandid(int candid) {
	this.candid = candid;
}

public String getCandidateName() {
	return candidateName;
}

public void setCandidateName(String candidateName) {
	this.candidateName = candidateName;
}

public String getPartyName() {
	return partyName;
}

public void setPartyName(String partyName) {
	this.partyName = partyName;
}

public int getVotes() {
	return votes;
}

public void setVotes(int votes) {
	this.votes = votes;
}

@Override
public String toString() {
	return "Candidate [candid=" + candid + ", candidateName=" + candidateName + ", partyName=" + partyName + ", votes="
			+ votes + "]";
}
  
}
