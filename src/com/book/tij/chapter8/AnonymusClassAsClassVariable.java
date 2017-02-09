package com.book.tij.chapter8;

public class AnonymusClassAsClassVariable
{
	private Destinations destination = new Destinations()
		{
			public String readLabel ()
			{
				return "I am from Anonymus class as Class variable";
			}
		};
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
System.out.println(new AnonymusClassAsClassVariable().destination.readLabel());			
	}

}
