/**
 * From the Third chapter of IBM Threads tutorials
 */


package com.itreya.threadTutorial;

public class Scheduling
{
	
	public int test ()
	{
		return 10;
	}
	
	public static void main (String args[])
	{
		int someNum = new Scheduling ().test();
		System.out.println (someNum);
			
	}
}
