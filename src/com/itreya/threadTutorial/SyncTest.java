/**
 * This represents an example from fifth chapter of Threads tutorials
 */

package com.itreya.threadTutorial;

import java.util.Date;

public class SyncTest
{
	public static class Thingie
	{
		private Date date;
		
		public synchronized void setLasAccess (Date date)
		{
			this.date = date;
			for (int i = 0; i < 10000; i ++)
			{
				System.out.println (Thread.currentThread().getName() + "         " + i);
			}
			
		}
	}
	
	public static class MyThread extends Thread
	{
		private Thingie thingie;
			
		public MyThread (Thingie a_thingie)
		{
			this.thingie = a_thingie;
		}
			
		public void run ()
		{
			thingie.setLasAccess(new Date());
		}
		
	}
	
	public static void main (String args[])
	{
		Thingie thingie1 = new Thingie();
		Thingie thingie2 = new Thingie();
		
		new MyThread (thingie1).start();
		new MyThread (thingie2).start();
	}
}
