/**This class demonstarates the class break iterator
 * Which can be used in place os String tokenizer which slows down the performance
 * 
 * 
 * In order to see the verbose on the output during interpretation type
 * java -verbose:class com.itreya.test1.BreakIteratorTest
 * For javac
 * javac -verbose com.itreya.test1.BreakIteratorTest.java
 */


package com.itreya.test1;

import java.text.BreakIterator;

class BreakIteratorTest
{
	public static void main(String args[])
	{
		String strTest = "This line is to be split based on certain criteria";
		BreakIterator wordIterator = BreakIterator.getWordInstance();
		wordIterator.setText(strTest);
		int start = wordIterator.first();
		System.out.println("start = "+start);
		
		int end = wordIterator.next();
		System.out.println("end = "+end);
		while(-1!=end)
		{
			String word = strTest.substring(start,end);
			System.out.println("the length of the word is "+word.length());
			//if (Character.isLetterOrDigit(word.charAt(0)))
			//{
				//System.out.println(word);
			//}
			start = end;
			end = wordIterator.next();
			
			System.out.println("start = "+start);
			System.out.println("end = "+end);
			
		}
		
	}
	
}