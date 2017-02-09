package com.book.tij.chapter4;

public class StaticBlock 
{
	static Cup cup4 = new Cup("Four");
	static
	{
System.out.println("INSIDE THE StatIC BLOCK");		
		cup1 = new Cup("One");
		cup3 = new Cup ("Three");
	}
	
	static Cup cup2 = new Cup("Two");
	/**
	 * @param args
	 */

	public static void main(String[] args) 
	{
//System.out.println("INSIDE THE MAIN METHOD");		
//		StaticBlock.cup1.function();
	}
	
	
	static Cup cup1;
	
	private static class Cup
	{
		String name;
		public Cup(String name)
		{
			this.name = name;
System.out.println("INSIDE THE CUP CONSTRUCTOR :: " + name);			
		}
		
		public void function ()
		{
System.out.println("INSIDE THE FUNCTION OF :: " + name);			
		}
	}
	
	static Cup cup3 ;

}
