/**This class examines some of the methods of the class ParsePosition foundin the package
 * java.text;
 * http://developer.java.sun.com/developer/JDCTechTips/2002/tt0723.html#tip1
 */

package com.itreya.test;

import java.text.*;
import java.io.*;

public class ParsePositionTest
{

	public static void main(String[] args)
	{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("PLease enter the values with some special characters For example : ");
			System.out.println("1e54,456/3E4 8");

			String strNumber = reader.readLine();

			NumberFormat format = NumberFormat.getNumberInstance();
			ParsePosition position = new ParsePosition(0);
			int iBeginIndex = -1;
			int iEndIndex = -1;

			if (null != strNumber)
			{
				while (strNumber.length() > (iBeginIndex = position.getIndex()))
				{
					System.out.println("begin index is " + iBeginIndex);
					Number number = format.parse(strNumber, position);
					System.out.println("each parsed value is " + number.doubleValue());					
					iEndIndex = position.getIndex();
					System.out.println("End index is " + iEndIndex);

					if (iBeginIndex == iEndIndex)
					{
						System.err.println("Error in parsing " + iEndIndex);
					}
					else
					{
						position.setIndex(iEndIndex + 1);
					}
				}

			}

		}

		catch (IOException eIO)
		{
			System.out.println("There was an IOException during the reading of the input from the console");
			eIO.printStackTrace();
		}

		finally
		{
			if (null != reader)
			{
				try
				{
					reader.close();
				}
				catch (IOException eIO)
				{
					System.out.println("There was an IO EXception during the closing of the input stream");
					eIO.printStackTrace();
				}
			}
		}
	}
}
