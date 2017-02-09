/**This class looks into some of the features of the resource bundle
 */
package com.itreya.test;

import java.text.MessageFormat;

public class ResourceBundleTest
{
	public static final String FILENOTFOUND = "File not found {0} here in the class {1}";
	private static String formatMessage (String a_strMessage, Object[] argsArr)
	{
		MessageFormat mf = new MessageFormat(a_strMessage);
		Object args1[] = new Object[argsArr.length];
		for (int i = 0; i < args1.length; i ++)
		{
			args1[i] = argsArr[i];
			System.out.println ("The required is " + args1[i]);
		}		
		return mf.format(args1);
	}
	
	public static void main (String args[])
	{
		Object argsArrTest[] = new Object[2];
		argsArrTest[0] = "1111";
		argsArrTest[1] = "2222";
		System.out.println (formatMessage(FILENOTFOUND, argsArrTest));
	}
}