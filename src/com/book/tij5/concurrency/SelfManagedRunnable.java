package com.book.tij5.concurrency;

/*
 * Implementing an interface allows the object to inherit from another object.
 */
public class SelfManagedRunnable implements Runnable
{
	private Thread t = new Thread (this);
	private int countDown = 5;
	
	public SelfManagedRunnable ()
	{
		/*
		 * not a good idea to call start inside of a constructor
		 */
		t.start();
	}
	
	public String toString ()
	{
		return Thread.currentThread().getName() + "(" + countDown + ")";
	}
	
	public void run ()
	{
		while (true)
		{
System.out.println(this);
			if (--countDown == 0)
			{
				return;
			}
		}
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			new SelfManagedRunnable();
		}
	}
}
