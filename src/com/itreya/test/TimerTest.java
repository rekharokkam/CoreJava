package com.itreya.test;

import java.util.Timer;
import java.util.TimerTask;

import java.util.Calendar;
import java.util.Date;

public class TimerTest
{
	
	private Timer timer;		
	
	public TimerTest()
	{
		timer = new Timer ();		
		
		/* This is for the method which takes two parameters
		 * 1. TimerTask 
		 * 2. Delay in seconds
		 * In this case the task is performed only once so an explicit exit is needed
		 */
		
		//timer.schedule(new MyTimerTaks (), 5000);
		
		
		/*
		 * The Task is performed repeatedly  but there is no exit.
		 * An explicit exit must be mentioned
		 * 
		 */
		 
		 //timer.schedule(new MyTimerTaks (), 1000, 5000);
		 
		 /*
		  * The task is performed once on a given date
		  */
		  
		  
		//	Calendar calendar =  Calendar.getInstance();
		//	calendar.set(Calendar.HOUR_OF_DAY, 19);
		//	calendar.set(Calendar.MINUTE, 11);
		//	calendar.set(Calendar.SECOND, 25);	
			
		//	Date scheduledTime = calendar.getTime();
			//timer.schedule(new MyTimerTaks(), scheduledTime);
			
		
		/*
		 * This task is performed repeatedly starting at a fixed time with a given interval of time
		 */
		 
//			Calendar calendar =  Calendar.getInstance();
//			calendar.set(Calendar.HOUR_OF_DAY, 19);
//			calendar.set(Calendar.MINUTE, 15);
//			calendar.set(Calendar.SECOND, 25);	
//			
//			Date scheduledTime = calendar.getTime();
//			timer.schedule(new MyTimerTaks(), scheduledTime, 2000);	


			/*
			 * This schedules the task at fixed time
			 */
			 
			 timer.scheduleAtFixedRate(new MyTimerTaks (), 2000, 5000);

		
	}


	private class MyTimerTaks extends TimerTask
	{
		private int iCounter;//for running each scheduled task for a particular number of times and terminating
		
		public MyTimerTaks()
		{
			iCounter = 0;
		}
		 
		public void run ()
		{
			iCounter ++;
			System.out.println ("Inside the run method of the timertask  ===  " + iCounter + "  time in secs is -->  " + new Date().getSeconds());
			
			if (iCounter == 2)
			{
				int iStart = new Date().getSeconds();
				for (int i = 1000; --i >= 0;)
				{
					System.out.println ("\n" + i);
				}
				
				int iStop = new Date().getSeconds();
				
				System.out.println ("\nThe delay is " + (iStop - iStart));
			}
			
			if (iCounter == 5)
			{
				timer.cancel ();
				//System.exit(0);
			}
			
		}		
		
		
	}

	public static void main(String[] args)
	{
		System.out.println ("\nThis is before scheduling the task");
		TimerTest test = new TimerTest ();
		System.out.println ("\nThis is after the scheduling");
				
	}
}
