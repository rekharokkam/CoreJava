package com.book.tij5.concurrency;

public class JoiningThreads
{
	public static void main(String[] args)
	{
		ToBeJoinedThread 
			sleepy = new ToBeJoinedThread ("Sleepy", 1000),
			grumpy = new ToBeJoinedThread ("Grumpy", 3000);
		
		Joinee 
			dopey = new Joinee ("Dopey", sleepy),
			doc = new Joinee ("Doc", grumpy);
		
		grumpy.interrupt();
	}
}

class ToBeJoinedThread extends Thread
{
	private long sleepDuration;
	
	ToBeJoinedThread (String name, long sleepDuration)
	{
		super (name);
		this.sleepDuration = sleepDuration;
		
		start ();
	}
	
	public void run ()
	{
		try
		{
			sleep (sleepDuration);
		}
		catch (InterruptedException interruptedException)
		{
			/*
			 * When another thread calls interrupt() on this thread a flag is set to indicate tat this thread is interrupted.
			 * this flag gets cleared when the exception is caught. So the result will always be false inside the catch block. 
			 */
System.err.println(getName() + " Thread was Interrupted during its sleep" + " :: isInterrupted() = " + isInterrupted());
			return;
		}
System.out.println(getName () + " Thread has awakened");		
	}
}

class Joinee extends Thread
{
	private ToBeJoinedThread toBeJoinedThread;
	
	Joinee (String name, ToBeJoinedThread toBeJoinedThread)
	{
		super (name);
		this.toBeJoinedThread = toBeJoinedThread;
		
		start ();
	}
	
	public void run ()
	{
		try
		{
			/*
			 * When the method join() is called by a thread on a target thread then the first thread waits till the target thread completes its processings.
			 * Here Joinee (this) is the first thread which calls join on target thread (toBeJoinedThread). So Joinee is suspended until the target thread (toBeJoinedThread) has completed.
			 */
			toBeJoinedThread.join();
		}
		catch (InterruptedException interruptedException)
		{
interruptedException.printStackTrace(System.err);			
		}		
System.out.println(getName () + " Join completed Successfully");		
	}
}
