/**This class is for Java1.4 specifically
 * This checks the new featiure --> new class RandomAccessFile
 * http://developer.java.sun.com/developer/JDCTechTips/2002/tt0709.html#tip2
 */

package com.itreya.test;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.Iterator;


public class ListTest
{
	private static final int NUMBER = 2000;
	
	static void buildList (List list)  
	{
		for (int i = NUMBER; --i >= 0;)
		{
			list.add(new Integer (i));
		}
	}
	
	static long sumList (List list)
	{
		long sum = 0;
		for (int i = (list.size()-1) ; --i >= 0;)
		{
			Integer eachElement = (Integer) list.get(i);
			sum += eachElement.intValue ();	
		}
		
		return sum;
	}
	
	static long newSumList (List list)
	{
		long result = 0;
		
		if (list instanceof RandomAccess)
		{
			for (int i = list.size (); --i >= 0;)
			{
				Integer eachValue = (Integer)list.get (i);
				result += eachValue.intValue ();
			}
		}
		
		else
		{
			Iterator it = list.iterator();
			while (it.hasNext() )
			{
				Integer eachValue = (Integer)it.next();
				result += eachValue.intValue (); 
			}
		}
		
		return result;
	}
	

	public static void main(String[] args)
	{
		List arrayList = new ArrayList ();
		buildList (arrayList);
		long startArrayList = System.currentTimeMillis();
		long sumArrayList = newSumList (arrayList);
		System.out.println ("The TIme taken for ArrayList is  " + (System.currentTimeMillis() - startArrayList));
		
		List linkedList = new LinkedList ();
		buildList (linkedList);
		long startLinkedList = System.currentTimeMillis();
		long sumLInkedList = newSumList (linkedList);
		System.out.println ("The TIme taken for LinkedList is  " + (System.currentTimeMillis() - startLinkedList));
		
		
		
	}
}
