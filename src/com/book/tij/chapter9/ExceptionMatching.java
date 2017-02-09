package com.book.tij.chapter9;

public class ExceptionMatching
{
	void throwRuntimeException ()
	{
		try
		{
			throw new IndexOutOfBoundsException();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) 
	{
		ExceptionMatching exceptionMatching = new ExceptionMatching ();
		try
		{
			exceptionMatching.throwRuntimeException();
		}
		catch (RuntimeException e)
		{
			try
			{
System.out.println("THE EXACT EXCEPTION CLASS : " + e.getCause().getClass().getName());					
				e.printStackTrace();
				throw e.getCause();
			}
		
			/*
			 * When an exception is thrown the exception handling system looks for nearest handler in the order they are written.
			 * When a handler is found then the system assumes tat the exception is handled and no furthur searching happens
			 * So more than one catch block is not entered for an exception amongst all the catch blocks for tat try block.
			 * Matching of an exception handler need not be a perfect match all derived exception classes match their base class exception handlers.
			 * 
			 *  First checks for the exact exception handler if not found goes one level up to the next parent handler.
			 *  if not found then keeps traversing up the tree till some handler for some parent is found.
			 *  
			 *   eg: IndexOutOfBoundsException is what is thrown actually.
			 *   First ExceptionHandingSystem looks for a match for IndexOutOfBoundsException.
			 *   If found then executes tat if not found then looks for the parent - RuntimeException.
			 *   If not found then the next parent - Exception.
			 *   If not found then next parent - Throwable.
			 */
				
			catch (IndexOutOfBoundsException ex)
			{
System.err.println("INISDE THE IndexOutOfBoundsException HANDLER");	
				ex.printStackTrace();
			}
//			catch (IOException ex)
//			{
//System.err.println("INSIDE THE IOException HANDLER");					
//			}
			catch (RuntimeException ex)
			{
System.err.println("INSIDE THE RuntimeException HANDLER");
			}
//			catch (Exception ex)
//			{
//System.err.println("INISDE THE Exception HANDLER");					
//			}
			catch (Throwable ex)
			{
System.err.println("INSIDE THE Throwable HANDLER");					
			}							
		}		
	}
}
