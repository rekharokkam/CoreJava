package com.book.tij5.concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonThread
{
	public static void main(String[] args)
		throws Exception
	{
		for (int i = 0; i < 10; i++)
		{
			Thread daemon = new Thread (new SimpleDaemon ());
			//Call this method before calling start method. Marking a thread as daemon makes the thread daemon thread.
			daemon.setDaemon(true);
			daemon.start();
		}
		
System.out.println("All Daemons started");
		TimeUnit.MILLISECONDS.sleep(400);
	}
}

/*
 * A daemon thread is intended to provide a general service in the background as long as the program is running.
 * But it is not part of the essence of the program.
 * When all the non-daemon threads complete program is terminated, thus killing all the daemon threads in the process.
 * Conversely, if there are any non-daemon threads running, the program doesnt terminate.
 */
class SimpleDaemon implements Runnable
{
	public void run ()
	{
		while (true)
		{
			try
			{
				TimeUnit.MILLISECONDS.sleep(100);
System.out.println(Thread.currentThread() + "  :: " + this);				
			}
			catch (InterruptedException interruptedException)
			{
interruptedException.printStackTrace(System.err);				
			}			
		}
	}
}

