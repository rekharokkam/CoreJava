package com.book.tij.chapter9;

import java.io.IOException;

public class DeclareToThrowExceptionWhichIsNotThrown
{
	/*
	 * This method just declares the exception and doesnt throw it.
	 */
	private void f()
		throws IOException
	{
	
	}
	
	private void g()
	{
		try
		{
			f();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
