package com.book.tij.chapter8;

public class AnonymusClassWithArgumentBaseClass
{
	Wrapping getWrapping(int x)
	{
		//Anonymus subclass of Wrapping class. 
		return new Wrapping(x)//passing argument to base class constructor
		{
			Name name = new Name ("'ANONYMUS INNER CLASS WITH " +
					"ARGUMENT BASE CLASS CONSTRUCTOR' - NON-StatIC OBJECT VARIABLE");
			//Overriding the base class abstract method
			void value ()
			{				
			}
			
			//Overriding the base class ordinary method
			int value (int x)
			{
				return (super.value(x) * 100);
			}
		};
	}
	
	public static void main(String[] args)
	{
		new AnonymusClassWithArgumentBaseClass().getWrapping(10);
	}
}

abstract class Wrapping
{
	private int i;
	Wrapping(int i)
	{
		this.i = i;
	}
	abstract void value ();

	int value (int i)
	{
		return i * i;
	}
}