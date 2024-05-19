package ArrayAss;

import java.util.Scanner;

public class MaxArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]=new int[5];
		int max;
		
		Scanner cin= new Scanner(System.in);
		
		System.out.println("Enter the Elements of an Array");
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=cin.nextInt();
		}
		
         max=arr[0];
         
      
 		for(int i=0;i<arr.length;i++)
 		{
          if(max<arr[i])
          {
        	  max=arr[i];
          }
          
 		}
 		
 		System.out.println("Maximum Element:-"+ max);

	}

}
