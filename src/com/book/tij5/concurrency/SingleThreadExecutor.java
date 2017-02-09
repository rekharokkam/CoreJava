package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor
{
	public static void main(String[] args)
	{
		/*
		 * SingleThreadExecutor ensures tat no two tasks are called concurrently.
		 * This is useful when some thing needs to be run in a seperate thread continually - task listening to incoming socket connections.
		 * If more than 1 task is submitted to a singlethreadexecutor, the tasks are queued and each task will run to completion before the next task is begun, all using the same thread.
		 * By serializing tasks (as in case of single thread executor) the need to synchronize is eliminated.
		 */
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
		{
			exec.execute(new LiftOff ());
		}
System.out.println("Before executor shutdown");		
		exec.shutdown();
System.out.println("After executor shutdown");		
	}
}
