package MatrixAss;

import java.util.Scanner;

public class UtilityScalarMatrix {

	public static void scalartMatrix(int m[][])
	{
		Scanner in =new Scanner(System.in);
		System.out.println(" Enter Elements of a matrix ");
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				m[i][j]=in.nextInt();
			}
		}
		System.out.println("Enter the scalar number");
		 int k=in.nextInt();

		int scalar[][]=new int[3][3];
		System.out.println("Scalar Matrix:-");
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				scalar[i][j]=m[i][j]*k;
				System.out.print(" "+scalar[i][j]);
			}
		}
	}
}
