package ArrayAss;

public class UtilityArray {
	
	public static void maxArray(int arr[])
	{
		int max=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if (arr[i]>max)
			{
				max=arr[i];
			}
		}
		System.out.println("Maximum Element of an Array:-"+max);
	}
	
	public static void sumArray(int arr[])
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		System.out.println("Sum of an all Elements of an Array:-"+sum);
	}
	
	public static void avgArray(int arr[])
	{
	 
		int sum=0;
		int avg=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		avg=sum/arr.length;
		System.out.println("Average of an Array:-"+avg);
		
	}
	
	public static void selectionSort(int arr[])
	{
		for(int i=0;i<5;i++)
		{
			for(int j=i+1;j<5;j++)
			{
				if (arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		
	}


}
