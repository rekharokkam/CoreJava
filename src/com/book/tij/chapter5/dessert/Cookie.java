package com.book.tij.chapter5.dessert;

public class Cookie 
{
	public Cookie()
	{
System.out.println("INSIDE THE COOKIE DEFAULT CONSTRUCTOR");		
	}
	
	public Cookie(String cookieName)
	{
System.out.println("INSIDE THE STRING ARG CONSTRUCTOR OF COOKIE CLASS : " + cookieName);		
	}
	
	void bite()
	{
System.out.println("inside the bite method of cookie class");		
	}
}
