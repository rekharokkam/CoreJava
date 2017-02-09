package com.vtc.java2certificate.chapter7;

public class InnerClassTest
{
	boolean isOddNPrimeUsingInnerClass (int numberToBeTested)
	{
		InnerNonMethodClass innerClassInstance = new InnerNonMethodClass();
		return (innerClassInstance.isOdd(numberToBeTested) && innerClassInstance.isPrime(numberToBeTested));
	}
	
	boolean isOddNPrimeUsingMethodInnerClass (int numberToBeTested)
	{
		class MethodInnerClass
		{
			boolean isOdd (int numberToBeTested)
			{
				return (( (numberToBeTested % 2 ) == 0) ? false : true); 
			}
			
			boolean isPrime (int numberToBeTested)
			{
				for (int i = 2; i < (numberToBeTested / 2); i ++)
				{
					if ( (numberToBeTested % i ) == 0)
					{
						return false;
					}
				}
				return true;
			}
		}
		
		MethodInnerClass methodInnerClass = new MethodInnerClass ();
		return (methodInnerClass.isOdd(numberToBeTested) && methodInnerClass.isPrime(numberToBeTested));
	}
	
	public static void main(String[] args)
	{
		int numberToBeTested = 19;
System.out.println("Number to be tested : " + numberToBeTested);		
System.out.println("Is the number prime and Odd using isOddNPrimeUsingInnerClass() : " + (new InnerClassTest().isOddNPrimeUsingInnerClass(numberToBeTested)));	 
System.out.println("Is the number prime and Odd using isOddNPrimeUsingMethodInnerClass() : " + (new InnerClassTest().isOddNPrimeUsingMethodInnerClass(numberToBeTested)));
	}
	
	private static class InnerNonMethodClass
	{
		boolean isOdd (int numberToBeTested)
		{
			return (( (numberToBeTested % 2 ) == 0) ? false : true); 
		}
		
		boolean isPrime (int numberToBeTested)
		{
			for (int i = 2; i < (numberToBeTested / 2); i ++)
			{
				if ( (numberToBeTested % i ) == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
}
