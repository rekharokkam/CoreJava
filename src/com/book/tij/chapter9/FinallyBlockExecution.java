package com.book.tij.chapter9;

public class FinallyBlockExecution
{
	static int counter = 0;
	
	public static void main(String[] args)
	{		
//		while (true)
//		{
//			try
//			{
//				if (counter ++ == 0)
//				{
//System.out.println("throwing the exception now");					
//					throw new FinallyBlockException();
//				}
//			}
//			catch (FinallyBlockException e)
//			{
//System.out.println("inside the catch block");				
//			}
//			/*
//			 * Finally will be executed before the exception handling mechanism continues its search for a handler at the next higher level
//			 */
//			finally
//			{
//System.out.println("inside the finally block : " + counter);				
//				if (counter == 2)
//				{
//					break;
//				}
//			}
//		}
//System.out.println("outside the while loop");		
		
//		new FinallyBlockExecution(). finallyWithBreak ();
//		new FinallyBlockExecution(). finallyWithReturn ();
		new FinallyBlockExecution(). finallyWithContinue ();
	}
	
	private void finallyWithBreak ()
	{
		while (true)
		{
System.out.println("inside the while loop");			
			try
			{
System.out.println("inside the try block of finallyWithBreak()");
				break;
			}
			/*
			 * finally gets called even after break is called.
			 */
			finally
			{
System.out.println("inside the finally block of finallyWithBreak()");				
			}
		}		
	}
	
	private void finallyWithReturn()
	{
		try
		{
System.out.println("inside the finallyWithReturn() method before calling the return method");
			return;
		}
		/*
		 * finally gets executed even when return is called
		 */
		finally
		{
System.out.println("inside the finally block of finallyWithReturn()");
		}
	}
	
	private void finallyWithContinue()
	{
		int counter = 0;
		while (true)
		{
			try
			{
System.out.println("inside the try block of finallyWithContinue()");
				if (++counter < 3)
				{
					continue;
				}
				else
				{
					break;
				}
			}
			/*
			 * finally gets executed even when continue is called
			 */
			finally
			{
System.out.println("inside the finally block of finallyWithContinue() : " + counter);				
			}
		}		
	}
}

class FinallyBlockException extends Exception
{
	private static final long serialVersionUID = 8052166618309249802L;	
}
