package com.book.tij.chapter9;

public class OnlyTryFinallyWithoutCatch
{
	void f() throws OnlyTryBlockException
	{
		throw new OnlyTryBlockException();
	}
	
	/*
	 * Just having a try - finally block for those methods which throw checked exception doesnt suffice.
	 * there has been a catch block mandatorily for checked exceptions.
	 * If there is no catch block then the exception specification needs to be present.
	 */
	void g()
//		throws OnlyTryBlockException
	{
		try
		{
//			f();
		}
		finally
		{
			
		}
	}
	
	public static void main(String[] args)
	{
	}
}

class OnlyTryBlockException extends Exception
{	
}

