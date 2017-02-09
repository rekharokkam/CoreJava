package com.book.tij.chapter4;

public class NonStaticInitialization 
{
	Mug mug1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
System.out.println("INSIDE THE MAIN METHOD");
		new NonStaticInitialization();
	}
	
	{
		mug1 = new Mug("One");
		mug3 = new Mug ("Three");
	}
	
	private static class Mug
	{
		String name;
		public Mug (String name)
		{
			this.name = name;
System.out.println("INSIDE THE MUG CONSTRUCTOR :: " + name);			
		}
		
		public void function ()
		{
System.out.println("INSIDE THE FUNCTION OF MUG :: " + name);			
		}
	}
	
	Mug mug2 = new Mug ("Two");	
	Mug mug3;
}
