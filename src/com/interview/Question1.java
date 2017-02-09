package com.interview;

public class Question1
{
	/*
	 * Problem 1
	 * Write a method which given two integers returns the value tat is closest to 1000.
	 */
	
	private static final int LIMItatION = 1000;
	
	static int calculateClosetToThousand (int a, int b)
	{
		int firstNumberDifference = Math.abs(a - LIMItatION);

		int secondNumberDifference = Math.abs(b - LIMItatION);

		return (firstNumberDifference < secondNumberDifference) ? a : b;
	}
	
	public static void main(String[] args)
	{
		/*
		 * Different test cases 
		 * 
		 * 1) Both are greater than 1000
		 * 2) Both are lesser than 1000
		 * 3) Both are same as 1000
		 * 4) One greater and one lesser than 1000   
		 * 5) When Either Number is Negative
		 * 6) When both are Negative
		 */
		
System.out.println("When Both are Greater Than 1000 : " + calculateClosetToThousand(2003, 2002));
System.out.println("When Both are lesser than 1000 : " + calculateClosetToThousand(997, 543));
System.out.println("Both are same as 1000 : " + calculateClosetToThousand(1000, 1000));
System.out.println("One greater another lesser than 1000 :  " + calculateClosetToThousand(998, 1001));
System.out.println("When either Number is Negative :  " + calculateClosetToThousand(-999, 998));
System.out.println("When Both are negative :  " + calculateClosetToThousand(-7, -5));
	}
}
