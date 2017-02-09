package com.book.tij.chapter4;

import java.util.Random;

public class ArrayInitialization 
{
	int[] a1;	
	{
//		a1 = {1, 2}; //This special initialization not allowed here. This initialization can be used only along with creation of array
		a1 = new int[1];
	}
	
	void specialArrayInitialize ()
	{
//		a1 = {1, 2};//This special initialization not allowed here. This initialization can be used only along with creation of array
		a1 = new int[0];
		
		int[] a2;
//		a2 = {1, 3};//This special initialization not allowed here. This initialization can be used only along with creation of array
		
//		a2 = new int[2];		
	}
	
	void testArrayCopying()
	{
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = array1;
		
		for (int i = 0; i < array2.length; i++) 
		{
			array2[i]++;
		}
		
		for (int i = 0; i < array1.length; i++) 
		{
System.out.println("array[" + i + "] : " + array1[i]);			
		}
	}
	
	void arrayBlankInitialization()
	{
		int[] array1 = new int[new Random().nextInt(10)];
System.out.println("THE ARRAY LENGTH :: " + array1.length);
		for (int i = 0; i < array1.length; i++) 
		{
System.out.println("array[" + i + "] : " + array1[i]);			
		}
	}
	
	void differentArrayInitilizationPatterns()
	{
		Integer[] a1 = {new Integer (1), new Integer (2), }; // Below type of initialization not allowed
		Integer[] a2 ;//
		a2 = new Integer[] {new Integer (1), new Integer (2), };
	}
	
	void differentArrayObjectInitialization()
	{
		Object[] a1 = new Object[]{new String("Hi"), new Integer(10), new Double (12.36)};
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new ArrayInitialization().arrayBlankInitialization();
	}

}
