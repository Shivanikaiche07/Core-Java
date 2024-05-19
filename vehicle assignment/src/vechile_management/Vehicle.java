package vechile_management;

import java.time.LocalDate;
import java.util.Date;

enum Color{
	WHITE,SILVER,BLACK,RED,BLUE
}
public class Vehicle {

	private String chassiNo;
	private Color color;
	private double price;
	private LocalDate manufactureDate;
	private LocalDate insuranceDate;
	private double pollutionlevel;
	static int cnt=0;
	
	
	public Vehicle(String chassiNo, Color color, double price, LocalDate manufactureDate, LocalDate insuranceDate,
			double pollutionlevel) {
		super();
		this.chassiNo = chassiNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.insuranceDate = insuranceDate;
		this.pollutionlevel = pollutionlevel;
	}


	public String getChassiNo() {
		return chassiNo;
	}


	public void setChassiNo(String chassiNo) {
		this.chassiNo = chassiNo;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDate getManufactureDate() {
		return manufactureDate;
	}


	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}


	public LocalDate getInsuranceDate() {
		return insuranceDate;
	}


	public void setInsuranceDate(LocalDate insuranceDate) {
		this.insuranceDate = insuranceDate;
	}


	public double getPollutionlevel() {
		return pollutionlevel;
	}


	public void setPollutionlevel(double pollutionlevel) {
		this.pollutionlevel = pollutionlevel;
	}


	public String toString()
	{
		return "ChassiNo:- ," +chassiNo+"Color:- ,"+color+"Price:- ,"+price+"ManufactureDate:- ,"+manufactureDate+"InsuranceDate:- ,"+insuranceDate+"Pollutionlevel:- ,"+pollutionlevel;
	}

	
	
	
}
