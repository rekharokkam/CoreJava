package com.book.tij.chapter8;

public class OverridingInnerClasses
{
	public static void main(String[] args)
	{
		Egg egg = new BigEgg();
		egg.g();
	}
}

/*
 * Each Inner class is present in its own namespace
 */
class Egg
{
	private Yolk y = new Yolk();
	
	Egg()
	{
System.out.println("EGG : CONSTRUCTOR");		
	}
	
	void insertYolk (Yolk y)
	{
System.out.println("EGG : insertYolk()");		
		this.y = y;
	}
	
	void g()
	{
System.out.println("EGG : g() CALLING f()");		
		y.f();
	}
	
	class Yolk
	{
		Yolk()
		{
System.out.println("EGG :: YOLK : CONSTRCUTOR");
		}
		
		void f()
		{
System.out.println("EGG :: YOLK : f()");			
		}
	}
}

class BigEgg extends Egg
{
	BigEgg()
	{
System.out.println("BIGEGG : CONSTRUCTOR");
		//new Yolk creates an instance of its own inner class and not tat of parent class
		insertYolk(new Yolk());
	}
	
	class Yolk extends Egg.Yolk
	{
		Yolk ()
		{
System.out.println("BIGEGG :: YOLK : CONSTRCUTOR");			
		}
		
		void f ()
		{
System.out.println("BIGEGG :: YOLK : f()");			
		}
	}
}
