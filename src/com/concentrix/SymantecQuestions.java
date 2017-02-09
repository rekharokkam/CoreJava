package com.concentrix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymantecQuestions
{
	private final static int FOR_LOOP_METHOD = 1;
	private final static int STRING_BUILDER_APPROACH = 2; 
	
	private static String reverseString (String x, int approach)
	{
		switch (approach)
		{
			case FOR_LOOP_METHOD:
				char[] toBereversedArray = x.toCharArray();
				char[] reverseArray = new char[toBereversedArray.length];
				for (int i = toBereversedArray.length, j = 0; --i >= 0;)
				{
					reverseArray[j++] = toBereversedArray[toBereversedArray.length - j];
				}
				return new String (reverseArray);

			case STRING_BUILDER_APPROACH:
				StringBuilder sb = new StringBuilder(x);
				return sb.reverse().toString();
		}
		return "";
	}
	
	
	private static String reverseSentence (String sentence, int approach)
	{
		String[] allWordsInSentence = sentence.split(" ");
		switch (approach)
		{
			case FOR_LOOP_METHOD:
				String reversedSentenceStr = ""; 
				for (int i = allWordsInSentence.length, j = 0; --i >= 0;)
				{
					reversedSentenceStr = reversedSentenceStr + allWordsInSentence[allWordsInSentence.length - ++j] + " ";
				}
				return reversedSentenceStr;

			case STRING_BUILDER_APPROACH:
				StringBuilder sb = new StringBuilder(allWordsInSentence.length + 100);
				
				for (int i = allWordsInSentence.length, j = 0; --i >= 0;)
				{
					sb.append(allWordsInSentence[allWordsInSentence.length - (++j)]).append(" ");
				}

				return sb.toString();
		}

		return "";		
	}
	
	private static String replaceSomeCharInSentence (String sentence, String toReplace, String toReplaceWith)
	{
		String reversedSentence = reverseSentence (sentence, 2);
		return reversedSentence.replaceAll(toReplace, toReplaceWith);
	}
	
	private static Object[] minimumCommonOccurance (String str1, String str2)
	{
		int str1Length = str1.length();//Length of first String
		int miniCharOccurance = 0;//Minimum number of occurance of a character
		int beginIndex = 0;
		String miniOccuringChar = "";// Character tat appears minimum number of times		
		
		while (str1Length-- >= 1) // this loop makes sure the entire of first string is read
		{
			String eachStr1Char = str1.substring(beginIndex++, beginIndex); // Each character of first string
			Pattern pattern = Pattern.compile(eachStr1Char); //Each character of first string is treated as regular expression
			Matcher matcher = pattern.matcher(str2); // Each character of first string is matched against the entire of second string
			int numberOfOccuranceOfEachCharacter = 0;
			while (matcher.find())
			{
				numberOfOccuranceOfEachCharacter ++;
			}
			
			/*
			 * at the begining minimum occurance is said to be equal to the first character occurance then manipulated
			 */
			if ( (beginIndex == 1) ||
					( (numberOfOccuranceOfEachCharacter != 0) && numberOfOccuranceOfEachCharacter < miniCharOccurance) )
			{
				miniCharOccurance = numberOfOccuranceOfEachCharacter;
				if (miniCharOccurance != 0)
				{
					miniOccuringChar = eachStr1Char;
				}				
			}
		}
		
		
		return new Object[]{miniCharOccurance, miniOccuringChar};
	}
	
	private static int getLastDigit (int number)
	{
		return number % 10;
	}
	
	public static void main(String[] args)
	{
//System.out.println("Reversing the String");		
//System.out.println("--------------------");
//
//		String intialString = "Venkat";
//
//System.out.println("\nReversing String using StringBuilder ");
//		String reversedStringUsingSB = reverseString(intialString, 2);
//System.out.println("Before Reverse : " + intialString + " :: After Reversing : " + reversedStringUsingSB);
//				
//System.out.println("\nReversing String using For Loop ");
//		String reversedStringUsingForLoop = reverseString(intialString, 1);
//System.out.println("Before Reverse : " + intialString + " :: After Reversing : " + reversedStringUsingForLoop);
//		
//		
//System.out.println("\n\nReversing the Sentence");		
//System.out.println("--------------------");
//
//		String intialSentence = "Venkat attended Aarush's party";
//
//System.out.println("\nReversing Sentence using StringBuilder ");
//		String reversedSentenceUsingSB = reverseSentence(intialSentence, 2);
//System.out.println("Before Reverse : " + intialSentence + " :: After Reversing : " + reversedSentenceUsingSB);
//				
//System.out.println("\nReversing Sentence using For Loop ");
//		String reversedSentenceUsingForLoop = reverseSentence(intialSentence, 1);
//System.out.println("Before Reverse : " + intialSentence + " :: After Reversing : " + reversedSentenceUsingForLoop);
//
//System.out.println("\n\nReplacing characters in a sentence");		
//System.out.println("--------------------------------------");
//
//		String replacedSentenceUsingSB = replaceSomeCharInSentence(intialSentence, " ", "_");
//System.out.println("Replaced Sentence : " + replacedSentenceUsingSB);	
//
//System.out.println("\n\nCounting minimum characters occurance in a string");		
//System.out.println("--------------------------------------");

//		String firstString = "aabbbc";
//		String secondString = "xxxaa";
//		Object[] minimumOccurance = minimumCommonOccurance (firstString, secondString);
//System.out.println("Minimum Occuring Character : " + minimumOccurance[1] + " :: Minimum Character occurance count : " + minimumOccurance[0]);
		
System.out.println("\n\nFinding last digit in a number");		
System.out.println("--------------------------------------");
		int number = 21;
System.out.println("Number : " + number + " :: last digit of this number : " + getLastDigit (number));

	}
}
