package com.book.tij.chapter8;

public class DifferentAccessSpecifierInnerClasses 
{
	public static void main(String[] args) 
	{
		//Different ways to initialise inner classes
		OuterClass outerClass = new OuterClass();
		OuterClass.ProtectedInnerClass protectedInnerClass = outerClass.new ProtectedInnerClass();
		//Cannnot access as its private class
//		OuterClass.PrivateInnerClass privateInnerClass = outerClass.new PrivateInnerClass();
	}
	
	
}

class OuterClass
{
	static Name name1 = new Name ("OUTER CLASS StatIC VARIABLE");
	Name name2 = new Name ("OUTER CLASS OBJECT VARIABLE");
	//private inner class
	private class PrivateInnerClass
	{
	}
	
	//default / package access inner class
	class PackageOrDefaultInnerClass
	{		
	}
	
	//protected inner class
	protected class ProtectedInnerClass
	{
		//Cannot declare static fields inside of non-static inner class
//		static Name name3 = new Name ("INNER CLASS StatIC VARIABLE");
		Name name3 = new Name ("NON-StatIC PROTECTED INNER CLASS OBJECT VARIABLE");
		
	}
	
	//public inner class
	public class PublicInnerClass
	{	
		Name name4 = new Name ("NON-StatIC PUBLIC INNER CLASS OBJECT VARIABLE");
	}
}

