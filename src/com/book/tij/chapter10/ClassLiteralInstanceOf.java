package com.book.tij.chapter10;

import java.util.Random;

public class ClassLiteralInstanceOf
{

private static Random random = new Random();
	
	public static void main(String[] args)
	{
		Object[] pets = new Object[15];

		/*
		 * Class.forName () - is runtime and throws exception
		 * <TypeName>.class - compile time and doesnt throw any exception. 
		 * Compare this pgm with InstanceOfTest.java  
		 */
		
//		Class[] typeClasses = {
//				Class.forName("com.fic.book.tij.chapter10.Pet"),
//				Class.forName("com.fic.book.tij.chapter10.Dog"),
//				Class.forName("com.fic.book.tij.chapter10.Cat"),
//				Class.forName("com.fic.book.tij.chapter10.Rodent"),
//				Class.forName("com.fic.book.tij.chapter10.Pug"),
//				Class.forName("com.fic.book.tij.chapter10.Rodent"),
//				Class.forName("com.fic.book.tij.chapter10.Gerbil"),
//			};

		
		Class[] typeClasses = {
				Pet.class,
				Dog.class,
				Cat.class,
				Rodent.class,
				Pug.class,
				Hamster.class,
				Gerbil.class,
			};
		

		try
		{
			//fill the pets with objects of different pets based on random selection
			for (int i = 0; i < pets.length; i++)
			{
				pets[i] = typeClasses[random.nextInt(typeClasses.length)].newInstance();
			}
			
			//populate the associative array (Map). Idea is only to count the number of times the pets are generated
			AssociativeArray map = new AssociativeArray(typeClasses.length);
			for (int i = 0; i < typeClasses.length; i++)
			{
				map.put(typeClasses[i].toString(), new Counter());
			}
			
			//count the occurance of each pet object
			for (int i = 0; i < pets.length; i++)
			{
				String typeName = "";
				
				if (pets[i] instanceof Pet)
				{
					typeName = "class com.fic.book.tij.chapter10.Pet";
				}
				if (pets[i] instanceof Dog)
				{
					typeName = "class com.fic.book.tij.chapter10.Dog";
				}
				if (pets[i] instanceof Cat)
				{
					typeName = "class com.fic.book.tij.chapter10.Cat";
				}
				if (pets[i] instanceof Rodent)
				{
					typeName = "class com.fic.book.tij.chapter10.Rodent";
				}
				if (pets[i] instanceof Pug)
				{
					typeName = "class com.fic.book.tij.chapter10.Pug";
				}
				if (pets[i] instanceof Gerbil)
				{
					typeName = "class com.fic.book.tij.chapter10.Gerbil";
				}
				if (pets[i] instanceof Hamster)
				{
					typeName = "class com.fic.book.tij.chapter10.Hamster";
				}
				((Counter)map.get(typeName)).i ++;
			}
			
System.out.println(map);			
		}
		catch (InstantiationException e)
		{
System.err.println("Instantiation exception");			
		}
		catch (IllegalAccessException e)
		{
System.err.println("Java Security broken");			
		}
		catch (Exception e)
		{
			e.printStackTrace();			
		}
	}	

}
