package com.book.tij5.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadVariations
{
	public static void main(String[] args)
	{
//		new NamedInnerClassExtendsThread ("Named Inner Class Extends Thread");
//		new AnonymousInnerThreadClass ("Anonymous Inner class with Thread implementation");
//		new NamedInnerClassImplementsRunnable ("Named Inner class with Runnable Implementation");
//		new AnonymousInnerRunnableClass ("Anonymous Inner class with Runnable Implementation");
		new MethodWithAnonymousThread ("Method with anonymous thread implmentation").runTask();
	}
}

class NamedInnerClassExtendsThread
{
	private int countDown = 5;
	private NamedInnerClass innerClass;
	
	NamedInnerClassExtendsThread (String name)
	{
		innerClass =  new NamedInnerClass (name);
	}
	
	private class NamedInnerClass extends Thread
	{
		NamedInnerClass (String name)
		{
			super (name);
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
				try
				{
					sleep (500);
				}
				catch (InterruptedException interruptedException)
				{
interruptedException.printStackTrace(System.err);					
				}
			}
		}
		
		public String toString ()
		{
			return getName() + " : " + countDown;
		}
	}
}

class AnonymousInnerThreadClass
{
	private int countDown = 5;
	private Thread t;
	
	AnonymousInnerThreadClass (String name)
	{
		t = new Thread (name)
		{
			public void run ()
			{
				while (true)
				{
System.out.println(this);
					if (--countDown == 0)
					{
						return;
					}
					try
					{
						sleep (500);
					}
					catch (InterruptedException interruptedException)
					{
interruptedException.printStackTrace(System.err);					
					}

				}
			}
			
			public String toString ()
			{
				return getName() + " : " + countDown;
			}

		};
		t.start();
	}
}

class NamedInnerClassImplementsRunnable
{
	private int countDown = 5;
	private NamedInnerClass innerClass;
	
	NamedInnerClassImplementsRunnable (String name)
	{
		innerClass = new NamedInnerClass (name);
	}
	
	private class NamedInnerClass implements Runnable
	{
		Thread t;
		
		NamedInnerClass (String name)
		{
			t = new Thread (this, name);
			t.start();
		}

		public String toString ()
		{
			return t.getName() + " : " + countDown;
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
				try
				{
					TimeUnit.MILLISECONDS.sleep(500);
				}
				catch (InterruptedException interruptedException)
				{
interruptedException.printStackTrace(System.err);					
				}

			}
			
		}
	}
}

class AnonymousInnerRunnableClass
{
	private int countDown = 5;
	private Thread t;
	
	AnonymousInnerRunnableClass (String name)
	{
		t = new Thread (new Runnable ()
			{
				public String toString ()
				{
					return Thread.currentThread().getName() + " : " + countDown;
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
						try
						{
							TimeUnit.MILLISECONDS.sleep(500);
						}
						catch (InterruptedException interruptedException)
						{
interruptedException.printStackTrace(System.err);					
						}
					}
				}
			}
		, name);
		t.start();
	}	
}

class MethodWithAnonymousThread
{
	private int countDown = 5;
	private Thread t;
	private String name;
	
	MethodWithAnonymousThread (String name)
	{
		this.name = name;
	}
	
	void runTask ()
	{
		t = new Thread (name)
		{
			public String toString ()
			{
				return getName() + " : " + countDown;
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
					try
					{
						TimeUnit.MILLISECONDS.sleep(500);
					}
					catch (InterruptedException interruptedException)
					{
interruptedException.printStackTrace(System.err);					
					}
				}
				
			}
		};
		t.start();
	}
}