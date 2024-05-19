package ArrayAss;

import java.util.Scanner;

public class SelectionSort {
	

	public void sort(int []arr)
	{
	
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
			      if(arr[i]>arr[j])
			      {
			    	  int temp=arr[i];
			    	  arr[i]=arr[j];
			    	  arr[j]=temp;
			      }
			      
			}	
			
		}
	 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SelectionSort s1=new SelectionSort();
		Scanner in=new Scanner(System.in);
		
		int arr[]=new int [6];

		
		System.out.println("Enter the Elements of an Array");
		
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=in.nextInt();
		}
		
		System.out.println("After Selection Sort");
	
		s1.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);

	}

}
	}
