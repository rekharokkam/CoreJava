package com.itreya.test2;

public class StringReplace
{
	
	private static String replace (String a_toBeReplaced, String a_oldStr, String a_newStr)
	{
		int startIndex = 0;
		int from = 0;
		int to = 0;
		int index = a_toBeReplaced.indexOf(a_oldStr);
		
		//At least the old string should be present once
		if (-1 != index)
		{
			
			while (true)
			{
				
				if ((-1 == index) || (to == a_toBeReplaced.length()))
				{
					break;
				}
				
				from = index;
				to = from + a_oldStr.length();
				
				StringBuffer toBeReplaced = new StringBuffer(a_toBeReplaced);
				toBeReplaced.replace(from, to, a_newStr);
				
				a_toBeReplaced = toBeReplaced.toString();
				startIndex = to;
				
				index = a_toBeReplaced.indexOf(a_oldStr);
				
			}			
		}	
		
		return a_toBeReplaced;
	}
	
	public static void main (String args[])
	{
		String parameter = "this is to test &#8482; the replace&#8482; function";
		System.out.println (replace(parameter, "&#8482;", "000000000"));
	}
}
