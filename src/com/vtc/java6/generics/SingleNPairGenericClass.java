package com.vtc.java6.generics;

public class SingleNPairGenericClass
{
	public static void main(String[] args)
	{
		Single<Pair<String, String>> stash = new Single <Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>();
		pair.setLeft("left");
		pair.setRight("right");
		stash.setT(pair);
		
System.out.println("Pair Left : " + pair.getLeft() + " Pair right : " + pair.getRight());		
	}
	
	private static class Single<T>
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
	}

	private static class Pair<T, U>
	{
		private T left;
		private U right;
		
		public T getLeft()
		{
			return left;
		}
		
		public void setLeft (T _left)
		{
			left = _left;
		}
		
		public U getRight()
		{
			return right;
		}
		
		public void setRight (U _right)
		{
			right = _right;
		}
	}
}
