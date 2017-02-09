package com.book.tij.chapter4;

public class OrderOfInitialization 
{
	Tag tag1 = new Tag(1, "JSP");
	
	public OrderOfInitialization()
	{
System.out.println("INSIDE THE CONSTRUCTOR OF OrderOfInitialization");
		tag3 = new Tag (10, "J2EE");
	}
	
	Tag tag2 = new Tag(2, "Servlet");
	
	void function()
	{
System.out.println("INSIDE A CUSTOM FUNCTION");	
		tag3 = new OrderOfInitialization.Tag (20, "J2ME");
	}
	
	Tag tag3 = new Tag(3, "Applet");
	
	private static class Tag 
	{	
		String name;
		public Tag(int marker, String name)
		{
			this.name = name;
System.out.println("MARKER : " + marker + ", NAME : " + name);			
		}
		
		public void finalize()
		{
System.out.println("INSIDE THE FINALIZE OF TAG  : " + name);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		OrderOfInitialization orderOfInitialization = new OrderOfInitialization();
		orderOfInitialization.function();
		
//		System.gc();
	}
}
