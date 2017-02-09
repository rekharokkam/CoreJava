/** this class looks into some of the input details of standard input class
 */

package com.itreya.test1;

import java.io.IOException;

class StandardInputTest
{
	void testInput () throws IOException
	{
		System.out.println ("Enter the text here :");
		int eachChar;		
		while ((eachChar = System.in.read ()) != '\n')
		{
			System.out.print ( (char) eachChar);
		}
		
	}
	
	public static void main (String args [])
	{
		StandardInputTest test = new StandardInputTest ();
		try
		{
			test.testInput ();
		}
		catch (IOException eIOE)
		{
			System.out.println ("ERROR DUE TO IO");
		}
	}
		
}