package com.book.tij.chapter4;

public class ConstructorOverloading 
{
	int intValue = 0;
	String str = "";
	
	public ConstructorOverloading(int intValue)
	{
System.out.println("INSIDE AN INT ARG CONSTRUCTOR");		
		this.intValue = intValue;
	}
	
	public ConstructorOverloading (String s)
	{
System.out.println("INSIDE THE STRING ARG CONSTRCUTOR");
		this.str = s;
	}
	
	public ConstructorOverloading(int i, String s)
	{
		this(i);
		//this(s);//Illegal cant call more than 1 constructor
		this.str = s;
System.out.println("INSIDE THE INT AND STRING ARG CONSTRUCTOR");		
	}
	
	public ConstructorOverloading ()
	{
		this (47, "String");
System.out.println("DEFAULT / NO-ARG CONSTRUCTOR");		
	}	
	
	public void testConstructorCalling()
	{
		//this (47);//Always refers to the constructor.Not inside of a non constructor
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new ConstructorOverloading();
	}
}
