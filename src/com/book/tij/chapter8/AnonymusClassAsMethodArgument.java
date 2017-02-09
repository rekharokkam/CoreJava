package com.book.tij.chapter8;

public class AnonymusClassAsMethodArgument
{
	private void printDestinationLabel (Destinations destination, int a)
	{
System.out.println(destination.readLabel());
	}

	public static void main(String[] args)
	{
		new AnonymusClassAsMethodArgument().printDestinationLabel(
				//Method argument Anonymus class
				new Destinations()
				{
					public String readLabel ()
					{
System.out.println("INSIDE THE ANONYMUS METHOD ARGUMENT CLASS");
						return "I am from method argument anonymus class";
					}
				}, 100 );
	}
}
