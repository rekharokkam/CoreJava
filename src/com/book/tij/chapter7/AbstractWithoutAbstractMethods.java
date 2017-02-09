package com.book.tij.chapter7;

//create a class as Abstract even though it doesnt have any abstract methods to avoid instance creation
public abstract class AbstractWithoutAbstractMethods 
{
	void play()
	{
System.out.println("INSIDE THE PLAY METHOD");		
	}
	public static void main(String[] args) 
	{
		//cannot create a direct instance because it is an abstract class
		//AbstractWithoutAbstractMethods obj = new AbstractWithoutAbstractMethods();
	}
}
