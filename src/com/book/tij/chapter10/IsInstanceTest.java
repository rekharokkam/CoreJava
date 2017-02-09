package com.book.tij.chapter10;

import java.util.Random;

public class IsInstanceTest
{
	private static Random random = new Random ();
	public static void main(String[] args)
	{
		Object[] pets = new Object[15];
		Class[] typeClasses = {
				Pet.class,
				Dog.class,
				Cat.class,
				Rodent.class,
				Pug.class,
				Gerbil.class,
				Hamster.class
		}; 
		
		for (int i = 0; i < pets.length; i++)
		{
			try
			{
				//fill the pets selecting randomly
				pets[i] = typeClasses[random.nextInt(typeClasses.length)].newInstance();
			}
			catch (IllegalAccessException e)
			{
System.err.println("Java Security exception");				
			}
			catch (InstantiationException e)
			{
System.err.println("Instantiation exception");				
			}
		}
		
		//create and fill the map
		AssociativeArray map = new AssociativeArray (typeClasses.length);
		for (int i = 0; i < typeClasses.length; i++)
		{
			map.put(typeClasses[i].toString(), new Counter());
		}
		
		//count the pet classes
		for (int i = 0; i < pets.length; i++)
		{
			for (int j = 0; j < typeClasses.length; j++)
			{
				if (typeClasses[j].isInstance(pets[i]))
				{
					((Counter)map.get(typeClasses[j].toString())).i ++;
				}
			}
		}
System.out.println("\n\n" + map);		
	}
}
