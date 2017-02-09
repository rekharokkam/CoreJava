package com.itreya.threadTutorial;

public class DaemonThreadTest
{
	public static void main (String args[])
	{
		System.out.println ("Inside the main method");
		new DaemonThread().start();
	}
}

class DaemonThread extends Thread
{
	public void run ()
	{
		for (int i = 0; i < 10000; i ++)
		{
			if (i == 100)
			{
				throw new RuntimeException("HEHE done");
			}
			System.out.println ("Each Item = " + i);
		}	
	}
}