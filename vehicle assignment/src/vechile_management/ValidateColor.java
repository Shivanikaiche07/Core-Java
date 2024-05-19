package vechile_management;

public class ValidateColor {

	public static void colorValidation(Color color)throws InvalidColorCustomException
	{
		Color c[]= Color.values();
		for (Color color1 : c)
		{
		   if(color1 == color)
		   {
			   return;
		   }
		}
		
		throw new InvalidColorCustomException("Invalid Color:-"+color);
	}
	
	
}
