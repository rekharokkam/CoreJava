package com.interview;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class VMWare
{
	static void junky ()
	{
		
	}
	

	public static int someMethod(String value) throws IOException {
	      Pattern pattern = Pattern.compile("E");
	      Matcher m = pattern.matcher(value);  
	      int count = 0;
	      while(m.find()) {
	         count ++;
	      }
	      return count;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
System.out.println(someMethod("ABCDEEEE"));
		}catch (Exception e)
		{
			
		}

	}

}

class Junky2 extends VMWare
{
	void Junky (){}
}