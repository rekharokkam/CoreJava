package com.book.tij.chapter6;

import java.util.Random;

public class FinalData 
{
	private static final Random random = new Random ();
	
	//compile - time constants
	private final int VALUE_ONE = 1;
	private static final int VALUE_TWO = 2;
	
	//run time constants
	private final int i1 = random.nextInt(5);
	private static final int i2 = random.nextInt(10);
	
	private Value v1 = new Value (10);

	//Object reference constants
	private static final Value v2 = new Value (20);
	private final Value v3 = new Value (25);
	
	//array final
	private final int[] a = {1, 2, 3}; 
	
	public String toString()
	{
		return "i1 : " + i1 + " , i2 : " + i2;
	}
	
	public static void main(String[] args) 
	{
		FinalData fd1 = new FinalData ();
//		fd1.a = new int[3]; // not possible to rebind
//		v2 = new Value (100);//cannot rebind
//		fd1.v3 = new Value (200);//cannot rebind
		
		v2.i = 25; // can change the contents but not the reference
		fd1.v3.i = 40;
		fd1.v1.i = 50;
		
		for (int i = 0; i < fd1.a.length; i++) 
		{
			fd1.a[i]++;
		}
		
//		fd1.i1 ++; //cannot assign new value as it is final 
//		i2 ++; ////cannot assign new value as it is final
		
System.out.println("fd11 :: " + fd1);

		FinalData fd2 = new FinalData ();
System.out.println("fd12 :: " + fd2);
	}
}

class Value 
{
	int i;
	public Value (int i)
	{
		this.i = i;
	}
	
	public String toString()
	{
		return "Value :: " + i;
	}
}
