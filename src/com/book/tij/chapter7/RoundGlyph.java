package com.book.tij.chapter7;

public class RoundGlyph extends Glyph 
{
	private int radius = 1;
	
	void draw ()
	{
System.out.println("DRAW METHOD OF ROUNDGLYPH : " + radius);		
	}
	
	RoundGlyph (int radius)
	{
		this.radius = radius;
System.out.println("CONSTRUCTOR :: ROUNDGLYPH : RADIUS -  " + radius);		
	}
	
	public static void main(String[] args) 
	{
		new RoundGlyph(5);
	}
}

abstract class Glyph
{
	abstract void draw();
	
	/*
	 * Inside COnstructors use as little as possible to construct the Object
	 * if possible avoid calling methods
	 * safe methods tat can be called are : final methods or 
	 * private method as private methods are final implicitly 
	 */
	Glyph ()
	{
System.out.println("CONSTRUCTOR :: GLYPH : BEFORE CALLING DRAW");
		draw();
System.out.println("CONSTRUCTOR :: GLYPH : AFTER CALLING DRAW");		
	}
}

