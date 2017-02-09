package com.vtc.java2certificate.chapter10_temp;

public class PassByRefExample
{
	private static void testStringPassByReference (String a)
	{
		a = a + " World";
		
System.out.println("Inside the function string value after manipulation : " + a);		
	}

	private static void testIntegerPassByReference (Integer a)
	{
		a = 20;		
System.out.println("Inside the function Integer value after manipulation : " + a);		
	}

	
	public static void main(String[] args)
	{
//		String a = "Hello ";
//		testStringPassByReference(a);
//System.out.println("After manipulation : " + a);
		
		Integer a = new Integer(10);
		testIntegerPassByReference(a);
System.out.println("After manipulation : " + a);		

	}
}
