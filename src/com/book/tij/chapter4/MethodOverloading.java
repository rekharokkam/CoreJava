package com.book.tij.chapter4;

public class MethodOverloading 
{
	//Reversing of argument lists forms 2 overloaded methods
	private void testOverLoad1 (String s, int i)
	{
System.out.println("STRING FIRST, INT NEXT");		
	}	
	private void testOverLoad2 (int i, String s)
	{
System.out.println("INT FIRST, STRING NEXT");		
	}
	
	//Todemostrate overloading
	private void function1 (char x)
	{
System.out.println("INSIDE THE CHAR FUNCTION 11111111111");		
	}
	private void function1 (byte x)
	{
System.out.println("INSIDE THE BYTE FUNCTION 11111111111");		
	}
	private void function1 (short x)
	{
System.out.println("INSIDE THE SHORT FUNCTION 11111111111");		
	}
	private void function1 (int x)
	{
System.out.println("INSIDE THE INT FUNCTION 11111111111");		
	}
	private void function1 (long x)
	{
System.out.println("INSIDE THE LONG FUNCTION 11111111111");		
	}
	private void function1 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 11111111111");		
	}
	private void function1 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 11111111111");		
	}
	
	private void function2 (byte x)
	{
System.out.println("INSIDE THE BYTE FUNCTION 2222222222222");		
	}
	private void function2 (short x)
	{
System.out.println("INSIDE THE SHORT FUNCTION 2222222222222");		
	}
	private void function2 (int x)
	{
System.out.println("INSIDE THE INT FUNCTION 2222222222222");		
	}
	private void function2 (long x)
	{
System.out.println("INSIDE THE LONG FUNCTION 2222222222222");		
	}
	private void function2 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 2222222222222");		
	}
	private void function2 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 2222222222222");		
	}

	private void function3 (short x)
	{
System.out.println("INSIDE THE SHORT FUNCTION 3333333333333");		
	}
	private void function3 (int x)
	{
System.out.println("INSIDE THE INT FUNCTION 3333333333333");		
	}
	private void function3 (long x)
	{
System.out.println("INSIDE THE LONG FUNCTION 3333333333333");		
	}
	private void function3 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 3333333333333");		
	}
	private void function3 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 3333333333333");		
	}
	
	private void function4 (byte x)
	{
System.out.println("INSIDE THE BYTE FUNCTION 4444444444444");		
	}
	private void function4 (int x)
	{
System.out.println("INSIDE THE INT FUNCTION 4444444444444");		
	}
	private void function4 (long x)
	{
System.out.println("INSIDE THE LONG FUNCTION 4444444444444");		
	}
	private void function4 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 4444444444444");		
	}
	private void function4 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 4444444444444");		
	}

	private void function5 (long x)
	{
System.out.println("INSIDE THE LONG FUNCTION 555555555555");		
	}
	private void function5 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 555555555555");		
	}
	private void function5 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 555555555555");		
	}

	private void function6 (float x)
	{
System.out.println("INSIDE THE FLOAT FUNCTION 666666666666666");		
	}
	private void function6 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 666666666666666");		
	}

	private void function7 (double x)
	{
System.out.println("INSIDE THE DOUBLE FUNCTION 7777777777");		
	}

	private void function8(char x)
	{
System.out.println("INSIDE THE ONLY CHAR FUNCTION ");		
	}
	
	/*
	 * Methods cannot be overloaded based on method return types.
	 * MethodName, InputParameters and ReturnType together form a method.
	 */
//	private String returnStringType ()
//	{
//		return "String type";
//	}
//	
//	private String[] returnStringType ()
//	{
//		return new String[]{"One", "Two"};
//	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		short character = 10;
		double d = 1.0; 
		
		new MethodOverloading().function1(character); 
		new MethodOverloading().function2(character);
		new MethodOverloading().function3(character);
		new MethodOverloading().function4(character);
		new MethodOverloading().function5(character);
		new MethodOverloading().function6(character);
		new MethodOverloading().function7(character);
		new MethodOverloading().function8((char)d);
		
	}
	
}
