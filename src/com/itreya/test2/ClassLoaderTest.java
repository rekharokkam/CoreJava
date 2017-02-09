/*
*This class loads class files from a given location 
*This is from the pdf file C:\Rekha\Materials\Java\BasicJava\ClassForName.pdf
*/


package com.itreya.test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.lang.reflect.*;

public class ClassLoaderTest extends ClassLoader
{
	
	private String m_directoryPath;
	
	//The classes are picked up from d:\classes
	public ClassLoaderTest (String a_directoryPath)
	{
		m_directoryPath = a_directoryPath;
	}
	
	public Class findClass (String className)
	{
		
		Class reqClass = null;
		String fullClassName = className.replace ('.', File.separatorChar);
		fullClassName = fullClassName.concat(".class");
		System.out.println ("this is the full class name = " + fullClassName);
		
		try
		{
			
			reqClass = findLoadedClass (className);
			
			if (null == reqClass)
			{
				File classFile = new File(m_directoryPath, fullClassName);
				FileInputStream input = new FileInputStream (classFile);
		
				DataInputStream dataInput = new DataInputStream (input);
		
				byte allBytes [] = new byte[(int)classFile.length()];
		
				dataInput.readFully (allBytes);
				
				reqClass = defineClass (className, allBytes, 0, allBytes.length);
				
				
			}
			
				
		}
		catch (FileNotFoundException eFNF)
		{
			System.out.println ("inside the file not found exception block");
			eFNF.printStackTrace ();
		}
		catch (IOException eIO)
		{
			System.out.println ("an io exception");
			eIO.printStackTrace ();
		}
		
		return reqClass;	
	}
	
	
	public static void main (String args[]) throws Exception
	{
		ClassLoaderTest test = new ClassLoaderTest ("d:/classes");
		//Class reqClass = test.loadClass ("com.test.SomeTest");
		Class reqClass = Class.forName ("com.test.SomeTest", true, test);
		try
		{
			Object reqCLassInstance = reqClass.newInstance();	
			//((reqClass) reqCLassInstance).test(); Since the class is not previously loaded this method cannot be used
			//So reflection is the best approach
			
			Class[] classArr = new Class[] {Integer.TYPE, Class.forName("java.lang.String")};
			Method method = reqClass.getDeclaredMethod ("test", classArr);	
			
			Object[] allParameters = new Object[] {new Integer (10), "rekha"};
			
			method.invoke (reqCLassInstance, allParameters);
			
			
		}
		catch (InstantiationException eIE)
		{
			System.out.println ("An object from the class instance could not be instantiated");
			eIE.printStackTrace ();
		}
		catch (IllegalAccessException e)
		{
			System.out.println ("the object is accessed illegally");
			e.printStackTrace ();
		}
		
	}
		
	
}
