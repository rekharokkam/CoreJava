package com.vtc.java2certificate.chapter5;

import java.io.IOException;

public class CoVariantExceptionTest
{
	class FirstException extends Exception
	{
		
	}
	
	class SecondException extends FirstException
	{
		
	}
	
	class First
	{
		int test () throws FirstException
		{
System.out.println("First Class test method");
			return 0;
		}
	}
	
	class Second extends First
	{
		/*
		 * Can return either the base or sub-class exception
		 * but cannot throw unrelated Exception like IOException in the example below.
		 * This is not a new feature added in 1.5 exists since ...
		 */
		int test () throws SecondException
		{
System.out.println("Inside the test method of Second class ");
			return 1;
		}
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
