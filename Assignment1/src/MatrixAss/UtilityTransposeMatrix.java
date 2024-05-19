package MatrixAss;

import java.util.Scanner;

public class UtilityTransposeMatrix {
	
	public static void acceptMatrix(int o[][])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter elements of Matrix");
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
			  o[i][j]=in.nextInt();
			}
		}
	}
	
	public static void transposeMatrix(int o[][])
	{
		int transpose[][]=new int [3][3];
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				transpose[i][j]=o[j][i];
				System.out.print(transpose[i][j]);
			}
		
	}

}
}
