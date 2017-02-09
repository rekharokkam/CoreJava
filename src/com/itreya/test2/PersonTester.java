package com.itreya.test2;

import java.util.Arrays;

public class PersonTester
{
	public static void main (String args[])
	{
		Person persons[] = new Person [5];
		
		String names[] = {"lakshmi", "Venkatesh", "roopa", "prashanth", "rekha"};
		
		persons[0] = new Person(4, names[2], "BankColony");
		persons[1] = new Person(1, names[0], "BankColony");
		persons[2] = new Person(0, names[1], "BankColony");
		persons[3] = new Person(3, names[4], "BankColony");
		persons[4] = new Person(2, names[3], "BankColony");
		
		PersonComparator comparator = new PersonComparator ("Id", 19);
		Arrays.sort (persons,comparator);
		
		System.out.println ("\n");
		
		for (int i = 0; i < persons.length; i ++)
		{
			System.out.println ("THE PERSON'S ID = " + persons[i].getId() + "  Name = " + persons[i].getName ());
		}
		
	}
}
