package com.book.tij.chapter6;

public class PlaceSetting extends Custom
{
	public PlaceSetting(int i)
	{	
		super (i);
System.out.println("INSIDE THE CONSTRUCTOR OF PLACESETTING WITH PARAMETER");
	}
	
	public PlaceSetting()//in every constructor a call is made to the super constructor 
	{		
		super (10);
System.out.println("INSIDE THE CONSTRUCTOR WITH NO ARG");		
	}

	public PlaceSetting(String a)
	{
		super (10);
System.out.println("INSIDE THE CONSTRUCTOR WITH STRING ARGUMENT OF PLACESETTING CLASS");
	}
	
	public static void main(String[] args) 
	{
		new PlaceSetting(10);
	}
}

class Custom
{
//	public Custom()
//	{
//System.out.println("INSIDE THE CONSTRUCTOR OF DEFAULT CONSTRUCTOR OF CUSTOM CLASS");		
//	}
	
	public Custom (int i)
	{
System.out.println("INSIDE THE CONSTRUCTOR OF CUSTOM CLASS WITH ARGUMENT");		
	}
}
