package com.book.tij5.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadExceptionWithoutCatchBlock 
{
	public static void main(String[] args)
	{
		/*
		 * Exceptions tat get out of task's run() method cannot be caught. They propagate straight to console.
		 * Having try-catch block in the main (method where the task is started) does not help.
		 */
//		try
//		{
//			ExecutorService exec = Executors.newCachedThreadPool();
//			exec.execute(
//				new Runnable ()
//				{
//					public void run ()
//					{
//						throw new RuntimeException ("Thrown from run() by ME");
//					}
//				}
//			);
//		}
//		catch (Exception exception)
//		{
//exception.printStackTrace(System.err);			
//		}
		
		
		
		
//		ExecutorService exec = Executors.newCachedThreadPool(new UncaughtExceptionHandlerThreadFactory ());
//		exec.execute(
//			new Runnable ()
//			{
//				public void run ()
//				{
//System.out.println("Thread tat is about to throw exception : " + Thread.currentThread().getName());					
//System.out.println("The uncaught exception handler for this thread is : " + Thread.currentThread().getUncaughtExceptionHandler().getClass().getName());
//					throw new RuntimeException ("Thrown from run() by ME");
//				}
//			}
//		);
		
		
		/*
		 * If we know tat we would be using the same exception handler every where then we can set setDefaultUncaughtExceptionHandler to a exception handler class.
		 * This handler gets called only when there is no per thread uncaught exception handler.
		 * The system checks for a per-thread uncaught exception handler and if it doesnt find one it checks to see if the thread group specializes its uncaughtException(() method. 
		 * If not it calls the defaultUncaughtExceptionHandler.
		 */
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler ());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(
			new Runnable ()
			{
				public void run ()
				{
					throw new RuntimeException ("Thrown from run() by ME");
				}
			}
		);		
	}
}

/*
 * Thread.UncaughtExceptionHandler - this interface helps to attach an exception handler to thread object
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
	/*
	 * This method gets called automatically when any thread (to which Thread.UncaughtExceptionHandler is attached) is about to die from an uncaught exception.
	 */
	public void uncaughtException (Thread t, Throwable e)
	{
System.out.println("Inside my uncaughtException method. Thread tat threw Exception : " + t.getName() );
e.printStackTrace(System.err);
	}
}

/*
 * Attach a Thread.UncaughtExceptionHandler to each new thread created from the factory.
 */
class UncaughtExceptionHandlerThreadFactory implements ThreadFactory
{
	public Thread newThread (Runnable r)
	{
		Thread t = new Thread (r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler ());
		return t;
	}
}