package MatrixAss;

import java.util.Scanner;

public class UtilityMatrix {

	public static void acceptMatrixs(int m1[][],int m2[][])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Matrix 1:-");
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				m1[i][j]=in.nextInt();
			}
		}
		
		System.out.println("Enter Matrix 2:-");	
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				m2[i][j]=in.nextInt();
			}
		}
	}
	

	public static void addMatrix (int m1[][],int m2[][])
	{
		int m[][]=new int[3][3];
		Scanner in=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				m[i][j]=m1[i][j]+m2[i][j];
				System.out.print(m[i][j]+" ");
			}
		}
	}
	


	public static void subMatrix (int m1[][],int m2[][])
	{
		int m[][]=new int[3][3];
		Scanner in=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				m[i][j]=m1[i][j]-m2[i][j];
				System.out.print(m[i][j]+" ");
			}
		}
	}
	
	public static void mulMatrix (int m1[][],int m2[][])
	{
		int m[][]=new int[3][3];
		Scanner in=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.println(" ");
			for(int j=0;j<3;j++)
			{
				m[i][j]=m1[i][j]*m2[i][j];
				System.out.print(m[i][j]+" ");
			}
		}
	}
	
	
	
}
