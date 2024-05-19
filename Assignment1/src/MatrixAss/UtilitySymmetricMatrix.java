package MatrixAss;

import java.util.Scanner;

public class UtilitySymmetricMatrix {
	
	public static void symmetricMatrix(int m1[][],int m2[][])
	{
		Scanner in =new Scanner(System.in);
		int i,j,flag=0;
		System.out.println("Enter number of rows of Matrix");
		i=in.nextInt();
		System.out.println("Enter number of columns of Matrix");
		j=in.nextInt();
		
		if(i!=j)
		{
		 System.out.println("Here rows are not equal to column . Not a symmetric matrix");
		 return ;
		}
		
		for(int x=0;x<3;x++)
		{
		  System.out.println(" ");
		  for(int y=0;y<3;y++)
		  {
			  m1[x][y]=in.nextInt();
		  }
		}
		// Transpose Matrix 
		
		for(int x=0;x<3;x++)
		{
		  System.out.println(" ");
		  for(int y=0;y<3;y++)
		  {
			  m2[y][x]=m1[x][y];
			  System.out.println(" "+m2[x][y]);
		  }
		}
		
		
		for(i= 0; i< 3; i++)
	    {
	        for(j = 0;j < 3; j++)
	        {
	            if(m1[i][j] != m2[i][j])
	            {
	                flag=1;
	                break;
	            }
	        }
	    }
	    if(flag == 0)
	    {
	        System.out.println("\nThe given Matrix is a Symmetric Matrix ");
	    }
	    else
	    {
	    	 System.out.println ("\nThe given Matrix is Not a Symmetric Matrix ");
	    }
	 
	   
		
	}

}
