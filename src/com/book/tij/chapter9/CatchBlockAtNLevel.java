package com.book.tij.chapter9;

public class CatchBlockAtNLevel
{
	void f()
		throws CatchBlockException
	{
		throw new CatchBlockException("from inside of f()");
	}
	
	void g()
		throws CatchBlockException
	{
		try
		{
			f();
		}
		finally
		{
			//do nothing
		}
	}
	
	void h ()
		throws CatchBlockException
	{
		g();
	}
	
	void i ()
	{
		try
		{
			h();
		}

		/*
		 * An exception keeps getting passed on till there is a handler for it.
		 */
		catch (CatchBlockException e)
		{
e.printStackTrace();			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new CatchBlockAtNLevel().i();
	}
}

class CatchBlockException extends Exception
{
	private static final long serialVersionUID = 8969165892468148440L;

	CatchBlockException()
	{
		super ();
	}
	
	CatchBlockException(String msg)
	{
		super (msg);
	}
}
