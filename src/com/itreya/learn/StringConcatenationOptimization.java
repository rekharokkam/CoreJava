/**This class shows the difference between the different ways of appending to a string
 * and the best of them. There are three ways 
 * 1. Through the concatenate method of string class
 * 2. Through the use of the operator "+"
 * 3. Through the use of String buffer's append 
 */

package com.itreya.learn;

class StringConcatenationOptimization
{
	void stringConcatenation ()
	{
		String strToBeConcatenated = "";
		long start = System.currentTimeMillis ();
		for (int i = 3000; --i >= 0;)
		{
			strToBeConcatenated = strToBeConcatenated.concat (Integer.toString (i));
		}
		long end = System.currentTimeMillis ();
		System.out.println ("\nThe amount of time taken for Concatenating String is " + (end - start));
	}
	
	void stringAdding ()
	{
		String strToBeAdded = "";
		long start = System.currentTimeMillis ();
		for (int i = 3000; --i >= 0;)
		{
			strToBeAdded = strToBeAdded.concat (Integer.toString (i));
		}
		long end = System.currentTimeMillis ();
		System.out.println ("\nThe amount of time taken for Adding String is " + (end - start));
	}
	
	void stringAppending ()
	{
		StringBuffer strToBeAppended = new StringBuffer("");			
		long start = System.currentTimeMillis ();
		for (int i = 3000; --i >= 0;)
		{
			strToBeAppended = strToBeAppended.append (Integer.toString (i));
		}
		long end = System.currentTimeMillis ();
		System.out.println ("\nThe amount of time taken for Appending to String Buffer is " + (end - start));
	}
	
	public static void main (String args [])
	{
		System.out.println ("This println statement is only for testing the ant build");
		StringConcatenationOptimization test = new StringConcatenationOptimization ();	
		test.stringAdding();
		test.stringAppending();
		test.stringConcatenation();
	}
}