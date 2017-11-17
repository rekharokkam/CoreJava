package com.learning.test;

public abstract class Parent
{
	public int count = 10;
	
	public int calculate (int a){
		return a + this.count;
	}
	
	public static void main(String[] args)
	{
		Child child = new Child ();
		System.out.println(child.calculate(5));
	}
}

class Child extends Parent {
	public int count = 3;
}
