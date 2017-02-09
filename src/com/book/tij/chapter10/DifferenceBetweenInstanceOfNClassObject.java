package com.book.tij.chapter10;

public class DifferenceBetweenInstanceOfNClassObject
{
	static void test (Object x)
	{
		
		/*
		 * instanceof and isInstance() - produce the same result. 1,2 produce the same result as 3,4
		 * == and equals() - of class comparison product the same result. 5,6 produce the same result as 7,8
		 * 
		 * instanceof or isInstance() say "are u this class or a class derived from this class".
		 * when the class objects are compared using == or equals then its the actual Type or it isnt. Here inheritance doesnt come into picture.
		 */
System.out.println("getClass() Method : " + x.getClass());
System.out.println("x instanceof Base : " + (x instanceof Base));//1
System.out.println("x instanceof Derived : " + (x instanceof Derived));//2
System.out.println("Base.isInstance(x) : " + (Base.class.isInstance(x)));//3
System.out.println("Derived.isInstance(x) : " + (Derived.class.isInstance(x)));//4
System.out.println("x.getClass() == Base.class : " + (x.getClass() == Base.class));//5
System.out.println("x.getClass() == Derived.class : " + (x.getClass() == Derived.class));//6
System.out.println("x.getClass().equals(Base.class) : " + (x.getClass().equals(Base.class)));//7
System.out.println("x.getClass().equals(Derived.class) : " + (x.getClass().equals(Derived.class)));//8
	}
	
	public static void main(String[] args)
	{
//		test (new Base());
		test (new Derived());
	}
}

class Base {}
class Derived extends Base {}