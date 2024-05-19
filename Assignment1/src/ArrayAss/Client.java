package ArrayAss;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]=new int [5];
		Scanner cin=new Scanner(System.in);
		
		System.out.println("Enter the elements of array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=cin.nextInt();
		}
		
		System.out.println("Elements of  an Array");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		
		
		while(true)
		{
			System.out.println("1.Maximun Element of an Array");
			System.out.println("2.Sum of all Elements of an Array");
			System.out.println("3.Average of all Elements of an Array");
			System.out.println("4.Sorting of an Array in Ascending order");
			System.out.println("Enter the choice");
			int ch=cin.nextInt();
			
			switch(ch)
			{
			case 1: UtilityArray.maxArray(arr);
				break;
			case 2: UtilityArray.sumArray(arr);
				break;
			case 3: UtilityArray.avgArray(arr);
				break;
			case 4:
			       UtilityArray.selectionSort(arr);
			       System.out.println("Elements of  sorted an Array");
					for(int i=0;i<arr.length;i++)
					{
						System.out.println(arr[i]);
					}
				break;
			default :
				return;
			}
			
				}

	}

}
