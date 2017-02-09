package com.book.tij.chapter6;

public class PrivateFinalTest {

	public static void main(String[] args) 
	{
		Child1 child1 = new Child1();
		child1.f();
		child1.g();
		
		BaseClass baseClass = child1;		
//		baseClass.f(); // cannnot call as it is private
		baseClass.g();
	}
}

class BaseClass
{
	private void f()
	{
System.out.println("BASECLASS :: f ");		
	}
	
	public void g()
	{
System.out.println("BASECLASS :: g ");		
	}
}

class Child1 extends BaseClass 
{
/*
 * Not overriding just method with the same name as the base class method name - base class method is private so it is final implicitly
 * it cannot be overriden. 
 */ 	
	public void f()  
	{
System.out.println("CHILD1 :: f ");		
	}
	
	/*
	 * This is an overridden method
	 */
	public void g()
	{		
System.out.println("CHILD1 :: g ");		
	}
}