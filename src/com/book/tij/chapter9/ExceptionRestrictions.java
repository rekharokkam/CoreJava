package com.book.tij.chapter9;

public class ExceptionRestrictions
{
	/*
	 * Methods cannot be overloaded based on Exception Specification.
	 * Exception specification is not part of method specification. Only Method name and argument types form the method.
	 */
//	void f()
//		throws StormException
//	{
//		
//	}
//	
//	void f()
//		throws BaseBallException
//	{
//		
//	}
	
	public static void main(String[] args) 
	{
		Inning inning = null;
		Storm storm = null;
		StormyInning stormyInning = null;
		try
		{
			inning = new StormyInning();
			storm = new StormyInning();
			stormyInning = new StormyInning();
		}
		catch (RainedOutException e)
		{
			
		}
		catch (BaseBallException e)
		{
			
		}
		

		/*
		 * the compiler forces you to catch only the exceptions tat are specific to tat class, but if you upcast to the base type, 
		 * then the compiler (correctly) forces you to catch the exceptions for the base type.
		 */
		try
		{
			inning.event();
		}
		catch (BaseBallException e){}
		
		try
		{
			storm.event();
		}
		catch (RainedOutException e){}
		
		stormyInning.event();
		
		try
		{
			inning.atBat();
		}
		catch (FoulException e){}
		catch (StrikeException e)
		{}
	}
}

abstract class Inning
{
	Inning ()
		throws BaseBallException
	{
		
	}
	
	public void event ()
		throws BaseBallException
	{
	
	}

	void walk ()		
		{}

	abstract void atBat ()
		throws FoulException, StrikeException;
}

class StormyInning extends Inning implements Storm
{
	StormyInning ()
		throws BaseBallException, RainedOutException
	{
		/*
		 * Restriction on exceptions doesnt apply to constrcutors. Current class can throw any exception irrespective of what
		 * the base class constructor throws.
		 * Since it is not possible to catch the base class constructor's exception because super call should be the first statement 
		 * its being thrown in the current constructor as well.
		 */
//		try
//		{
//			super ();
//		}
//		catch (BaseBallException e)
//		{
//			
//		}
		
	}
	
	StormyInning (String s)
		throws BaseBallException, StormException
	{
		
	}
	
	public void event (){}

	/*
	 * Can throw only those exceptions defined in the base class / interface.
	 * By forcing the derived class methods to confirm to the base class exception specification 
	 * substituability of objects is maintained. 	
	 * 
	 * if client code is written for base class method then any derived Object of the base class can be substitued and
	 * the exception handling would still not break in the client code.
	 */
//	public void walk ()
//		throws BaseBallException
//	{
//		
//	}
	
	/*
	 * Overriding methods can either throw the same exception or the subclasses of the base class exception.
	 */
	public void atBat ()
		throws PopFoulException
	{
		
	}

	/*
	 * An overriding/implementing method need not throw exception(s) thrown by the baseclass/interface.
	 * 
	 */
	public void rainHard ()		
	{
		
	}
}

interface Storm
{
	void event ()
		throws RainedOutException;
	void rainHard ()
		throws RainedOutException;
}

class BaseBallException extends Exception
{
	private static final long serialVersionUID = 5928181151974240966L;	
}

class StrikeException extends BaseBallException
{
	private static final long serialVersionUID = -1770085858315699084L;
}

class FoulException extends BaseBallException
{
	private static final long serialVersionUID = 154668454409316813L;
}

class PopFoulException extends FoulException
{
	private static final long serialVersionUID = -3333556745667190095L;
}

class StormException extends Exception
{
	private static final long serialVersionUID = 9125596096431521635L;
}

class RainedOutException extends StormException
{
	private static final long serialVersionUID = 232530147143328135L;
}
