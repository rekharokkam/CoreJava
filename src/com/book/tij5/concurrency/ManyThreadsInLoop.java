package com.book.tij5.concurrency;

public class ManyThreadsInLoop
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			new Thread (new LiftOff ()).start();			
		}
System.out.println("Waiting for Lights Off");		
	}
}
