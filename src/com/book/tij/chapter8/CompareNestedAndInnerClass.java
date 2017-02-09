package com.book.tij.chapter8;

public class CompareNestedAndInnerClass
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

class NestedOuterClass
{
	private static int x = 10;
	private int y = 100;
	/*
	 * Any Inner class which is StatIC is called a 'NESTED CLASS'
	 * A nested class need not implicitly keep reference to the outer class
	 * A nested class can have static variables
	 * A nested class can have nested classes
	 * A nested class can access static variables of outer class
	 */
	private static class NestedClass1
	{
		private static int i = x;
		int y = x;
		
		/*
		 * Static inner class cannot access non-static Outer class variables.
		 */
//		private int j = y;
		private int j = 100;
	}
	
	private class InnerClass
	{		
//		private static int i = x;//Non-static class cannot have static varaibles
		private int i = x; //Outer class static reference to a non-static inner reference
		private int j = y;//Outer class non-static reference to a non-static inner reference
	}
}