package com.vtc.java6.generics;

public class ParametricBinding
{
	public static void main(String[] args)
	{
//		InnerStash<Number> innerStash1 = new InnerStash<Number>();
//		innerStash1.setNumber(198.67);
//System.out.println("Inner Stash : " + innerStash1.getNumber());
//
//
//		InnerStash<Float> innerStash2 = new InnerStash<Float>();
//		innerStash2.setNumber(200.543f);
//System.out.println("Inner Stash : " + innerStash2.getNumber());	
		
		InnerStash2<Integer> innerStash2 = new InnerStash2<Integer>();
		innerStash2.setNumber(198);
System.out.println("Inner Stash : " + innerStash2.getNumber());
	}
	
	private static class InnerStash <T extends Number>
	{
		private T number;
		
		public void setNumber (T _number)
		{
			number = _number;
		}
		
		public T getNumber()
		{
			return number;
		}
	}
	
	private static class InnerStash2 <Number>
	{
		private Number number;
		
		public void setNumber (Number _number)
		{
			number = _number;
		}
		
		public Number getNumber ()
		{
			return number;
		}
	}
}
