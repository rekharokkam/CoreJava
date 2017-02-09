/**this class reads from the console
 */
package com.itreya.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ConsoleReader
{
	public static void main (String args[])
	{
		
	
		try
		{
			BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
			System.out.println ("enter only the numers :");
			int i = Integer.parseInt(reader.readLine ());
			if (i % 2 == 0)
			{
				System.out.println ("the given numer is even");				
			}
			else
			{
				System.out.println ("the given numer is odd");
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		
	}
}