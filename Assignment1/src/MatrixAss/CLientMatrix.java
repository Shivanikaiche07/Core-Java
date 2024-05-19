package MatrixAss;

import java.util.Scanner;

public class CLientMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int m1[][]=new int [3][3];
		int m2[][]=new int [3][3];
		
		
		
		
		Scanner in=new Scanner(System.in);
		
		while(true)
		{
			System.out.println(" ");
			System.out.println("1.Addition of Matrix");
			System.out.println("2.Subtraction of Matrix");
			System.out.println("3.Multiplication of Matrix");
			System.out.println("4.Transpose of Matrix");
			System.out.println("5. Scalar Matrix");
			System.out.println("6. Symmetric Matrix");
			System.out.println("Enter a Choice ");
			int ch=in.nextInt();
			switch(ch)
			{
			case 1:UtilityMatrix.acceptMatrixs(m1, m2);
				UtilityMatrix.addMatrix(m1, m2);
			       
				break;
			case 2:UtilityMatrix.acceptMatrixs(m1, m2);
				UtilityMatrix.subMatrix(m1, m2);
			       
				break;
			case 3:UtilityMatrix.acceptMatrixs(m1, m2);
				UtilityMatrix.mulMatrix(m1, m2);
			     
				break;
			case 4:UtilityTransposeMatrix.acceptMatrix(m2);
			       UtilityTransposeMatrix.transposeMatrix(m2);
			    break;
			case 5:UtilityScalarMatrix.scalartMatrix(m2);
			    break;
			case 6:UtilitySymmetricMatrix.symmetricMatrix(m1, m2);
			default:
				return;
		}
		
		
	}

	}
	
}