package com.book.tij.chapter8;

public class AnonymusConstructor
{

	Destinations getDestinations(final String destinationName, final float price)
	{
		return new Destinations ()
		{
			private String label ;
			private int cost;
			
			/*
			 * Instance initializer acts as constructor for Anonymous classes
			 * Anonymous classes cannot have constructors as they dont have a name for tat
			 * Since this instance initialiser cannot be overloaded 
			 * 	there can only be one constructor for anonymus classes
			 */
			{
System.out.println("INSIDE INSTANCE INITIALISER");				
				label = destinationName;
				cost = Math.round(price) * 100;
				if (cost > 2000)
				{
System.out.println("OVER BUDGET");					
				}
			}
			public String readLabel ()
			{
				return label;
			}
		};
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AnonymusConstructor ().getDestinations("Home", 5000.56f);
	}
}
