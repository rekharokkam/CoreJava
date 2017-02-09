package com.book.tij.chapter3;

import java.util.Random;

public class Chapter3 
{
	int a;
	private void testRandom ()
	{
		Random random1 = new Random ();
		Random random2 = new Random ();
		
System.out.println("random1 value : " + random1.nextInt(100));		
System.out.println("random2 value : " + random2.nextInt(100));
	}
	
	private void testShortCircuting()
	{
		boolean andCondition = (test1 (0) && test2 (2) && test3 (2));
System.out.println("andCondition :: " + andCondition);

		boolean orCondition = (test1 (0) || test2 (2) || test3 (2));
System.out.println("orCondition :: " + orCondition);		
	}
	
	private boolean test1 (int value)
	{
System.out.println("INSIDE THE FUNC TEST1 :: VALUE : " + (value < 1));
		return (value < 1);
	}
	
	private boolean test2 (int value)
	{
System.out.println("INSIDE THE FUNC TEST2 :: VALUE : " + (value < 2));
		return (value < 2);
	}

	private boolean test3 (int value)
	{
System.out.println("INSIDE THE FUNC TEST3 :: VALUE : " + (value < 3));
		return (value < 3);
	}

	private void testBitwiseOperator ()
	{
System.out.println("bitwise AND : " + (2 & 3));		
System.out.println("bitwise OR : " + (5 | 3));
System.out.println("bitwise XOR : " + (5 ^ 3));
System.out.println("Ones Compliment : " + (~-106));
System.out.println("LEFT SHIFT : " + (1 << 30));
System.out.println("LEFT SHIFT : " + (1 << 31));
System.out.println("SIGNED RIGHT SHIFT : " + (8 >> 3));
System.out.println("UNSIGNED RIGHT SHIFT : " + (8 >>> 10));
	}
	
	private void testBitwiseShortCircuit ()
	{
		boolean bitwiseAnd = (test1 (0) & test2 (2) & test3 (2));
System.out.println("bitwiseAnd : " + bitwiseAnd);
		boolean bitwiseOr = (test1 (0) | test2 (2) | test3 (2));
System.out.println("bitwiseOr : " + bitwiseOr);		
	}
	
	private void printIntInBinary (int number)
	{
		for (int j = 31; j-- > 0; )
//		for (int j = 0; j < 32; j++)
		{
			String condition = ( ((1 << j) & number) != 0) ? "1" : "0";			
System.out.print(condition);
		}
	}
	
	private void testAutoOperation ()
	{
		int i = 10;
System.out.println("THE INITIAL VALUE OF i  : " + i);
		
System.out.println("THE PRE AUTO INCREMENT VALUE : " + (++i));
System.out.println("THE POST AUTO INCREMENT VALUE : " + (i++));

System.out.println("THE AFTER INCREMENT OPERATION VALUE OF i : " + i);

System.out.println("THE PRE AUTO DECREMENT VALUE : " + (--i));
System.out.println("THE POST AUTO DECREMENT VALUE : " + (i--));

System.out.println("THE END VALUE OF i : " + i);
	}
	
	private void stringPlusOperation ()
	{
		int x = 0, y = 1, z = 2;
		String str = " x, y, z :: ";
System.out.println("" + x + y + z + "a");
System.out.println(x + y + str);
	}
	
	private void castOperation()
	{
		int i = 100;
		long l = 100L;
		
System.out.println("Conversion from int to long goes fine :: " + (long)i);		
System.out.println("Conversion from long to int shouldnt be done :: " + (int)l);		
	}
	
	private void testExponential ()
	{
		float f = 1e30f;
System.out.println("EXP OUTPUT :: " + f);
	}
	
	private void testOperatorsPrecedence()
	{
		int x = 2;
		int y = 3;
		
		y = -x;
System.out.println("y : " + y);		
	}
	
	private void testPromotion ()
	{
		char a = 100;
		char b = 100;
		
		char c = (char)(a | b);
		
		int x = 100;
		long y = 200;
		
		int z = (int)(x * y);
	}
	
	private void testBooleanOperations()
	{
		boolean x = true, y = false;
System.out.println("bitwise AND : " + (x & y));		
System.out.println("bitwise OR : " + (x | y));
System.out.println("bitwise XOR : " + (x ^ y));
System.out.println("Logical AND : " + (x && y));
System.out.println("Logical OR : " + (x || y));
	}
	
	private void testCharOperations ()
	{
		char a = 'a';
		char b = 'b';
		
System.out.println("INT EQUIVALENT OF a : " + (int)a);		
System.out.println("INT EQUIVALENT OF a : " + (int)b);	

//		char c = (a + b); // not possible. casting is required
//		char c = (a - b);// not possible. casting is required
//		char c = (a * b);// not possible. casting is required
//		char c = (a / b);// not possible. casting is required
//		char c = (a % b);// not possible. casting is required

		char c = a += b;// compound assignments need no explicit casting

System.out.println("\n\nARITHMETICAL OPERATIONS ");		
System.out.println("ADD : " + (a + b));
System.out.println("SUB : " + (char)(a - b));
System.out.println("MUL : " + (char)(a * b));
System.out.println("DIV : " + (char)(a / b));
System.out.println("MODULUS : " + (char)(a % b));

System.out.println("\n\nSHIFT OPERATIONS ");
System.out.println("LEFT SHIFT : " + (char)(a << 1));
System.out.println("RIGHT SHIFT : " + (char)(a >> 1));
System.out.println("UNSIGNED RIGHT SHIFT : " + (char)(a >>> 1));

System.out.println("\n\nUNARY OPERATIONS ");
System.out.println("UNARY + : " + (char)+a);
System.out.println("UNARY - : "+ (char)-a);
System.out.println("++ : " + (char)++a);
System.out.println("-- : " + (char)--a);

System.out.println("\n\nRELATIONAL OPERATONS ");
System.out.println(">  : " + (a > b));
System.out.println("<  : "+ (a < b));
System.out.println(">= : " + (a >= b));
System.out.println("<= : " + (a <= b));
System.out.println("== : " + (a == b));
System.out.println("!= : " + (a != b));

System.out.println("\n\nLOGICAL AND BITWISE OPERATORS");
//System.out.println("LOGICAL AND (&&): " + (a && b));// !
//System.out.println("LOGICAL OR (||) : " + (a || b)); // !
System.out.println("BITWISE AND (&) : " + (char)(a & b));
System.out.println("BITWISE OR (|) : " + (char)(a | b));
System.out.println("BITWISE XOR (^) : " + (char) (a ^ b));
System.out.println("COMPLIMENTARY  (~) : " + (char)(~a));

System.out.println("\n\nCOMPOUND ASSIGNMENTS");
		a = 'a';
System.out.println(a += b);
		a = 'a';
System.out.println(a -= b);
		a = 'a';
System.out.println(a *= b);
		a = 'a';
System.out.println(a /= b);
		a = 'a';
System.out.println(a %= b);
		a = 'a';
System.out.println(a <<= b);
		a = 'a';
System.out.println(a >>= b);
		a = 'a';
System.out.println(a >>>= b);
		a = 'a';
System.out.println(a |= b);
		a = 'a';
System.out.println(a &= b);
		a = 'a';
System.out.println(a ^= b);
		a = 'a';
		
System.out.println("\n\nCASTING OPERATORS ");

//		boolean c = (boolean)a;
		byte bd = (byte)a;
		short s = (short)a;
		int i = (int)a;
		long l = (long)a;
		float f = (float)a;
		double d = (double)a;
		
System.out.println("BYTE : " + bd);		
System.out.println("SHORT : " + s);
System.out.println("INT : " + i);
System.out.println("LONG : " + l);
System.out.println("FLOAT : " + f);
System.out.println("DOUBLE : " + d);
	}
	
	private void testByteOperations ()
	{
		byte a = 10;
		byte b = 10;
		
//		byte c = (a + b); // not possible. casting is required
//		byte c = (a - b);// not possible. casting is required
//		byte c = (a * b);// not possible. casting is required
//		byte c = (a / b);// not possible. casting is required
//		byte c = (a % b);// not possible. casting is required
		
		byte c = a += b;// compound assignments need no explicit casting
		
System.out.println("\n\nARITHMETICAL OPERATIONS ");		
System.out.println("ADD : " + (byte)(a + b));
System.out.println("SUB : " + (byte)(a - b));
System.out.println("MUL : " + (byte)(a * b));
System.out.println("DIV : " + (byte)(a / b));
System.out.println("MODULUS : " + (byte)(a % b));

System.out.println("\n\nSHIFT OPERATIONS ");
System.out.println("LEFT SHIFT : " + (byte)(a << 1));
System.out.println("RIGHT SHIFT : " + (byte)(a >> 1));
System.out.println("UNSIGNED RIGHT SHIFT : " + (byte)(a >>> 1));

System.out.println("\n\nUNARY OPERATONS ");
System.out.println("UNARY + : " + (byte)+a);
System.out.println("UNARY - : "+ (byte)-a);
System.out.println("++ : " + (byte)++a);
System.out.println("-- : " + (byte)--a);

System.out.println("\n\nRELATIONAL OPERATONS ");
System.out.println(">  : " + (a > b));
System.out.println("<  : "+ (a < b));
System.out.println(">= : " + (a >= b));
System.out.println("<= : " + (a <= b));
System.out.println("== : " + (a == b));
System.out.println("!= : " + (a != b));

System.out.println("\n\nLOGICAL AND BITWISE OPERATORS");
//System.out.println("LOGICAL AND (&&): " + (a && b));// !
//System.out.println("LOGICAL OR (||) : " + (a || b)); // !
System.out.println("BITWISE AND (&) : " + (byte)(a & b));
System.out.println("BITWISE OR (|) : " + (byte)(a | b));
System.out.println("BITWISE XOR (^) : " + (byte)(a ^ b));
System.out.println("COMPLIMENTARY  (~) : " + (byte)(~a));

System.out.println("\n\nCOMPOUND ASSIGNMENTS");
		a = 10;
System.out.println(a += b);
		a = 10;
System.out.println((byte)(a -= b));
		a = 10;
System.out.println((byte)(a *= b));
		a = 10;
System.out.println((byte)(a /= b));
		a = 10;
System.out.println((byte)(a %= b));
		a = 10;
System.out.println((byte)(a <<= b));
		a = 10;
System.out.println((byte)(a >>= b));
		a = 10;
System.out.println((byte) (a >>>= b));
		a = 10;
System.out.println((byte) (a |= b));
		a = 10;
System.out.println((byte) (a &= b));
		a = 10;
System.out.println((byte) (a ^= b));
		a = 10;
		
System.out.println("\n\nCASTING OPERATORS ");

//		boolean c = (boolean)a;
		char ch = (char)a;
		short s = (short)a;
		int i = (int)a;
		long l = (long)a;
		float f = (float)a;
		double d = (double)a;
		
System.out.println("CHAR : " + ch);		
System.out.println("SHORT : " + s);
System.out.println("INT : " + i);
System.out.println("LONG : " + l);
System.out.println("FLOAT : " + f);
System.out.println("DOUBLE : " + d);
	}

	private void testShortOperations ()
	{
		short a = 10;
		short b = 10;
		
//		short c = (a + b); // not possible. casting is required
//		short c = (a - b);// not possible. casting is required
//		short c = (a * b);// not possible. casting is required
//		short c = (a / b);// not possible. casting is required
//		short c = (a % b);// not possible. casting is required
		
		short c = a += b;// compound assignments need no explicit casting
		
System.out.println("\n\nLOGICAL AND BITWISE OPERATORS");
//System.out.println("LOGICAL AND (&&): " + (a && b));// !
//System.out.println("LOGICAL OR (||) : " + (a || b)); // !
System.out.println("BITWISE AND (&) : " + (short)(a & b));
System.out.println("BITWISE OR (|) : " + (short)(a | b));
System.out.println("BITWISE XOR (^) : " + (short)(a ^ b));
System.out.println("COMPLIMENTARY  (~) : " + (short)(~a));

	}

	private void testIntOperations ()
	{
		int a = 10;
		int b = 10;
System.out.println("\n\nLOGICAL AND BITWISE OPERATORS");
//System.out.println("LOGICAL AND (&&): " + (a && b));// !
//System.out.println("LOGICAL OR (||) : " + (a || b)); // !
System.out.println("BITWISE AND (&) : " + (int)(a & b));
System.out.println("BITWISE OR (|) : " + (int)(a | b));
System.out.println("BITWISE XOR (^) : " + (int)(a ^ b));
System.out.println("COMPLIMENTARY  (~) : " + (int)(~a));

System.out.println("\n\nCASTING OPERATORS ");

		a = 200000000;
		//boolean c = (boolean)a;
		char c = (char)a;
		short s = (short)a;		
		long l = (long)a;
		float f = (float)a;
		double d = (double)a;

System.out.println("CHAR : " + c);		
System.out.println("SHORT : " + s);
System.out.println("LONG : " + l);
System.out.println("FLOAT : " + f);
System.out.println("DOUBLE : " + d);
	}
	
	private void testIntOverflow ()
	{
		int a = 2147483647;
		int b = 4;
		
		int c = a * b;
System.out.println("result of (a + b) : " + c);		
	}
	
	private void testForLoop()
	{
		int maxDots = 4;
		for (int i = 0; i < maxDots; i++) 
		{
			for(int k = i; k > 0; k --)
			{
System.out.print(" ");				
			}
			for (int j = i;j < maxDots ; j++) 
			{
System.out.print(".  ");				
			}	
System.out.println("\n");			
		}
	}
	
	private void testLable()
	{
		int j = 1;
		outer:
			for (int i = 0; i < 3; i++)
			{
				inner:
					for (; j < 10; j++)
					{
						if ((j% 9) == 0)
						{
							break outer;
						}
						
						if ((j % 6) == 0)
						{
							j++;
							continue outer;
						}
						
						if ((j % 7) == 0)
						{
							continue;
						}
						if ((j % 5) == 0)
						{
							j++;
							break;
						}
System.out.println("INNER LOOP : " + j);						
					}
		
System.out.println("OUT OF INNER LOOP");				
			}
		
System.out.println("OUT OF OUTER LOOP");		
	}
	
	private void testStringConcatenation()
	{
System.out.println("First Int String next :: " + (3 + 4 + "s"));
System.out.println("First String Int next :: " + ("s" + 3 + 4));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Chapter3().testOperatorsPrecedence();
	}
}
