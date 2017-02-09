package com.book.tij5.concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonCreatesDaemon
{
	public static void main(String[] args)
		throws Exception
	{
		/*
		 * Daemon Threads always create daemon threads.
		 * Here isDaemon attribute is not set to true in FirstDaemon for the SecondDaemon threads tat it creates. 
		 * Even then SecondDaemon Threads are all Daemons as they are created by a Daemon Thread FirstDaemon
		 */
		Thread d = new Thread (new FirstDaemon ());
		d.setDaemon(true);
		d.start();
		
System.out.println("d.isDaemon () = " + d.isDaemon());
		TimeUnit.MILLISECONDS.sleep(100);
	}
}

class FirstDaemon implements Runnable
{
	private Thread t [] = new Thread [10];
	
	public void run ()
	{
		for (int i = 0; i < 10; i++)
		{
			t[i] = new Thread (new SecondDaemon ());
			t[i].start();
System.out.println("\nSecondDaemon : " + i + " Started");	
System.out.println("t[" + i + "].isDaemon = " + t[i].isDaemon());
		}
		
//		for (int i = 0; i < t.length; i++)
//		{
//System.out.println("t[" + i + "].isDaemon = " + t[i].isDaemon());			
//		}
		
		while (true)
		{
			Thread.yield();
		}
	}
}

class SecondDaemon implements Runnable
{
	public void run ()
	{
		while (true)
		{
			Thread.yield();
		}
	}
}