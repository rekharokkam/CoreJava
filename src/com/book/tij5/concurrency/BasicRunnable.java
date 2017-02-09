package com.book.tij5.concurrency;

public class BasicRunnable
{
	public static void main(String[] args)
	{
//		LiftOff lightOff = new LiftOff ();
//		lightOff.run();
		
//		OR
		
System.out.println("Before starting the thread");		
		new Thread (new LiftOff ()).start();
System.out.println("waiting for light off");		
	}
}

class LiftOff implements Runnable
{
	protected int countDown = 10;
	
	private static int taskCount = 0;
	private final int id = taskCount++; 
	
	LiftOff () {}
	
	LiftOff (int countDown)
	{
		this.countDown = countDown;
	}
	
	String status ()
	{
		return "#" + id + "(" +
			(countDown > 0 ? countDown : "LightOff") + "),    ";
	}
	
	public void run ()
	{
		while (countDown-- > 0)
		{
System.out.println(status ());

			/*
			 * Calling of this method here is a suggestion to the thread scheduler (part of the java threading mechanism tat moves the CPU from one thread to next),
			 * tat says , "I've done the important parts of my cycle and this would be a good time to switch to another task of the same priority for a while".
			 */
			Thread.yield();
		}
	}
}