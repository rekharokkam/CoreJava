package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor
{
	public static void main(String[] args)
	{
		/*
		 * With fixed thread pool, expensive thread allocation happens once upfront thus limiting the number of threads
		 * This saves time because you aren't constantly paying for thread creation overhead for every single task.		 
		 */
		ExecutorService exec = Executors.newFixedThreadPool(5);
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
