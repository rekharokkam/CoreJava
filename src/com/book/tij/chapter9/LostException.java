package com.book.tij.chapter9;

public class LostException
{
	void f() 
		throws ImportantException
	{
		throw new ImportantException();
	}
	
	void g ()
		throws HoHumException
	{
		throw new HoHumException();
	}
	
	void h()
		throws Exception
	{
		/*
		 * If both the exceptions ImportantException - from f() and HoHumException - from g() are not caught
		 * And are being thrown from the same method as shown then first exception gets lost only last one gets caught.
		 * so better to use try-catch block for every exception thrown from any method
		 */
		try
		{
			f();
		}
//		catch (Exception exception)
//		{
//exception.printStackTrace();			
//		}
		finally
		{
//			try
//			{
				g();
//			}
//			catch (Exception exception)
//			{
//exception.printStackTrace();				
//			}
		}
	}
	
	public static void main(String[] args)
	{
		LostException lostException = new LostException();
		try
		{
			lostException.h();
		}
		catch (Exception exception)
		{
exception.printStackTrace();			
		}
	}
}

class ImportantException extends Exception
{
	private static final long serialVersionUID = -4392679189318541416L;
	
}

class HoHumException extends Exception
{
	private static final long serialVersionUID = 5715134137119451349L;
}