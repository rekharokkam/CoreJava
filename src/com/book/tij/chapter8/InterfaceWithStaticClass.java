package com.book.tij.chapter8;

/*
 * Any class defined inside of an interface is by default static and public
 * so any class inside of an interface becomes a Nested class
 */
public interface InterfaceWithStaticClass
{
	/*
	 * All fields of an Interface are StatIC, FINAL & PUBLIC
	 * But a class defined inside of an Interface is  
	 * PUBLIC 
	 * StatIC 
	 * NOT FINAL
	 */
	class InterfaceNestedClass
	{
		public int i = 45;
		void f(){}
	}
}

class SomeClass
{
	public static void main(String[] args)
	{
		InterfaceWithStaticClass.InterfaceNestedClass interfaceNestedClass = 
			new InterfaceWithStaticClass.InterfaceNestedClass();
System.out.println(interfaceNestedClass.i);		
	}
}

//Can extend Interface Inner class
class ClassExtendingInterfaceInnerClass extends 
	InterfaceWithStaticClass.InterfaceNestedClass
{
	void f(){}
}
