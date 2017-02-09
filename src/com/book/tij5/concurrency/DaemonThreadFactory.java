package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/*
 * This factory returns only daemon threads.
 * Custom ThreadFactory can be written by implementing ThreadFactory to generate threads with custom set attributes like daemon, priority, name
 */
public class DaemonThreadFactory implements ThreadFactory
{
	public Thread newThread (Runnable r)
	{
		Thread t = new Thread (r);
		t.setDaemon(true);
		return t;
	}

	public static void main(String[] args)
		throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory ());
		for (int i = 0; i < 10; i++)
		{
			exec.execute(new SimpleDaemon ());
		}
System.out.println("All Daemons started"); 	
		TimeUnit.MILLISECONDS.sleep(400);
	}
}

