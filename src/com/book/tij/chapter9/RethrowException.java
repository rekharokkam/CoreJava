package com.book.tij.chapter9;

public class RethrowException
{
	private static void e()
		throws Exception
	{
		throw new Exception ("originating from e()");
	}
	
	private static void f()
		throws Exception
	{
System.err.println("inside f()");		
		throw new Exception ("from inside of f()");

	}
	
	private static void g()
//		throws Exception
		throws Throwable
	{
		try
		{
			e();
			f();
		}
		catch (Exception e)
		{
System.err.println("inside the exception handler of g()");

			/*
			 * Irrespective of how many times an exception gets thrown 
			 * it still preserves all the information about the orginal exception stack trace
			 */

//			throw e;

			/*
			 * This method gives rise to a new stack trace.
			 * What you’re left with is the information pertaining to the new throw
			 */
			throw e.fillInStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
//		throws Throwable
	{
		try
		{
			g();
		}
		catch (Throwable e)
		{
e.printStackTrace();			
		}
		
	}
}
