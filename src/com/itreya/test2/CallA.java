/**
 * This class creates an instance of any given class and calls method/s specified
 */

package com.itreya.test2;

import java.lang.reflect.*;

public class CallA
{
	
	public CallA ()
	{}
	
	private Object obj; //required Class new Instance Object
	private String className;// The class to be instantiated during runtime
	private String[] argv;
	private Constructor constructor;
	private Class newClass;//required class's Class object
	private Object constrcutorArgs[];
	private Method method; //Method to be invoked
	private Object[] methodArguments;
	private int iSeperator;
	private static final String strSeperator = "@";
	
	
	
	public void createClass (String a_strClassName) throws ClassNotFoundException, InstantiationException, 
		NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		className = a_strClassName;
		newClass = Class.forName(className);
	}
	
	public void checkArguments (String args[]) throws IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InstantiationException
	{
		argv = args;
		if (argv.length <= 0)	
		{
			throw new IllegalArgumentException ("Required number of parameters not passed");
		}	
		
		//find the position of seperator
		for (int i = argv.length; --i >= 0;)
		{
			if (argv[i].equals(strSeperator))
			{
				iSeperator = i;
				break;
			}
		}
		
		createClass(argv[0]);
		
		//set up for calling the constructor
		Class[] consArgs = new Class[iSeperator - 1];
		for (int i = 0; i < consArgs.length; i++)
		{
			consArgs[i] = String.class;
		}
		
		constructor = newClass.getConstructor(consArgs);
		
		//set up for calling the method passed as the argument
		int firstMethodArg = iSeperator + 2;
		Class[] methodArgs = new Class[argv.length - firstMethodArg];
		for (int j = 0; j < methodArgs.length; j++)
		{
			methodArgs[j] = String.class;
		}
		
		String methodName = argv[iSeperator + 1];
		method = newClass.getMethod(methodName, methodArgs);
		
		methodArguments = new Object[argv.length - firstMethodArg];
		System.out.println("METHOD ARGUMENT LENGTH = " + methodArguments.length);
		for (int i = 0; i < methodArguments.length; i++)
		{
			methodArguments[i] = argv[firstMethodArg + i];
		}
		
	}
	
	public void createInstance () throws ClassNotFoundException, InstantiationException, 
		NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		
		if (null == constructor)
		{
			//if the constructor is null then use no argument constructor
			obj = newClass.newInstance();
		}
		else
		{
			//use argument constructor when the constructor is not null
			constrcutorArgs = new Object[iSeperator - 1];
			for (int i = 0; i < constrcutorArgs.length; i++)
			{
				constrcutorArgs[i] = argv[i + 1];
			}
			
			obj = constructor.newInstance(constrcutorArgs);
		}
	}

	public void callMethod () throws NoSuchMethodException, NoSuchMethodException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		
		System.out.println("The method name = " + method.getName());
		if (methodArguments.length <= 0)
		{
			System.out.println("The length is zero");
			methodArguments = null;
		}
		if (newClass.isInstance(new A()))
		{
			System.out.println("yes ");
		}
		//Object returnObj = method.invoke(newClass, methodArguments);
		System.out.println("THE RETURNED VALUE IS " );
	}

	public static void main(String[] args)
		
	{
		try
		{
			CallA callA = new CallA ();
			callA.checkArguments(args);
			callA.createInstance();
			callA.callMethod();
		}
		catch (Exception e)
		{
			System.out.println("THE EXCEPTION IS\n");
			e.printStackTrace();
		}
		
		
	}
}
