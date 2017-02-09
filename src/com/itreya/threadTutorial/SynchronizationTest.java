/**
 * This is from fifth chapter of IBM Tutorials of Threads
 */

package com.itreya.threadTutorial;

public class SynchronizationTest
{
	private static Object lockObject = new Object();
	private static int x, y;
	
	private static class Thread1 extends Thread
	{
		public void run ()
		{
			synchronized (lockObject)
			{
				x = y = 0;
				System.out.println ("THIS IS FIRST THREADS X VALUE = " + x);
			}
			
			System.out.println ("AFTER THE SYNCHRONIZED BLOCK OF 1 THREAD");
		}
	}
	
	private static class Thread2 extends Thread
	{
		public void run ()
		{
			synchronized (lockObject)
			{
				x = y = 1;
				System.out.println ("THIS IS THE SECOND THREAD Y VALUE = " + y);
			}
			System.out.println ("AFTER THE SYNCHRONIZED BLOCK OF 2 THREAD");
		}
	}
	
	public static void main (String args[])
	{
		new Thread1().start();
		new Thread2 ().start();
	}
}
