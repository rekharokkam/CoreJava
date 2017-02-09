package com.book.tij.chapter7;

public class AbstractAccessSpecifier extends ParentAbstractClass
{
	//Access specifier can be same as the overloaded method or more but cannot be lesser
	protected String test()
	{
System.out.println("INSIDE THE OVERLOADED METHOD");
		return "100";
	}

	public static void main(String[] args) 
	{
		new AbstractAccessSpecifier().test();
	}
}

abstract class ParentAbstractClass
{
	abstract String test();
}
