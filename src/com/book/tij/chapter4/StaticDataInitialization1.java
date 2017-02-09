package com.book.tij.chapter4;

public class StaticDataInitialization1 
{
	static Bowl bowl = new Bowl("Static First Bowl");
	
	Bowl bowl2 = new Bowl ("Non static second bowl");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
System.out.println("INSIDE THE MAIN METHOD OF StaticDataInitialization1 CLASS");
		new StaticDataInitialization1();
	}
	
	static Bowl bowl3 = new Bowl ("Static Third bowl");
	
	Bowl bowl4 = new Bowl ("Non static fourth bowl");
	
	private static class Bowl 
	{
		public Bowl (String name)
		{
System.out.println("Bowl Name : " + name);			
		}
		
		public void function ()
		{
System.out.println("INSIDE THE BOWL CLASS METHOD FUNCTION ");			
		}
	}
	static
	{
System.out.println("INSIDE THE StatIC BLOCK");		
	}

	static Bowl bowl5 = new Bowl("Static Fifth Bowl"); 	
}
