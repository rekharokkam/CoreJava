package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriorityTask implements Runnable
{
	private int priority;
	private int countDown = 5;
	private volatile double d;
	
	public PriorityTask (int priority)
	{
		this.priority = priority;
	}
	
	public void run ()
	{
		/*
		 * setting the priority of a thread conveys the importance of a thread to the scheduler.
		 * Setting priority to threads is one of the ways to resolve deadlocks
		 * Thread with higher priority gets the preference of running before the thread with lesser priority.
		 */
		Thread.currentThread().setPriority(priority);
		while (true)
		{
			for (int i = 0; i < 100000; i++)
			{
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
				{
					Thread.yield();
				}
			}
			
System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public String toString ()
	{
		/*
		 * Thread.currentThread returns the refernce to the Thread Object tat is driving the current task.
		 */
		return Thread.currentThread() + " : " + countDown;
	}
	
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
		{
			exec.execute(new PriorityTask (Thread.MIN_PRIORITY));
		}
		exec.execute(new PriorityTask (Thread.MAX_PRIORITY));
		
		exec.shutdown();
	}

}
