package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff
{
	public void run ()
	{
		while (countDown-- > 0)
		{
System.out.println(status ());
			try
			{
				//Java 5 onwards style of sleeping
				/*
				 * Sleep method blocks (ceases) the execution of the task for a given period of time.
				 */
				TimeUnit.MILLISECONDS.sleep(100);
			}
			/*
			 * Exceptions do not propogate across threads. 
			 * So each thread must handle exceptions locally tat arise during the execution of task.
			 */
			catch (InterruptedException interruptedException)
			{
interruptedException.printStackTrace(System.err);				
			}
		}
	}
	
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
		{
			exec.execute(new SleepingTask ());
		}
		exec.shutdown();
	}
}
