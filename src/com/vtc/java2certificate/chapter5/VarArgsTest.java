package com.vtc.java2certificate.chapter5;

public class VarArgsTest
{
	static void printVarArgs (int ... value)
	{
System.out.println("VarArgs Length : " + value.length);
		for (int i : value)
		{
System.out.println(i);			
		}
	}

	static void printArrayArgs (int [] value)
	{
System.out.println("Array Length : " + value.length);

		for (int i : value)
		{
System.out.println(i);			
		}
	}

	public static void main(String[] args)
	{
		printVarArgs(new int[]{1, 2, 3});
		printArrayArgs(new int[]{4, 5, 6});
		
	}
}
