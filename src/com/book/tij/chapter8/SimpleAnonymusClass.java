package com.book.tij.chapter8;

public class SimpleAnonymusClass
{
	Contents getContents ()
	{
		//Anonymus inner class is created with default constructor
		return new Contents() //Anonymus Inner class implmenting Contents interface 
		{
			//Cannot have static variables inside non-static anonymus inner class 
//			static Name name = new Name ("");
			Name name1 = new Name ("NON-StatIC VARIABLE INSIDE ANONYMUS INNER CLASS");
			private int i = 47;
			public int value ()
			{
				return i;
			}
		}; 
		/*
		 * Semicolon doesnt mark the end of class definition but
		 * marks the end of expression which contains the class definition
		 * this rule same as every where else in the compilation unit
		 */
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SimpleAnonymusClass simpleAnonymusClass = new SimpleAnonymusClass();
		simpleAnonymusClass.getContents();
	}
}
interface Contents
{
	int value();
}