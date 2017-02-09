package com.book.tij.chapter4;

public class PrimitiveInitialValues 
{
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;

	private void printInitialValues ()
	{
		if (c == (char)0)
		{
System.out.println("char value is null");			
		}
		
System.out.println("char : " + (char)c);		
System.out.println("byte : " + b);
System.out.println("short : " + s);
System.out.println("int : " + i);
System.out.println("long : " + l);
System.out.println("float : " + f);
System.out.println("double : " + d);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new PrimitiveInitialValues().printInitialValues();
	}
}
