package com.book.tij.chapter8;

public class MultipleInheritance 
{
	static void t (CanFight canFight)
	{
		canFight.fight();
	}
	
	static void u (CanSwim canSwim)
	{
		canSwim.swim();
	}

	static void v (CanFly canFly)
	{
		canFly.fly();
	}

	static void w (ActionCharacter actionCharacter)
	{
		actionCharacter.fight();
	}
	
	public static void main(String[] args) 
	{
		Hero hero = new Hero ();
		t (hero); //Upcast to CanFight interface
		u (hero);//Upcast to CanSwin interface
		v (hero);//Upcast to CanFly interface
		w (hero);//Upcast to ActionCharacter Concrete class
	}
}

interface CanFight
{
	void fight();
}

interface CanSwim
{
	void swim();
}

interface CanFly
{
	void fly();
}

class ActionCharacter
{
	public void fight()
	{
System.out.println("ActionCharacter :: fight");		
	}
	
//	protected void fight()
//	{
//System.out.println("ActionCharacter :: fight");		
//	}
}

/*
 * when a class inherits a Concrete class and interfaces
 * 1. concrete / abstract class should be mentioned first
 * 2. all the interfaces should be seperated by comma after the concrete/abstract class as shown  
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly
{
	public void swim()
	{
System.out.println("swim");		
	}

	public void fly()
	{
System.out.println("Hero :: fly");		
	}
	
	/*
	 * This class need not provide an implementation for CanFight interface because its already implemented in the ActionCharacter class
	 * if the actioncharacter class fight method access specifier becomes lesser than public then a seperate implementation has to be provided
	 */

//	public void fight ()
//	{
//System.out.println("Hero :: fight");		
//	}
	
}