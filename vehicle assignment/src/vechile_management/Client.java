package vechile_management;

import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in=new Scanner(System.in);

		Vehicle []v =new Vehicle[10];
		
		while(true)
		{
			System.out.println("1.Add Vehicle");
			System.out.println("2.Drive Vehicle");
			System.out.println("3.Exit");
			System.out.println("Enter choice");
			
			
			
			
			switch(in.nextInt())
			{
			case 1:
				
				try (Scanner cin=new Scanner(System.in)){
					
					System.out.println("Enter Chassis No:-");
					String chassisno=cin.next();
					
					System.out.println("Enter the color:-");
					Color colors=Color.valueOf(cin.next().toUpperCase());
					
					ValidateColor.colorValidation(colors);
					
					System.out.println("Enter price:-");
					double price=cin.nextDouble();
					
			       System.out.println("Enter  ManifactureDate");
			       LocalDate manudate= LocalDate.parse(cin.next());
			      
				  
			       System.out.println("Enter  InsuranceExpDate");
			            
			       LocalDate expdate=LocalDate.parse(cin.next());

					System.out.println("Enter pollution:-");
				
	               double pollution=cin.nextDouble();
	               
	               v[Vehicle.cnt++]=new Vehicle(chassisno,colors,price,manudate,expdate,pollution);
	               
	               for(int i=0;i<Vehicle.cnt;i++)
	               {
	            	  System.out.println(v[i]);
	                   
	               }
	               
	            break;
				  
				}
				catch(InvalidColorCustomException e)
				{
				    System.out.println(e.getLocalizedMessage());
			
				}
			
				catch(DateTimeParseException e)
				{
					System.out.println(e.getMessage());
				}
				
			case 2: 
				
			try {
		
				System.out.println("Enter Vehicle for Driving");
				int vehicle=in.nextInt();
				ValidatePollution.validatePollution(v[vehicle]);

			}catch(PollutionExceedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
}
