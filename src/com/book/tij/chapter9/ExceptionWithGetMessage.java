package com.book.tij.chapter9;

public class ExceptionWithGetMessage
{

	private static void f() throws MyException
	{
System.out.println("INSIDE THE FUNCTION f()");
		throw new MyException();
	}
	
	private static void g() throws MyException
	{
System.out.println("INSIDE THE FUNCTION g()");
		throw new MyException("from g() func exception");
	}

	private static void h() throws MyException
	{
System.out.println("INSIDE THE FUNCTION h()");
		throw new MyException("from h() func exception ", 100);
	}
	
	public static void main(String[] args)
	{
		try
		{
			f();
		}
		catch (MyException e)
		{
			e.printStackTrace(System.out);
		}
		
		try
		{
			g();
		}
		catch (MyException e)
		{
			e.printStackTrace(System.out);
		}

		try
		{
			h();
		}
		catch (MyException e)
		{
//			e.printStackTrace(System.out);
			
			/*
			 * System.out.println calls the getMessage() method of exception class because toString() method internally calls getMessage() method
			 */ 
System.err.println(e);			
		}
	}
}

class MyException extends Exception
{
	private static final long serialVersionUID = -3124740652556771662L;

	private int x;
	
	MyException()
	{		
	}
	
	MyException (String message)
	{
		super (message);
	}
	
	MyException (String message, int x)
	{
		super (message);
		this.x = x;
	}
	
	public int val ()
	{
		return x;
	}
	
	/*
	 * getMessage() method is like toString() method for exception classes	 
	 */
	public String getMessage ()
	{
//System.out.println("INSIDE THE getMessage() OF MyException CLASS");		
		return "THIS MESSAGE IS FROM getMessage() METHOD : " + super.getMessage();
	}
}