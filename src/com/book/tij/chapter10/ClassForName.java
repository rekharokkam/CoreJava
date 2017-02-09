package com.book.tij.chapter10;

public class ClassForName
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Candy();
System.out.println("AFTER INITIALISATION OF Candy CLASS");
		try
		{
			Class.forName("com.fic.book.tij.chapter10.Gum");
System.out.println("AFTER INITIALISATION OF Gum CLASS");
		}
		catch (ClassNotFoundException e)
		{
e.printStackTrace();			
		}

		new Cookie();
System.out.println("AFTER INITIALISATION OF Cookie CLASS");
	}

}

class Candy 
{
	static
	{
System.out.println("INSIDE THE StatIC BLOCK OF Candy CLASS");		
	}
}

class Gum 
{
	static
	{
		/*
		 * This gets called immediately after the class object gets loaded.
		 * In the above example it gets called when Class.forname() is called.
		 */
System.out.println("INSIDE THE StatIC BLOCK OF Gum CLASS");		
	}
}

class Cookie 
{
	static
	{
System.out.println("INSIDE THE StatIC BLOCK OF Cookie CLASS");		
	}
}
