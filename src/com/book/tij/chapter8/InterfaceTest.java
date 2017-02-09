package com.book.tij.chapter8;

public class InterfaceTest 
{
}

interface Instrument
{
	/*
	 * All fields (attributes) of an interface are
	 * PUBLIC 
	 * StatIC 
	 * FINAL 
	 * by default - Compile time constants 
	 * 
	 */ 
	int I = 5;
	
	//All methods of an interface are PUBLIC by default
	void play(String note);
	void what();
	void adjust();
}

class Wind implements Instrument
{
	static 
	{
		/*
		 * Cannot be modified as it is a final variable
		 */
//		I = 10;
	}
	public void play(String note)
	{
		/*
		 * Cannot be modified because 
		 * Field is static and can be modified only in any static method
		 * Field is final by default
		 */
//		this.I = 20;
//		super.I = 20;
	}
	
	public void what()
	{
		
	}
	
	/*
	 * Cannot have any access specifier other than public for overridden methods.
	 * Cannot reduce the access visibility by specifying lesser access specifier. 
	 * Since all the methods of an interface are public by default all overriding methods have to be PUBLIC 
	 */
//	void adjust(){} 
//	protected void adjust(){}
	
	public void adjust(){}
}
