package com.vtc.java2certificate.chapter6;

import java.util.ArrayList;
import java.util.List;

public class AssertTest
{
	private static void plainAssert ()
	{
		int x = 10;
		assert (x > 20);
	}
	
	private static void assertWithMessage ()
	{
		int x = 10;
		assert (x > 20) : "X cannot be greater than 10" ;
	}
	
	private void assertNeverReached()
	{
		for (int i = 0; i < 3; i ++)
		{
			if (i == 1)
			{
				return;
			}
		}
		
		assert (false) : "Will Never reach here";
	}
	
	private static void useAssertOnList ()
	{
		List<String> names = new ArrayList<String>();
System.out.println(names.isEmpty());		
		assert (!names.isEmpty()) : "This Should never happen";
		
		names.add(null);
		assert (names.isEmpty()) : "List is already populated. How can it be null.";//This line is not executed even if null is added to list
	}
	
	public static void main(String[] args)
	{
//		plainAssert();
//		assertWithMessage ();
		useAssertOnList ();
	}
}
