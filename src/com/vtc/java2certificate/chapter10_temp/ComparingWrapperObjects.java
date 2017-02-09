package com.vtc.java2certificate.chapter10_temp;

public class ComparingWrapperObjects
{
	private static void compareIntegerObjects (Integer a, Integer b)
	{
System.out.println(a == b);		
	}
	
	private static void compareStringObjects (String a, String b)
	{
System.out.println(a == (b));		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		compareStringObjects("10", "10");
	}

}
