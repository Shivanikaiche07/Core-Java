package vechile_management;

public class ValidatePollution {

	public static void validatePollution(Vehicle v) throws PollutionExceedException 
	{
		if(v.getPollutionlevel() <=20)
		{
			System.out.println("You can Drive the Vehicle");
		}else {
		throw new PollutionExceedException("Pollution level Exceeds 20%");
	}
	}
}
