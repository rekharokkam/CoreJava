package com.vtc.java2certificate.chapter3;

/*
 * There is no Bitwise operators floating point numbers
 */
public class BitWiseOperator
{
	private static void printBitWiseNumber ()
	{
		int a = 245;
System.out.println("Binary representation : " + Integer.toBinaryString(a));		
		int x = Integer.valueOf("11110101", 2);
System.out.println("Integer representation : " + x);	
		
	}
	
	private static void complimentaryOperator ()
	{
		int a = Integer.valueOf("00000001", 2);
System.out.println("Actual Number : " + a + " :: Complimentary operator results in : " + (~a));		
	}
	
	private static void bitwiseLeftShift ()
	{
		int a = Integer.valueOf("11110101", 2);
		int b = (a << 3);
System.out.println("Original Number : " + Integer.toBinaryString(a) + " Unsigned Left Shift : " + Integer.toBinaryString(b));
	}
	
	private static void bitwiseSignedRightSift ()
	{
		int a = Integer.valueOf("11110101", 2);
		int b = (a >> 4);
System.out.println("Original Number : " + Integer.toBinaryString(a) + " Unsigned Left Shift : " + Integer.toBinaryString(b));		
	}
	
	private static void bitwiseUnSignedRightSift ()
	{
		int a = Integer.valueOf("11110101", 2);
		int b = (a >>> 2);
System.out.println("Original Number : " + Integer.toBinaryString(a) + " Unsigned Left Shift : " + Integer.toBinaryString(b));		
	}
	
	private static void xorOperator ()
	{
		int a = Integer.valueOf("11110101", 2);
		int b = Integer.valueOf("01110001", 2);
		
		int c = (a ^ b);
System.out.println("ExOr of a and b : " + Integer.toBinaryString(c));		
	}
	
	public static void main(String[] args)
	{
//		printBitWiseNumber ();
		
//		complimentaryOperator ();
		
		bitwiseLeftShift();
		
//		bitwiseSignedRightSift();
		
//		bitwiseUnSignedRightSift ();
		
//		xorOperator();
	}
}
