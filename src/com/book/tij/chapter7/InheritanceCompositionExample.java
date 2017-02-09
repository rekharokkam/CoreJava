package com.book.tij.chapter7;

public class InheritanceCompositionExample {}

/*
 * Inheritance is used in situations when Parent's Interface is required
 * composition reuses existing types as part of the underlying implementation of the new type
 * Inheritance reuses the interface.
 */ 
abstract class Actor
{
	abstract void act();
}

//Use Inheritance to create change in behaviour 
class HappyActor extends Actor
{
	void act()
	{
System.out.println("Happy Actor");		
	}
}

//Use Inheritance to create change in behaviour
class SadActor extends Actor
{
	void act()
	{
System.out.println("Sad Actor");		
	}
}

/*
 * When in confusion which one to choose - Inheritance / Composition Use Composition
 */
class Stage
{
	//use composition to create change in state
	Actor actor = new HappyActor();
	void change ()
	{
		actor = new SadActor();
	}
	
	void performPlay ()
	{
		actor.act();
	}
}