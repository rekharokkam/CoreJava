package com.book.tij.chapter9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsInConstructors
{
	public static void main(String[] args) 
	{
		try
		{
			InputFile in = new InputFile("login.config");
			while (in.readLine() != null)
			{
				//do some operation
			}
			in.dispose();
		}
		catch (Exception e)
		{
System.err.println("caught exception in main");
			e.printStackTrace();			
		}
	}
}

class InputFile
{
	private BufferedReader in;
	
	InputFile(String fileName)
	
		/*
		 * Exception is being thrown in the constructor so tat the client doesnt assume 
		 * tat the object is properly created and is valid 
		 */
		throws Exception
	{
		try
		{
			in = new BufferedReader (new FileReader (fileName));
		}
		/*
		 * Only one of the catch blocks is entered.
		 */
		catch (FileNotFoundException e)
		{
			//the buffered reader need not be closed because its not yet opened
System.err.println("the file couldnt be opened so need not be closed");
			throw e;
		}
		catch (Exception e)
		{
System.err.println("inside the catch block of constructor");			
			try
			{
				/*
				 * Reader is already opened for reading in case of any other exception
				 */
				in.close();
			}
			catch (IOException ex)
			{
System.err.println("the reader couldnt be properly closed");				
			}
			throw e;			
		}
		finally
		{
			/*
			 * Reader shouldnt be closed here because this block of code gets executed every time and even before the code
			 * exits from the constructor the reader object gets closed.
			 * Not always the resources can be released in finally block
			 */
		}
	}
	
	String readLine ()
	{
		try
		{
			return in.readLine();
		}
		catch (IOException e)
		{
			throw new RuntimeException ("reading from the file failed");
		}		
	}
	
	void dispose ()
	{
		try
		{
			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException ("close couldnt be performed properly from inside of dispose method");
		}
	}
}