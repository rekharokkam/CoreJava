package com.vtc.java2certificate.chapter6;

import java.util.ArrayList;
import java.util.List;

public class BreakNContinueTest
{
	public static void main(String[] args)
	{
		int[][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> arrayCoordinates = new ArrayList<Integer>(3); 
		int arrayValueAtBreak = 0;
outmostLoop:for (int i = 0; i < testArray.length; i++)
			{
				for (int j = 0; j < testArray[i].length; j++)
				{
					if (testArray[i][j] == 9)
					{
						arrayValueAtBreak = testArray[i][j];
						arrayCoordinates.add(i); arrayCoordinates.add(j);
						break outmostLoop;
					}
				}
			}
System.out.println("array value at break : " + arrayValueAtBreak + " :: and the coordinates are : " + arrayCoordinates);		
	}	
}
