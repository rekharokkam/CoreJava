package com.book.tij.chapter10;

public class PolymorphicBehaviour
{
	public static void main(String[] args) 
	{
		/*
		 * The array comprises of only references of basic class Shape.
		 * Its the RTTI and the polymorphic behaviour tat determine the exact derived type to be executed during the runtime. 
		 */ 
		Shape[] shapes = {new Triangle(), new Circle(), new Square()};
		for (int i = 0; i < shapes.length; i++)
		{
			shapes[i].draw();			
		}
	}
}

class Shape 
{
	void draw ()
	{
System.out.println(this + ".draw()");		
	}
}

class Triangle extends Shape 
{
	public String toString ()
	{
		return "Triangle";
	}
}

class Circle extends Shape 
{
	public String toString ()
	{
		return "Circle";
	}
}

class Square extends Shape 
{
	public String toString ()
	{
		return "Square";
	}
}