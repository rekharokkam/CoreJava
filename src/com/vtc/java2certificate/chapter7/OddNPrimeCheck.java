package com.vtc.java2certificate.chapter7;

public class OddNPrimeCheck
{
	/*
	 * One way of checking for Odd number
	 */
	static boolean isOddWeirdWay (int numberToBeTested)
	{
//System.out.println("binary representhation of given number : " + (Integer.valueOf("0x01", 16)));		
		if ((numberToBeTested & 0x01) == 0)
		{
			return false;
		}
		return true;
	}
	
	/*
	 * Another way of checking for Odd number
	 */
	static boolean isOddMyWay (int numberToBeTested)
	{
		return (( (numberToBeTested % 2 ) == 0) ? false : true); 
	}
	
	static boolean isPrime (int numberToBeTested)
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
	
	public static void main(String[] args)
	{
		int numberToBeTested = 1497;
System.out.println("Number to be tested : " + numberToBeTested);		
System.out.println("Is the given number Odd : " + isOddMyWay (numberToBeTested));
System.out.println("Is the given number Prime : " + isPrime(numberToBeTested));
	}
}
