package com.book.tij.chapter9;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedToUnChecked
{
	void throwRuntimeException (int type)
	{
		try
		{
			/*
			 * Throws Checked Exceptions.
			 */
			switch (type)
			{
				case 0:	
					throw new FileNotFoundException();
				case 1:
					throw new IOException();
				case 2:
					throw new RuntimeException();		
				default:
					return;
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException (e);
		}
	}
	public static void main(String[] args) 
	{
		CheckedToUnChecked test = new CheckedToUnChecked();
		
		for (int i = 0; i < 1; i++)
		{	
			try
			{
				if (i < 3)
				{
					test.throwRuntimeException(i);
				}
				else
				{
					throw new SomeOtherException();
				}				
			}
			catch (SomeOtherException e)
			{
System.err.println("INISDE THE SomeOtherException HANDLER");				
			}
			/*
			 * Catch exceptions only when u know what to do with them.
			 */
			catch (RuntimeException e)
			{
				e.printStackTrace();
				try
				{
System.out.println("class name : " + e.getCause().getClass().getName());					
					throw e.getCause();
				}
				catch (FileNotFoundException ex)
				{
System.err.println("INISDE THE FileNotFoundException HANDLER");	
					ex.printStackTrace();
				}
				catch (IOException ex)
				{
System.err.println("INSIDE THE IOException HANDLER");					
				}
				catch (Throwable ex)
				{
System.err.println("INSIDE THE Throwable HANDLER");					
				}
			}
		}
	}
}

class SomeOtherException extends Exception
{
	private static final long serialVersionUID = 7318151927049596736L;
}
