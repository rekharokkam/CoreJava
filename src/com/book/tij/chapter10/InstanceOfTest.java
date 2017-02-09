package com.book.tij.chapter10;

import java.util.Random;

public class InstanceOfTest
{
	private static String[] typeNames = {"Pet", "Dog", "Cat", "Rodent", "Pug", "Gerbil", "Hamster"};
	private static Random random = new Random();
	
	public static void main(String[] args)
	{
		Object[] pets = new Object[15];
		
		try
		{
			Class[] typeClasses = {
				Class.forName("com.fic.book.tij.chapter10.Pet"),
				Class.forName("com.fic.book.tij.chapter10.Dog"),
				Class.forName("com.fic.book.tij.chapter10.Cat"),
				Class.forName("com.fic.book.tij.chapter10.Rodent"),
				Class.forName("com.fic.book.tij.chapter10.Pug"),
				Class.forName("com.fic.book.tij.chapter10.Rodent"),
				Class.forName("com.fic.book.tij.chapter10.Gerbil"),
			};
		
			//fill the pets with objects of different pets based on random selection
			for (int i = 0; i < pets.length; i++)
			{
				pets[i] = typeClasses[random.nextInt(typeClasses.length)].newInstance();
			}
			
			//populate the associative array (Map). Idea is only to count the number of times the pets are generated
			AssociativeArray map = new AssociativeArray(typeNames.length);
			for (int i = 0; i < typeNames.length; i++)
			{
				map.put(typeNames[i], new Counter());
			}
			
			//count the occurance of each pet object
			for (int i = 0; i < pets.length; i++)
			{
				String typeName = "";
				
				if (pets[i] instanceof Pet)
				{
					typeName = "Pet";
				}

				if (pets[i] instanceof Dog)
				{
					typeName = "Dog";
				}

				if (pets[i] instanceof Cat)
				{
					typeName = "Cat";
				}

				if (pets[i] instanceof Rodent)
				{
					typeName = "Rodent";
				}

				if (pets[i] instanceof Pug)
				{
					typeName = "Pug";
				}

				if (pets[i] instanceof Gerbil)
				{
					typeName = "Gerbil";
				}

				if (pets[i] instanceof Hamster)
				{
					typeName = "Hamster";
				}
				((Counter)map.get(typeName)).i ++;
			}
			
System.out.println(map);			
		}
		catch (ClassNotFoundException e)
		{
System.err.println("Required class not found");			
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

class Pet
{}

class Dog extends Pet
{}

class Pug extends Dog
{}

class Cat extends Pet
{}

class Rodent extends Pet
{}

class Gerbil extends Rodent
{}

class Hamster extends Rodent 
{}

class Counter
{
	int i;
	
	public int getI()
	{
		return i;
	}

	public void setI(int i)
	{
		this.i = i;
	}


	public String toString()
	{
		return Integer.toString(i);
	}
}
