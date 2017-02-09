package com.fic.jdk5tutorials;

import java.util.ArrayList;
import java.util.List;

public class ForEachLoopTest
{
	private void forEachWhileLoop()
	{
		List<String> ls = new ArrayList<String>();
		ls.add("One");
		ls.add("Two");
		
		for (String string : ls)
		{
System.out.println("11111111111111");			
			boolean strRemoved = ls.remove(string);
		}
		
System.out.println("after complete removal : " + ls);		
	}
	
	public static void main(String[] args)
	{
		new ForEachLoopTest().forEachWhileLoop();
	}
}
