package com.itreya.test2;

import java.util.ArrayList;
import java.util.List;

public class Test 
{
	public static void main(String[] args)		
	{
		List<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		
		for (int x : a)
		{
			int y = x;
System.out.println(y);			
		}
	}
}
