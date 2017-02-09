package com.book.tij.chapter6;

class Cleanser
{
	public void scrub()
	{
System.out.println("inside the scrub method of Cleanser");		
	}
	
	public static void main(String args[])
	{
System.out.println("INSIDE THE MAIN METHOD OF CLEANSER CLASS");
		new Cleanser().scrub();
	}
}

public class Detergent extends Cleanser
{
	public void scrub()
	{
System.out.println("inside the scrub method of Detergent");
		super.scrub();
	}
	
	public static void main(String[] args) 
	{
		new Detergent().scrub();
		Cleanser.main(args);
	}
}
