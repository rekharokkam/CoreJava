package com.book.tij.chapter9;

public class FinallyGetsExecutedAlways
{
	private static Switch sw = new Switch ();
	
	void f()
		throws FinallyAlwaysException
	{
		throw new RuntimeException("from inside of f()");
	}
	
	public static void main(String[] args)
	{
		/*
		 * Switch should be off when there is an exception / after the competion of process
		 * First try block gets executed. Then catch and then finally block.
		 */
		try
		{
			sw.switchOn();
			new FinallyGetsExecutedAlways().f();
			
			//if there is no exception then switch is turned off.
//			sw.switchOff();
		}
		catch (FinallyAlwaysException e)
		{
System.err.println("inside the catch block");

			//If there is an exception of type FinallyAlwaysException switch is turned off.
//			sw.switchOff();
		}
		finally
		{
			/*			 
			 * The switch is tunred off irrespective of what happens.
			 * Code in the finally block always gets executed irrespective of what happens else where.
			 */
			sw.switchOff();
		}
	}
}

class Switch 
{
	private boolean state = false;
	
	boolean read ()
	{
		return state;
	}
	
	void switchOff ()
	{
System.out.println("switch is off");		
		state = false;
	}
	
	void switchOn ()
	{
		state = true;
	}
}

class FinallyAlwaysException extends Exception
{
	private static final long serialVersionUID = 6183662280525503705L;
}