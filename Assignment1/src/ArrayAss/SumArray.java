package ArrayAss;

import java.util.Scanner;

public class SumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[5];
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the elements of an Array");
		
		for(int i=0;i<5;i++)
		{
			arr[i]=in.nextInt();
		}
		
		int sum=0;
		for(int i=0;i<5;i++)
		{
		  sum=sum+arr[i];
		  
		}

		System.out.println("Sum of an Array"+":-"+sum);
	}

}
