package com.book.tij.chapter8;

public class AnonymusClassUsingOuterClassVariable
{
	/*
	 * If an anonymus inner class wants to use an object defined outside
	 * of the anonymus class then the argument reference has to be final.
	 */
	Destinations getDestination(final String destinationName)
	{
		return new Destinations()
		{
			private String label = destinationName;
			public String readLabel()
			{
				return label;
			}
		};
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
