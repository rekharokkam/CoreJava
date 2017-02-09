package com.book.tij.chapter4;

import java.util.Random;

public class MultidimensionalArrays 
{
	void staticInitialization2DimensionArray()
	{
		int[][] a1 = new int[][]{
				new int[]{1, 2, 3},
				new int[] {3, 4, 5},
		};
		
		int[][] a2 = {
				{1, 2},
				{3, 4}
		};
		
		for (int i = 0; i < a1[0].length; i++) 
		{
			for (int j = 0; j < a1.length; j++) 
			{
System.out.print("a1[" + i + "][" + j + "] : " + a1[j][i] + "\t");				
			}
System.out.println();			
		}
		
	}
	
	void dynamicInitialization2DimensionArray()
	{
		int[][] a1 = new int[3][];//rows
		for (int i = 0; i < a1.length; i++)  
		{
			a1[i] = new int[3]; //columns
			for (int j = 0; j < a1[i].length; j++) 
			{
				a1[i][j] = (i * j);
			}
		}
		
		for (int i = 0; i < a1.length; i++) 
		{
			for (int j = 0; j < a1[i].length; j++) 
			{
System.out.print("a1[" + i + "][" + j + "] : " + a1[i][j] + "\t");				
			}
System.out.println();			
		}
	}

	void dynamicInitialization2DimensionObjectArray()
	{
		Integer[][] a1 = new Integer[new Random().nextInt(4)][];//rows
		for (int i = 0; i < a1.length; i++)  
		{
			a1[i] = new Integer[new Random().nextInt(4)]; //columns
			for (int j = 0; j < a1[i].length; j++) 
			{
				a1[i][j] = new Integer(i * j);
			}
		}
		
		for (int i = 0; i < a1.length; i++) 
		{
			for (int j = 0; j < a1[i].length; j++) 
			{
System.out.print("a1[" + i + "][" + j + "] : " + a1[i][j] + "\t");				
			}
System.out.println();			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new MultidimensionalArrays().dynamicInitialization2DimensionObjectArray();
	}

}
