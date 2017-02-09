/**This class is for testing the String properties
 * This class has a method which takes a string in the form 3,496,123.00
 * and returns the result in the form 3496123.00
 */


package com.itreya.test;

import java.io.StringWriter;
import java.util.StringTokenizer;

class StringTest
{
	public String stringConversion(String strUnFormatted)
	{
		System.out.println("\n the string strUnFormatted is "+strUnFormatted+"\n");	
		String strFormatted = "";
		char charUnformatted[] = new char[strUnFormatted.length()];
		charUnformatted = strUnFormatted.toCharArray();
		String strFor = "";
		int indexArr[] = new int[10];
		int iCount = 0;
		for(int i = 0;i<strUnFormatted.length();i++)
		{
			if (charUnformatted[i]==',')
			{
				indexArr[iCount] = i;
				iCount++;
				continue;
			}			
		}			
		//System.out.println("\nthe length of the special characters is\t"+iCount);
		char charNew[] = new char[strUnFormatted.length()-iCount];
		int a = 0;
		for (int j=0;j<strUnFormatted.length();j++)
		{
			if (charUnformatted[j]==',')
			{
				continue;
			}
			charNew[a] = charUnformatted[j];
			a++;
		}
		strFor = new String(charNew);
		//System.out.println("\nthe formatted String is "+strFor);
		return strFor;
		
	}
	
	public void stringWriterWrite()
	{
		StringWriter strWriter = new StringWriter();
		strWriter.write(stringConversion("3,49,6,1,23.00"));
		System.out.println("\nThe string writer is\t"+strWriter.toString());
	}
	
	/**Another approach to the same problem would be to Use StringTokenizer
	 */
	
	public void usingStringTokenizer(String strToBeFormatted)
	{
		System.out.print("\nthe string passed is\t"+strToBeFormatted+"\n");
		StringTokenizer st = new StringTokenizer(strToBeFormatted,",");
		String strFormatted = "";
		while(st.hasMoreElements())
		{
			strFormatted = strFormatted + st.nextToken();
		}
		System.out.println("\nthe formatted String is "+strFormatted+"\n");
		
	}
	
	public static void main (String args[])
	{
		StringTest st = new StringTest();
		//st.stringConversion("3,49,6,1,23.00");		
		//st.usingStringTokenizer("3,49,6,1,23.00");
		
		String strYear = "1001991";
		System.out.println("\nthe length of the string is "+strYear.length()+"\n");
		System.out.println("\n"+(strYear.substring(strYear.length()-4))+"\n");
	}
}