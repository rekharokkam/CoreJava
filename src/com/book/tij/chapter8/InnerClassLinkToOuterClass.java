package com.book.tij.chapter8;

public class InnerClassLinkToOuterClass
{
	public static void main(String[] args)
	{
		Sequence sequence = new Sequence (10);
		for (int i = 0; i < 10; i++)
		{
			sequence.add(new Integer(i));
		}
		
		Selector selector = sequence.getSelector();
		while (!selector.end())
		{
System.out.println("EACH OBJECT : " + selector.current());
			selector.next();
		}
	}
}

class Sequence
{
	private Object[] objects;
	private int index = 0;
	
	Sequence (int objectArraySize)
	{
		objects = new Object[objectArraySize];
	}
	void add (Object object)
	{
		if (index < objects.length)
		{
			objects[index ++] = object;
			return;
		}
		
		throw new ArrayIndexOutOfBoundsException(
				"YOUR ARRAY IS FULL. PLEASE DONT ADD ANY MORE OBJECTS");
	}
	
	Selector getSelector ()
	{
		//Either of the ways can be used
		return new SelectorImlp();
//		return new Selector()
//		{
//			private int arrayIndex = 0;
//			public boolean end()
//			{
//				return (arrayIndex == objects.length) ? true : false;
//			}
//			
//			public Object current()
//			{
//				return objects[arrayIndex];
//			}
//			
//			public void next()
//			{
//				if (arrayIndex < objects.length)
//				{
//					arrayIndex ++;
//				}
//			}
//		};
	}
	
	/*
	 * An inner class can access the Outer class variables including the private ones
	 * An inner class implicitly keeps a reference to the enclosing Class tat created it
	 * This helps the inner class in accessing all the variables of the outer class
	 */
	private class SelectorImlp implements Selector
	{
		private int arrayIndex = 0;
		public boolean end()
		{
			return (arrayIndex == objects.length) ? true : false;
		}
		
		public Object current()
		{
			return objects[arrayIndex];
		}
		
		public void next()
		{
			if (arrayIndex < objects.length)
			{
				arrayIndex ++;
			}
		}
	}
}

interface Selector
{
	boolean end ();
	Object current();
	void next();
}
