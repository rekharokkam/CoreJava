package com.book.tij.chapter6;

public class ClassLoadingOrder {

	public static void main(String[] args) 
	{
		Beetle beetle = new Beetle();
	}
}

class Insect
{
	static int i = print("static i varibale of Insect class");
	static int j;
	
	static
	{
		j = print ("static initialisation block of Insect class - j");
	}
	
	int k = print ("non-static k of Insect class");
	Nut nut = new Nut("NUT OF INSECT CLASS");
	int l;
	{
		l = print ("non-static initialisation block l of Insect class");
	}
	
	int m;
	
	Insect ()
	{
System.out.println("DEFAULT CONSTRUCTOR OF INSECT CLASS");
		m = print ("Constructor initialisation of m variable inside Insect class");
	}
	
	static int print (String message)
	{
System.out.println(message);	
		return 47;
	}
}

class Beetle extends Insect
{
	static int a = print ("static a varibale of Beetle class");
	static int b;
	
	static
	{
		b = print("static initialisation block of Beetle class - b");
	}
	
	int c = print ("non-static c of Beetle class");
	Nut nut1 = new Nut("NUT OF BEETLE CLASS");
	int d ;
	{
		d = print ("non-static initialisation block d of Beetle class");
	}
	
	int e;
	
	
	Beetle()
	{
System.out.println("DEFAULT CONSTRCUTOR OF BEETLE CLASS");	
		e = print ("Constructor initialisation of e variable inside Insect class");
	}	
}

class Nut
{
	Nut (String message)
	{
System.out.println(message);		
	}
}