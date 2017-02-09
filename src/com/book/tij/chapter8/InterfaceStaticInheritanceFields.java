package com.book.tij.chapter8;

public class InterfaceStaticInheritanceFields {

	public static void main(String[] args) 
	{
		new Child();
	}

}

class Name
{
	private String message;
	Name (String message)
	{
		this.message = message;
System.out.println(message);		
	}
	
	String getMessage()
	{
		return message;
	}
}

class ClassParent
{
	static Name NAME1 = new Name ("StatIC VARIABLE OF CLASS PARENT");
	Name name2 = new Name ("Non-Static VARIABLE OF CLASS PARENT");
}

interface Parent
{
	Name NAME3 = new Name ("FROM INTERFACE 3333333333");
	Name NAME4 = new Name ("FROM INTERFACE 4444444444");
}

/*
 * Static varaibles of parent class get loaded first
 * Static variable of child class get loaded second 
 * variables of the interface get loaded when accessed for the first time which could be any time in the lifecycle of the child class
 * Local variable of parent class gets loaded
 * local variables of the child class get loaded next 
 */
class Child extends ClassParent implements Parent
{
	static Name NAME6 = NAME3;
	static Name NAME5 = new Name ("FROM IMPLEMENTING CLASS 5555555555");
	
//	Name NAME7 = NAME4;//static reference being assigned to non static variable
	Name name8 = new Name ("FROM IMPLEMENTING CLASS 6666666");
}