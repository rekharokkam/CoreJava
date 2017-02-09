package com.book.tij.chapter7;

import java.util.Random;

public class Shapes 
{
	public static void main(String[] args) 
	{
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape[] shapes = new Shape[5];
		for (int i = 0; i < 5; i++) 
		{
			shapes[i] = shapeFactory.next();
			shapes[i].draw();
			shapes[i].erase();
		}
	}

}

//factory to generate the shapes
class ShapeFactory
{
	private Random random = new Random();
	Shape next()
	{
		switch (random.nextInt(3))
		{
			case 0 : return new Circle ();
			case 1 : return new Square();
			case 2 : return new Triangle();
			default : return null;
		}
	}
}


class Shape 
{
	void draw(){}
	void erase(){}
}

class Circle extends Shape 
{
	void draw()
	{
System.out.println("CIRCLE :: DRAW");		
	}

	void erase()
	{
System.out.println("CIRCLE :: ERASE");		
	}
}

class Square extends Shape 
{
	void draw()
	{
System.out.println("SQUARE :: DRAW");		
	}

	void erase()
	{
System.out.println("SQUARE :: ERASE");		
	}
}

class Triangle extends Shape 
{
	void draw()
	{
System.out.println("TRIANGLE :: DRAW");		
	}

	void erase()
	{
System.out.println("TRIANGLE :: ERASE");		
	}
}