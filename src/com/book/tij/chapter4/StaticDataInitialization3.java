package com.book.tij.chapter4;

public class StaticDataInitialization3 
{
//	static One one = new One();
//	static String oneStr = One.returnStr();
	
//	String name = One.name;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Either of the below approaches for static initializations to happen
//		One one = new One();
//System.out.println("StatIC FIELD FROM CLIENT : " + One.name);
System.out.println("StatIC FUNCTION FROM CLIENT : " + One.returnStr());
	}

	private static class One
	{
		static String name = "One";
		static Two two = new Two();
		
		One()
		{
System.out.println("INSIDE THE CONSTRUCTOR OF ONE");			
		}
		
		static String returnStr()
		{
System.out.println("INSIDE THE METHOD WHICH RETURNS THE STRING : ONE" );
			return "ONE";
		}
	}
	
	private static class Two
	{
		public Two() 
		{
System.out.println("INSIDE THE CONSTRUCTOR OF TWO");			
		}
	}
}
