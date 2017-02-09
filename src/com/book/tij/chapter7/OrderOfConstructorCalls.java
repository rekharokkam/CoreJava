package com.book.tij.chapter7;

public class OrderOfConstructorCalls {
	
	static int print(String message)
	{
System.out.println(message);
		return 10;
	}

	public static void main(String[] args) 
	{
		new Sandwich();
	}
}

class Bread
{
	private int i = OrderOfConstructorCalls.print("BREAD :: VARIABLE");
	Bread ()
	{
System.out.println("BREAD :: CONSTRUCTOR");		
	}
	
}

class Cheese
{
	private int i = OrderOfConstructorCalls.print("CHEESE :: VARIABLE");
	Cheese ()
	{
System.out.println("CHEESE :: CONSTRUCTOR");		
	}
	
}

class Lettuce	
{
	private int i = OrderOfConstructorCalls.print("LETTUCE :: VARIABLE");
	Lettuce ()
	{
System.out.println("LETTUCE :: CONSTRUCTOR");		
	}
	
}

class Meal 
{
	private int i = OrderOfConstructorCalls.print("MEAL :: VARIABLE");
	Meal ()
	{
System.out.println("MEAL :: CONSTRUCTOR");		
	}
}

class Lunch extends Meal 
{
	private int i = OrderOfConstructorCalls.print("LUNCH :: VARIABLE");
	Lunch ()
	{
System.out.println("LUNCH :: CONSTRUCTOR");		
	}
}

class PortableLunch extends Lunch
{
	private int i = OrderOfConstructorCalls.print("PORTABLELUNCH :: VARIABLE");
	PortableLunch ()
	{
System.out.println("PORTABLELUNCH :: CONSTRUCTOR");		
	}
}

class Sandwich extends PortableLunch
{
	private int i = OrderOfConstructorCalls.print("SANDWICH :: VARIABLE");
	private Bread bread = new Bread();
	private Cheese cheese = new Cheese();
	private Lettuce lettuce = new Lettuce();
	
	Sandwich ()
	{
System.out.println("SANDWICH :: CONSTRUCTOR");		
	}
}
