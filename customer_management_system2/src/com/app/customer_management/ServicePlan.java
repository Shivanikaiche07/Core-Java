package com.app.customer_management;

public enum ServicePlan {
	
	SILVER(1000),GOLD(2000),DAIMOND(5000),PLATINUM(10000);
	
	private double planCost;
	
	private ServicePlan(double cost)
	{
		this.planCost=cost;
	}
	
	public String toString()
	{
		return name();
	}

	public double getplanCost()
	{
		return planCost;
	}
}

