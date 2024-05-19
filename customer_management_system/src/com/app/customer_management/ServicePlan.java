package com.app.customer_management;

public enum ServicePlan {
	
	SILVER(1000),GOLD(2000),DAIMOND(5000),PLATINUM(10000);
	
	private double charges;
	
	ServicePlan(double charges)
	{
		this.charges=charges;
	}
	
	public String toString()
	{
		return name();
	}

	public double getchargers()
	{
		return charges;
	}
}

