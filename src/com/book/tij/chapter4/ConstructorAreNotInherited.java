package com.book.tij.chapter4;

public class ConstructorAreNotInherited
{
	public static void main(String[] args)
	{
		//Consturctors are not inherited by the child classes
//		ChildClass childClass = new ChildClass ("");
	}
}

class ParentClass
{
	private String s;
	
	ParentClass()
	{
		
	}
	
	ParentClass (String s)
	{
		this.s = s;
	}
}

class ChildClass extends ParentClass
{
//	ChildClass()
//	{
//		super ();
//	}
}