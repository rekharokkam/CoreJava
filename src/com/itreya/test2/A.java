/**
 * CLass which needs to be created and called during run time
 */

package com.itreya.test2;


public class A
{

	public A()
	{
		System.out.println ("Inside no argument constructor");
	}
	
	public A(String a_strName)
	{
		System.out.println("Inside ONE argument constructor " + a_strName);		
	}
	
	public A(String a_strName, String a_strAge)
	{
		System.out.println("Inside TWO arguments constructor " + a_strName + "  Another Argument = " + a_strAge);	
	}
	
	public int function1 ()
	{
		int iReturn = 100;
		return iReturn;
	}
	
	public String function2 (String a_iName)
	{
		return "Name is " + a_iName;
	}

}
