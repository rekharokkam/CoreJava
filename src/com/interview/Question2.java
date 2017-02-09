package com.interview;

public class Question2
{
	/*
	 * Problem 2
     * Write a method which given a string, returns a string where every character in the original is doubled. For example, given the string "xyz", return the string "xxyyzz".
	 */	
	
	static String getEachCharacterDoubledStr (String input)
	{
		if (null != input)
		{
			char[] inputCharArr = input.toCharArray();
			if (inputCharArr.length > 0)
			{
				StringBuilder sb = new StringBuilder();
				for(char eachChar : inputCharArr)
				{
					sb.append(eachChar).append(eachChar);
				}
				return sb.toString();
			}
		}
		return "Please Enter valid String";
	}

	public static void main(String[] args)
	{
		/*
		 * Different test cases
		 * 1) Sending Uppercase string
		 * 2) Sending lower case String
		 * 3) Mix case string
		 * 4) Sending empty string
		 * 5) Sending null string
		 * 6) String with consecutive double characters
		 */
System.out.println("All Upper Case letters : " + getEachCharacterDoubledStr("XYZ"));
System.out.println("All Lower case letters : " + getEachCharacterDoubledStr("xyz"));
System.out.println("Mix of Upper case and lower case letters : " + getEachCharacterDoubledStr("xyZ"));
System.out.println("Sending Empty String : " + getEachCharacterDoubledStr(""));
System.out.println("Sending null String : " + getEachCharacterDoubledStr(null));	
System.out.println("String with consecutive double characters : " + getEachCharacterDoubledStr("xxyyz"));
	}
}
