package com.book.tij5.concurrency;

public class ResponsiveUI extends Thread
{
	private static volatile double d = 1;
	
	ResponsiveUI ()
		throws Exception
	{
		setDaemon(true);
		start ();		
	}
	
	public void run ()
	{
		while (true)
		{
			d += ( Math.PI + Math.E) / d;
		}
	}
	public static void main(String[] args)
		throws Exception
	{
//		new UnResponsiveUI ();
		
		new ResponsiveUI ();
		System.in.read();
System.out.println(d);		
	}
}

class UnResponsiveUI
{
	private volatile double d = 1;
	
	UnResponsiveUI ()
		throws Exception
	{
		while (d > 0)
		{
			d += ( (Math.PI + Math.E) / d);
System.out.println(d);			
		}
		
		System.in.read();
	}
}

