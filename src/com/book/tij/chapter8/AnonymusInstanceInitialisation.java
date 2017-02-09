package com.book.tij.chapter8;

public class AnonymusInstanceInitialisation
{
	/*
	 * argument need not be final because its not used inside the anonymus class
	 * Is only being passed to the base class constructor
	 */
	Base getBase (int i)
	{
		return new Base(i)
		{
			//Cannot do this. If were to do this i(argument) has to be final
//			private int x = i;
			{
System.out.println("INSIDE THE INSTANCE INITIALISER");				
//				x = i; 
			}
			//Abstract method overriding
			public void f()
			{			
System.out.println("INSIDE THE OVERRIDDEN METHOD");				
			}
		};
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

abstract class Base
{
	private int i;
	Base(int i)
	{
		this.i = i;
	}
	
	abstract void f();
}