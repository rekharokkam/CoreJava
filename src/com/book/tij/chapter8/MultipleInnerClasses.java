package com.book.tij.chapter8;

public class MultipleInnerClasses
{
	public static void main(String[] args)
	{
		//Different ways of calling multiply nested Inner classes
		FirstClass firstClass = new FirstClass();
		FirstClass.SecondClass secondClass = firstClass.new SecondClass();
		FirstClass.SecondClass.ThirdClass thirdClass = secondClass.new ThirdClass();
	}
}

class FirstClass
{
	private void f()
	{
System.out.println("INSIDE THE OUTER CLASS FUNCTION f()");		
	}
	
	class SecondClass
	{
		private void g()
		{
System.out.println("INSIDE THE FIRST INNER CLASS FUNCTION g()");
			f();
		}
		
		
		class ThirdClass
		{
			private void h()
			{
System.out.println("INSIDE THE SECOND INNER CLASS FUNCTION h()");
				//Can call any method in any of the outer classes
				g();
				f();
			}
		}
	}
}