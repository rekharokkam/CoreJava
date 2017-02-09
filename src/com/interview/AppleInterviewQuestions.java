package com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Find all values in an array, which are not present in another array.
for example
array1 = [a,b,c,d,e,f,g,s,t]
array2 = [a,b,b,d,f,g,s,z]
 
Write a function in Java that will return the char array of values present in the first, and not the second.  In this example that would be   [c,e,t,z]
*/

public class AppleInterviewQuestions
{
	private static final String SENTENCE_END_CHAR = ".";
	
	private static char[] findValuesPresentInFirstArray (char[] firstArr, char[] secondArr)
	{
		String firstArrayString = new String (firstArr);
		for(char eachSecondCharArrElement : secondArr)
		{
			Pattern pattern = Pattern.compile(new String(new char[] {eachSecondCharArrElement}));
			Matcher matcher = pattern.matcher(firstArrayString);
			if (matcher.find())
			{
				firstArrayString = matcher.replaceAll("");
			}	
		}
		return firstArrayString.toCharArray();
	}
	
	/*
	    Given an array of ints, return a new array of ints. In the returned array, the value in position n represents
	    the product of all the array elements except for the array value at position n. So for a three element input
	    array i, the output o should be as follows: o[0] = i[1] * i[2], o[1] = i[0] * i[2], o[2] = i[0] * i[1].
	
	    Example:
	    input: [1, 2, 3]     output: [6, 3, 2]
	    input: [6, 9, 2, 6]  output: [108, 72, 324, 108]
    */
	
	public int[] productOfOtherPositions(int[] input)
	{
		int[] resultArr = new int[input.length];
		for (int i = 0; i < input.length; i ++)
		{
			int arrElementsProduct = 1;
			
			for (int j = 0; j < input.length; j ++)
			{
				if (i == j) 
				{
					resultArr [i] = input[j];
					continue;
				}
				
				arrElementsProduct *= input[j];
			}
			resultArr[i] = arrElementsProduct;			
		}
		
		return resultArr;
	}

    /*
    A method that will reverse the words in a sentence.

    Example:
    input: The dog runs REALLY fast.
    output: fast REALLY runs dog The.
    */
	
	public String reverseWordsInSentence(String input)
	{
		if (input.substring(input.length() - 1, input.length()).equals(SENTENCE_END_CHAR))
		{
			input = input.replace(SENTENCE_END_CHAR, "");
		}
		String[] inputArr = input.split(" ");
		List<String> inputStrArr = Arrays.asList(inputArr);
		Collections.reverse(inputStrArr);
		StringBuilder sb = new StringBuilder (1000);
		for (String eachReversedWord : inputStrArr)
		{
			if (!"".equals(sb.toString()))
			{
				sb.append(" ");
			}
			sb.append(eachReversedWord);
		}
		sb.append(SENTENCE_END_CHAR);
		return sb.toString();
	}


	public static void main(String[] args)
	{
//		char[] result = findValuesPresentInFirstArray (firstArray, secondArray);
		
//		int[] productArr = new AppleInterviewQuestions().productOfOtherPositions(new int[] {6, 9, 2, 6});
		
		new AppleInterviewQuestions().reverseWordsInSentence("The dog runs REALLY fast.");
System.out.println("");		
	}
}
