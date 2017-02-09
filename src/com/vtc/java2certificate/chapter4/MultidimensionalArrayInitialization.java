package com.vtc.java2certificate.chapter4;

public class MultidimensionalArrayInitialization
{
	private static int[][] populateMultiDimensionalArrayBracketWay ()
	{
		return (new int[][] {{1,2}, {3,4}});
	}

	private static int[][] populateMultiDimensionalArrayHardWay ()
	{
		int[][] intArray = new int[2][2];
		int eachMatrixElement = 0;
		for (int i = 0; i < intArray.length; i ++)
		{
			for (int j = 0; j < intArray[i].length ; j ++)
			{
				intArray[i][j] = ++eachMatrixElement;
			}
		}
		
		return intArray;
	}
	
	public static void main(String[] args)
	{
		int[][] intMultiarray = populateMultiDimensionalArrayHardWay();
		for (int i = 0; i < intMultiarray.length; i++)
		{
			for(int j = 0; j < intMultiarray[i].length; j ++)
			{
System.out.print(intMultiarray[i][j] + "\t");				
			}
System.out.println("\n");
		}
	}
}
