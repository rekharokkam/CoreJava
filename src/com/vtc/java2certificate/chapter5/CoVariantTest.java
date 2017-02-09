package com.vtc.java2certificate.chapter5;

public class CoVariantTest
{
	class First
	{
		void printMessage ()
		{
System.out.println("Inside Class First");			
		}
	}
	
	class Second extends First
	{
		void printMessage ()
		{
System.out.println("Inside Class Second");			
		}
	}
	
	class FirstReturn 
	{
		First getFirst ()
		{
			return new First ();
		}
	}
	
	class SecondReturn extends FirstReturn
	{
		/*
		 * Before 1.5 it was mandatory to return exact same type as the overriding parent method return type
		 * After 1.5 any subclass tat can be cast to the data type of the parent method return type can be used.
		 * 
		 * eg. this method returns Second class which is child class of First class.
		 * before 1.5 this caused compilation error but since 1.5 onwards this is accepted as Second can be safely casted to First type
		 */
		Second getFirst ()
		{
			return new Second();
		}
	}
	
	public static void main(String[] args)
	{
	}
}
