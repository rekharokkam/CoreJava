package com.vtc.java6.generics;

public class GenericNonGenericMethods
{
	public void nonGenericMethod (Object t)
	{
System.out.println("Passed in Object class from generic Method : " + t.getClass().getName());
	}
	
	public <T> void genericMethod (T t)
	{
System.out.println("Passed in Object class from generic Method : " + t.getClass().getName());		
	}
	
	public static void main(String[] args)
	{
		new GenericNonGenericMethods().nonGenericMethod(new String());
		new GenericNonGenericMethods().genericMethod(10);
	}
}
