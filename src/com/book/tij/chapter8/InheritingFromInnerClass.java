package com.book.tij.chapter8;

public class InheritingFromInnerClass
{
	public static void main(String[] args)
	{
		WithInner wi = new WithInner();
		InheritInnerClass inheritInnerClass = new InheritInnerClass(wi);
	}
}

class WithInner
{
	class Inner
	{
		
	}
}

class InheritInnerClass extends WithInner.Inner
{
	/*
	 * default constrcutor not allowed for a class inheriting from an Inner class
	 * Every Inner class keeps a secret reference of the Enclosing class 
	 * to attach itself with the Outer class Object.
	 */

//	InheritInnerClass()
//	{}
	
	/*
	 * This syntax provides a necessary object for linking the Inner class with Outer class
	 */
	InheritInnerClass (WithInner wi)
	{
		wi.super();
	}
}
