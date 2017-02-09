package com.book.tij5.concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonNotExecutingFinallyBlock
{
	public static void main(String[] args)
	{
		Thread t = new Thread (new ADaemon ());
		/*
		 * When this attribute is set to true finally clause does not get executed.
		 * Daemons are terminated abruptly when the last of the non-daemon terminates.
		 * So as soon as main() exits, JVM shuts down all the daemons immediately, without any of the formalities.
		 * 
		 * Daemon Thread are not a good idea.
		 */
		t.setDaemon(true);
		t.start();
	}
}

class ADaemon implements Runnable
{
	public void run ()
	{
		try
		{
System.out.println("Inside the run method of ADaemon");
			TimeUnit.MILLISECONDS.sleep(100);
		}
		catch (InterruptedException interruptedException)
		{
interruptedException.printStackTrace(System.err);			
		}
		finally
		{
System.out.println("Inisde the finally block of ADaemon. This should ideally run always");			
		}
	}
}