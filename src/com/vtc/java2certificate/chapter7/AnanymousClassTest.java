package com.vtc.java2certificate.chapter7;

import java.util.ArrayList;
import java.util.List;

public class AnanymousClassTest
{
	void addAnonymousClass ()
	{
		EventCreator eventCreator = new EventCreator();
		
		//Adding the Ananymous class
		eventCreator.addEventListener(
				new EventHandler()
				{
					public void doSomeThing()
					{
System.out.println("From Inside the ananymous class doSomeThing method");						
					}
				});
		eventCreator.eventFired();
	}
	
	void creatingAnonymousClassFromAWellDefinedType ()
	{
		/*
		 * Creating Ananymous class from a well defined type.
		 * Creating ananymous subclass of Rectangle class
		 */
		Rectangle rectangle = new Rectangle ()
		{
			public int calculateArea ()
			{
System.out.println("Inside the calculateArea of Ananymous class");
            	return 0;
			}
			
			/*
			 * This method cannot be called because the class it resides is ananymous class and ananymous classes cannot be addressed.
			 */
			public int getArea ()
			{
				return 0;
			}
		};
		
		rectangle.calculateArea();
	}
	
	public static void main(String[] args)
	{
//		new AnanymousClassTest ().addAnonymousClass();
		new AnanymousClassTest ().creatingAnonymousClassFromAWellDefinedType();
	}
	
	static interface EventHandler
	{
		void doSomeThing();
	}
	
	static class EventCreator 
	{
		private List<EventHandler> listeners = new ArrayList<EventHandler>();
		void eventFired ()
		{
			for (EventHandler eachEventListener : listeners)
			{
				eachEventListener.doSomeThing();
			}
		}
		
		void addEventListener (EventHandler eventListener)
		{
			listeners.add(eventListener);
		}
		
		void removeEventListener (EventHandler eventListener)
		{
			listeners.remove(eventListener);
		}		
	}
	
	static class Rectangle
	{
		private int width;
		private int length;
		
		Rectangle ()
		{
			width = 0;
			length = 0;
		}
		
		public int getWidth()
		{
			return width;
		}

		public void setWidth(int width)
		{
			this.width = width;
		}

		public int getLength()
		{
			return length;
		}

		public void setLength(int length)
		{
			this.length = length;
		}

		public int calculateArea ()
		{
System.out.println("Inside the calculateArea of original object");			
			return length * width;
		}
		
		Rectangle (int width, int length)
		{
			this.width = width;
			this.length = length;
		}
		
		public String toString()
		{
			return "Width : " + getWidth() + " , Length : " + getLength();
		}		
	}
}
