/**
 * This is an example from IBM Thread Tutorial 2nd chapter
 */


package com.itreya.threadTutorial;

import java.util.Timer;
import java.util.TimerTask;

public class Calculator
{
	public static void main (String args[])
	{
		final Calci calci = new Calci();
		calci.start();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
						{
							public void run ()
							{
								calci.isComplete = true;
							}
						}, Calci.SECONDS);
		
		/*
		try
		{
			Thread.sleep(Calci.SECONDS);
		}
		catch (InterruptedException e)	
		{
			//do nothing
		}
		System.out.println ("INSIDE THE MAIN THREAD");
		calci.isComplete = true;
		System.out.println ("AFTER THE SETTING");
		*/
	}
}


class Calci extends Thread
{
	
	public static int MAX_NUMBER = 100000;
	public static int SECONDS = 10000;
	public boolean isComplete = false;
	
	public void run ()
	{
		
		System.out.println ("INSIDE THE RUN METHOD");
		
		int allPrimes[] = new int[MAX_NUMBER];
		int count = 0;
		
		for(int i = 2; i < MAX_NUMBER; i ++)
		{
			if (isComplete)
			{
				break;
			}
			
			boolean isPrime = true;
			
			for(int j = 0; j < count; j ++)	
			{
				if ((i%allPrimes[j]) == 0)
				{
					isPrime = false;
					break;
				}
			}
			
			if (isPrime)
			{
				allPrimes[count++] = i;
				System.out.println ("EACH MEMBER = " + i);
			}
		}	
		
		System.out.println ("AT THE END ");
		
	}
}
