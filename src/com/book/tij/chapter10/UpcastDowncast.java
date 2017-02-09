package com.book.tij.chapter10;

public class UpcastDowncast
{
	public static void main(String[] args)
	{
		//This is an UPCAST. Subclass is being casted to the parent class
		Shape triangle = new Triangle ();
		
		//This is DOWNCAST. Parent class is being cast to subclass.		
		Triangle shape = (Triangle)new Shape ();
		
		/*
		 * An explicit Downcast is required because
		 * A Triangle (Subclass) is a Shape so compiler freely allows it without explicit Upcast.
		 * But a Shape not necessarily be a Circle always so compiler doesnt allow this by default and an explicit cast is required.
		 * So the below line of code is not allowed.
		 */
//		Triangle tri = new Shape ();
		
	}
}

