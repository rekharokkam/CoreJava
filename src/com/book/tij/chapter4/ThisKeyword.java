package com.book.tij.chapter4;

public class ThisKeyword 
{
	int counter;
	
	public ThisKeyword incementCounter()
	{
System.out.println("\nTHE COUNTER BEFORE INCREMENTING : " + (counter ++));
		return this;
	}
	
	public void printCounter ()
	{
System.out.println("THE COUNTER IN THE PRINT METHOD : " + counter);			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new ThisKeyword().incementCounter().incementCounter().printCounter();
	}
}
