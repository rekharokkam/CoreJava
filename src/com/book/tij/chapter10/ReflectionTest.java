package com.book.tij.chapter10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/*
 * Difference between RTTI and Reflection is tat
 * RTTI - Compiler opens and examines the .class file at compile time. Methods can be called in the normal way
 * Reflection - .class file is unavailable at compile time. Its opened and examined by the Runtime.
 */

public class ReflectionTest implements HasMethod
{
	/*
	 * Only public constructors are fetched during reflection.
	 * The default constrcutor automatically placed by the compiler is given the same access as the class. 
	 */
//	public ReflectionTest(){}
	
	private static Pattern pattern = Pattern.compile("\\w+\\.");
	
	/* Shows as its own method */
	public void showMe(){}
	
	/*
	 * Methods with all access specifiers are fetched by the getDeclaredMethods()
	 * Only public methods are fetched by getMethods()
	 */
	void printClassInfo (String className)
	{
		try
		{
			Class cc = Class.forName(className);
			Method[] methods = cc.getMethods();
			Method[] declaredMethods = cc.getDeclaredMethods();
			Constructor[] cons = cc.getConstructors();
			
			for (int i = 0; i < methods.length; i++)
			{
System.out.println("\neach method object toString() : " + methods[i].toString());

				/*
				 * Either of the below 2 ways can be used but the difference is.
				 * Directly on String is useful for single shot usage.
				 * When used more than once then precompiled version holds good.
				 */
//				String methodName = pattern.matcher(methods[i].toString()).replaceAll("");
				String methodName = methods[i].toString().replaceAll("\\w+\\.", "");
				
System.out.println("only the method names without any package name attached : " + methodName);
			}
System.out.println("\n\n");

			for (int i = 0; i < declaredMethods.length; i++)
			{
System.out.println("each declared method object toString() : " + declaredMethods[i].toString());				
			}
System.out.println("\n\n");

			for (int i = 0; i < cons.length; i++)
			{
System.out.println("\neach constructor : " + cons[i].toString());				
			}
		}
		catch (ClassNotFoundException e)
		{
System.err.println("Class name passed for instantiation was not found");			
		}
	}	
	
	public static void main(String[] args)
	{
		new ReflectionTest().printClassInfo("com.fic.book.tij.chapter10.ReflectionTest");
	}
}

interface HasMethod  
{
	void showMe ();
}