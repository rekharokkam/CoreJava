package com.book.tij.chapter7;

public class AbstractChildNotImplementingBaseAbstractMethod {

	public static void main(String[] args) 
	{
		Parent parent = new Child2();
		parent.test();
	}
}

abstract class Parent
{
	abstract void test();
	
	void test (String a)
	{
System.out.println("INSIDE THE OVERLOADED METHOD WITH STRING PARAMETER :: PARENT");		
	}
	
}

//IF INHERITING CLASS DOESNT NOT IMPLEMENT PARENT ABSTRACT METHOD THEN IT SHOULD DECLARE ITSELF AS ABSTRACT
abstract class Child1 extends Parent
{
	void test (String a)
	{
System.out.println("INSDIE THE OVERLOADED METHOD WITH STRING ARGUMENT :: CHILD1");		
	}
}

class Child2 extends Child1
{
	void test (String a)
	{
System.out.println("INSDIE THE OVERLOADED METHOD WITH STRING ARGUMENT :: CHILD2");		
	}
	
	void test()
	{
System.out.println("INSDIE THE NON - ABSTRACT METHOD WITH NO ARGUMENT :: CHILD2");		
	}
}