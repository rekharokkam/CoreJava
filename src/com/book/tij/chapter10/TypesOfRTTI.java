package com.book.tij.chapter10;

public class TypesOfRTTI
{
	public static void main(String[] args)
	{
		/*
		 * There are 3 different ways of RTTI in java
		 * 1) Casting - which casts the objects to the mentioned object at runtime
		 * 2) Class Objects - which gives information about the Type at runtime.
		 * 3) instanceof - which tells if the oject is an instance of the mentioned Type or not. 
		 */
		
		Shape triangle = new Triangle ();//Casting
		new Triangle ().getClass().getName();//Class Object gives information at runtime
		boolean isTriangle = (triangle instanceof Triangle);//instanceof operator. 
	}
}
