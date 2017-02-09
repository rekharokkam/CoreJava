package com.book.tij.chapter9;

public class ThrowingRuntimeException
{
	private void throwRuntimeException ()
	/*
	 * A Runtime doesnt need an exception Specification
	 */
//		throws RuntimeException
	{
		/*
		 * A runtime exception always indicates Programming error
		 */
		throw new RuntimeException("from inside of throwRuntimeException()");
	}
	
	private void callMethodWithRuntimeException ()
	{
		/*
		 * If a RuntimeException gets all the way out to main( )without being caught, 
		 * printStackTrace( ) is called for tat exception as the program exits.
		 * Even if a method has RuntimeException Specification it need not be caught and compiler doesnt enforce this.
		 */
		throwRuntimeException();
		
//		try
//		{
//			throwRuntimeException();
//		}
//		catch (Exception e)
//		{
//			//By default this method sends the information to std error stream - its equivalent to calling e.printStackTrace(System.err)
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args)
	{
		new ThrowingRuntimeException().callMethodWithRuntimeException();
	}
}
