package com.gapinc;

public class Test
{
	private static final String X = "1";
	public static void main(String[] args)
	{
		String a = "1";
		String b = new String("1").intern();
		String c = b.intern();
		
System.out.println(a == b);		
	}
}
