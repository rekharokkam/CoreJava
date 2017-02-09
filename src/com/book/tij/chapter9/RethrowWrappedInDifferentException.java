package com.book.tij.chapter9;

public class RethrowWrappedInDifferentException
{
	private static void f ()
		throws FirstException
	{
		throw new FirstException ("From f()");		
	}
	
	private static void g()
//		throws Throwable
		throws SecondException
	{
		try
		{
			f();
		}
		catch (FirstException firstException)
		{
System.err.println("catch block of g method");
			firstException.printStackTrace();
System.err.println("\n\n");		

			/*
			 * The information about the original site of the exception is lost, and 
			 * what you’re left with is the information pertaining to the new throw
			 */

			throw new SecondException("from g()");
//			throw firstException.fillInStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			g();
		}
//		catch (Throwable secondException)
		catch (SecondException secondException)
		{
System.err.println("catch block of main method");			
			secondException.printStackTrace();
		}
	}
}

class FirstException extends Exception
{
	FirstException(String msg)
	{		
		super (msg);
	}
}

class SecondException extends Exception
{
	SecondException (String msg)
	{
		super (msg);
	}
}