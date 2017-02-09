package com.interview;

public class Question4
{
	/*
	 * Problem 4
	 * Write a method which given a string returns a string in which each character is separated from the next one by an asterisk. Use recursion in your solution.
	 */
	private static final String ASTERISK = "*"; 
	
	static String getAsteriskAppendedStr (String input, StringBuilder sb )
	{
		if (null != input & !("".equals(input)))
		{
			int startIndex = (sb.length()) / 2;
			int endIndex = (startIndex + 1);
			
			String eachInputCharacter = input.substring(startIndex, endIndex);
			sb.append(eachInputCharacter).append(ASTERISK);
			
			if (endIndex != input.length())
			{
				//recursion
				getAsteriskAppendedStr(input, sb);
			}
			return sb.toString();
		}
		 return "Please Enter valid String";		
	}
	
	public static void main(String[] args)
	{
		/*
		 * Different test cases
		 * 1) All Upper case String
		 * 2) All lower case String
		 * 3) Mix case string
		 * 4) Sending empty string
		 * 5) Sending null string
		 * 6) String with consecutive double characters
		 * 7) Mix of letters and Asterisk
		 * 8) String with all Asterisk
		 */
		
System.out.println("All Upper Case letters : " + getAsteriskAppendedStr("XYZ", new StringBuilder()));
System.out.println("All Lower case letters : " + getAsteriskAppendedStr("xyz", new StringBuilder()));
System.out.println("Mix of Upper case and lower case letters : " + getAsteriskAppendedStr("xYz", new StringBuilder()));
System.out.println("Empty String : " + getAsteriskAppendedStr("", new StringBuilder()));
System.out.println("Null String : " + getAsteriskAppendedStr(null, new StringBuilder()));	
System.out.println("String with consecutive double characters : " + getAsteriskAppendedStr("xxyyz", new StringBuilder()));
System.out.println("Mix of Asterisk and letters : " + getAsteriskAppendedStr("x*y*", new StringBuilder()));
System.out.println("String with all Asterisk : " + getAsteriskAppendedStr("***", new StringBuilder()));
	}
}
