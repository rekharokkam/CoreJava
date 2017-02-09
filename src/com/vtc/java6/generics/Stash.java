package com.vtc.java6.generics;

public class Stash<T>
{
	private T x;
	
	public T getT()
	{
		return x;
	}
	
	public void setT (T _t)
	{
		x = _t;
	}
	
	public static void main(String[] args)
	{
		Stash<Integer> genericsStr = new Stash<Integer>();
		genericsStr.setT(10);
System.out.println("Generics Integer : " + genericsStr.getT());		
	}
}
