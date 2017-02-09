/**this class shows how creating a new string improves the performance 
 * over reading form a char array
 */

package com.itreya.learn;

class StringCharTest
{
	String addSpaces (int a_iLength, int a_iArgs)
	{
		if (a_iArgs == 0)
		{
			char charArr [] = new char [a_iLength];
			for (int i = a_iLength; --i >= 0;)
			{
				charArr [i] = ' ';
			}
			return (String.valueOf (charArr));
		}
		
		else if (a_iArgs == 1)
		{
			String strSpaces = "          ";
			if (a_iLength < strSpaces.length ())
			{
				return (strSpaces.substring (0, a_iLength));
			}
			else
			{
				return (strSpaces.substring (0, strSpaces.length ()));
			}
		}
		
		else
		{
			//do nothing 
			return " " ;
		}
	}
	
	public static void main (String args [])
	{
		StringCharTest test = new StringCharTest ();
		
		long firstCharArrConversion = System.currentTimeMillis ();				
		for (int i = 10000; --i >= 0;)
		{
			test.addSpaces (i, 0);
		}		
		System.out.println ("\nThe time taken for the first method is " + (System.currentTimeMillis () - firstCharArrConversion));
		
	
		long secondSubString = System.currentTimeMillis ();				
		for (int i = 10000; --i >= 0;)
		{
			test.addSpaces (i, 1);
		}		
		System.out.println ("\nThe time taken for the second method is " + (System.currentTimeMillis () - secondSubString));
		
	}
}