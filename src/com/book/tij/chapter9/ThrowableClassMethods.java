package com.book.tij.chapter9;

public class ThrowableClassMethods
{
	public static void main(String[] args)
	{
		try
		{
			throw new Exception ("My Exception");
		}
		catch (Exception e)
		{
System.err.println("getMessage() : " + e.getMessage());			
System.err.println("getLocalizedMessage() : " + e.getLocalizedMessage());
System.err.println("toString() : " + e);
System.err.println("STACK TRACE");
e.printStackTrace();
		}
	}
}
