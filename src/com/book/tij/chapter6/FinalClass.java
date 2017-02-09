package com.book.tij.chapter6;

import java.util.Hashtable;
import java.util.Vector;

/*
 * All the methods are by default final for a final class as it cannot be sub classed and hence no method can be overridden
 */
public final class FinalClass 
{
	void print ()
	{
System.out.println("INSIDE THE PRINT METHOD");		
	}
	
	public static void main(String[] args) 
	{
		Hashtable hasTable = new Hashtable ();
		Vector vector = new Vector();
	}
}
