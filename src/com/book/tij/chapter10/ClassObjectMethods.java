package com.book.tij.chapter10;

public class ClassObjectMethods
{
	static void printClassInfo (Class cc)
	{
System.out.println("\n\nNAME OF THE CLASS : " + cc.getName());
System.out.println("CLASS TOSTRING METHOD : " + cc);
System.out.println("IS INTERFACE : " + cc.isInterface());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//class object can be got in 2 different ways
		try
		{
			Class cc = Class.forName("com.fic.book.tij.chapter10.FancyToy");
			printClassInfo(cc);
			
			Class[] interfaces = cc.getInterfaces();
			for (int i = 0; i < interfaces.length; i++)
			{
				printClassInfo(interfaces[i]);
			}
			
			/*
			 * No furthur class information is available in the below code at compile time.
			 * the class information can be obtained only at runtime.
			 * base class reference is created even without the actual object instance present.
			 * here there is no object of FancyToy present and the base class Toy object is created. 
			 */
			Class superclass = cc.getSuperclass();
			Object obj = superclass.newInstance();
			printClassInfo(obj.getClass());
		}
		catch (ClassNotFoundException e)
		{
System.err.println("Class FancyToy not found");			
		}
		catch (InstantiationException e)
		{
System.err.println("super class Toy couldnt be instantiated");			
e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
System.err.println("Java security was broken when superclass Toy is instantiated");			
		}
	}
}

interface HasBatteries{}
interface WaterProof {}
interface Shoots {}

class Toy 
{
//	Toy (){}
	
	Toy (int i){}
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots	
{
	FancyToy ()
	{
		super (1);
	}
}

