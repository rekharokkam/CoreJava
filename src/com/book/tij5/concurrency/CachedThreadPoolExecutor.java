package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor
{
	public static void main(String[] args)
	{
		/*
		 * Executors manage Thread objects for the programmers.
		 * Executors provide a layer of indirection b/w the calling client and the execution of task.
		 * Instead of client executing the task directly an intermeidate object executes the task.
		 * 
		 */
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++)
		{
			/*
			 * In any of the thread pools existing threads are automatically reused when possible
			 */
			exec.execute(new LiftOff ());
		}
System.out.println("Before the executor shutdown");

		//Call to shutdown prevents new tasks from being submitted to tat executor
		exec.shutdown();
System.out.println("After the executor shutdown");		
	}
}
