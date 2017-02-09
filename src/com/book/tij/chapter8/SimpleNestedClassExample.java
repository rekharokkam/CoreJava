package com.book.tij.chapter8;

public class SimpleNestedClassExample
{
	/*
	 * Method may / may not be static. But preferred is to be static
	 * No object of Outer class is required to instantiate the nested class 
	 */
	static Contents getContents ()
	{
		//Since ParcelContents is a private class
//		return new SimlpeNestedParentClass.ParcelContents();
		return null;
	}

	/*
	 * Method may / may not be static. But preferred is to be static.
	 * No object of Outer class is required to instantiate the nested class 
	 */
	Destinations getDestination ()
	{
		return new SimlpeNestedParentClass.ParcelDestination("Homes");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

class SimlpeNestedParentClass
{
	private static class ParcelContents implements Contents
	{
		private int i = 100;
		public int value ()
		{
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destinations
	{
		private String label;
		public ParcelDestination(String destinationName)
		{
			label = destinationName;
		}
		
		public String readLabel ()
		{
			return label;
		}
		
		//Nested classes can contain static members
		static int x = 1000;
		public static void f(){}
		
		//Nested class can contain another Nested class
		static class AnotherLevel
		{
			static int x = 100;
			public static void f(){}
		}
		
		//Nested classes can contain inner classes (Non-Static classes)
		class someClass
		{
			public void f(){}
		}
	}
}
