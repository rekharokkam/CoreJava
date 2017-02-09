package com.book.tij5.concurrency;

public class BasicThread extends Thread
{
	private int countDown = 5;
	private static int threadCount = 0;
	
	public BasicThread ()
	{
		super (Integer.toString(++threadCount));
		start ();
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
	
	public String toString ()
	{
		return "#" + getName() + "(" + countDown + ")";
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			new BasicThread ();
		}				
	}
}
