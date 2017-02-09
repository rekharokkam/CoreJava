package com.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class SynchronizationTest
{
	private static SynchronizationTest selfInstance ;
	private static final String lock = new String();
	private static int i = 10;
	
	private SynchronizationTest(){}
	
	public static SynchronizationTest getInstance ()
	{
		if (null == selfInstance)
		{
System.out.println("Self Instance is found Null by the thread : " + Thread.currentThread().getName());			
			synchronized (lock)
			{
System.out.println("Inside the synchronized block . Lock is held by the thread : " + Thread.currentThread().getName());				
				selfInstance = new SynchronizationTest();
			}
		}
		return selfInstance;
	}
	
	public void printText (String text)
	{
		i = 100;
System.out.println("Printing Text : " + text);		
	}
	
	public static void main(String[] args)
	{
//		MyThread1 thread1 = new MyThread1("Thread 1");
//		MyThread1 thread2 = new MyThread1("Thread 2");
//
////		SynchronizationTest test = SynchronizationTest.getInstance();
////		test.printText("This is from Main method");
//		thread1.start();
//		thread2.start();
//		
//		Thread.dumpStack();
		
//System.out.println(8 % 10);
		
//		Set<String> mySet = new HashSet<String>(2);
//		mySet.add("a");
//		mySet.add("b");
//		mySet.add("c");
//		
//System.out.println(mySet);		

		
//		Map<First, First> myMap = new HashMap<First, First>();
//		myMap.put(new Third (), new Third());
		
		String s1 = new String("a");
		String s2 = new String("a");
System.out.println(s1 == s2);		
		
	}
}


class First
{
	
}

class Second extends First
{
	
}

class Third extends Second
{
	
}

class MyThread1 extends Thread
{
	MyThread1 (String threadName)
	{
		super (threadName);
System.out.println("Creating Thread : " + threadName);		
	}
	
	public void run ()
	{
System.out.println("executing run() of Thread : " + getName());
		SynchronizationTest instance = SynchronizationTest.getInstance ();
		instance.printText (getName());
	}
}