package com.book.tij.chapter8;

public class CompareLocalInnerClassAndAnonymusClass
{
	public static void main(String[] args)
	{
		LocalInnerClasses localInnerClasses = new LocalInnerClasses();
		Counter c1 = localInnerClasses.getMethodInnerClassCounter("Aman");
		Counter c2 = localInnerClasses.getMethodAnonymusClassCounter("Arun");
		
		for (int i = 0; i < 5; i ++)
		{
System.out.println("Inner class counter : " + c1.next());			
		}
		
		for (int i = 0; i < 5; i ++)
		{
System.out.println("Anonymus class counter : " + c2.next());			
		}
	}
}

interface Counter
{
	int next();
}

/*
 * Difference between Anonymus Local class and Inner local class
 * Local Inner classes have constructors tat can be overloaded
 * Anonymus local classes have no constructors and cannot be overloaded
 * Local Inner classes are required in the situations When 
 * 		a named Constrcutor OR 
 * 		a overloaded constrcutor is required
 * More than one object of a class is required Local Inner class is preferred to 
 * 		Local Anonymus classes.
 */
class LocalInnerClasses
{
	private int counter; 
	
	Counter getMethodInnerClassCounter (final String name)
	{
		class MethodInnerClass implements Counter
		{
			private String methodInnerClassVarname;
			MethodInnerClass()
			{
				this.methodInnerClassVarname = name;
System.out.println("INSIDE THE DEFAULT CONSTRUCTOR OF A METHOD INNER CLASS : " + name);				
			}
			
			MethodInnerClass (String name)
			{
System.out.println("INSIDE THE ARGUMENT CONSTRUCTOR OF A METHOD INNER CLASS");				
				this.methodInnerClassVarname = name;
			}
			
			public int next ()
			{
System.out.println("FINAL ARGUMENT OF THE METHOD " +
		"INSIDE OF A METHOD INNER CLASS : " + methodInnerClassVarname);

				return ++counter;
			}
		}		
		return new MethodInnerClass();
	}
	
	/*
	 * More than one Instance of a Local Inner class can be created
	 * But the same cannot be avhieved with Local Anonymus class
	 */
	Counter[] getMethodInnerClassCounterArray(final String[] names)
	{
		class MethodInnerClassManyObjs implements Counter
		{
			private String varName ; 
			MethodInnerClassManyObjs(String name)
			{
				varName = name;
System.out.println("INSIDE THE DEFAULT CONSTRUCTOR OF MethodInnerClassManyObjs : " + 
		varName);				
			}

			public int next ()
			{
				return ++counter;
			}
		}		
		return (new MethodInnerClassManyObjs[] {
				new MethodInnerClassManyObjs(names[0]),
				new MethodInnerClassManyObjs (names [1])
				});
	}
	
	Counter getMethodAnonymusClassCounter (final String name)
	{
		//Anonymus Inner class
		return new Counter ()
		{
			String methodAnonymusClassVarname;
			//initialised blocks acts as constructor
			{
System.out.println("INISIDE THE INITIALISER BLOCK OF AN ANONYMUS INNER CLASS" );
				this.methodAnonymusClassVarname = name;
			}
			
			public int next ()
			{
System.out.println("FINAL ARGUMENT OF THE METHOD " +
		"INSIDE OF A METHOD ANONYMUS CLASS : " + methodAnonymusClassVarname);
				return ++counter;
			}
		};
	}
}