/**This class is in association with the JDC Tech tips regarding the features of Number Format Exception
 * http://developer.java.sun.com/developer/JDCTechTips/2002/tt0723.html#tip1
 */

package com.itreya.test;

import java.io.*;
import java.text.*;
import java.util.Locale;

public class NumberFormatTest
{

	
	public static void main(String[] args)
	{
		BufferedReader reader = null;
		try
		{
		
			reader = new BufferedReader(new InputStreamReader (System.in));
			System.out.print ("Please enter a double value :  ");			
			String input = reader.readLine();
			
			if (null != input)
			{
				try
				{
					//double dou = Double.parseDouble(input) ;
					//System.out.println ("The requested double value is " + dou);
					NumberFormat format = NumberFormat.getNumberInstance();
					Number number = format.parse(input);
					
					
					System.out.println ("The required double value is " + number.doubleValue());
					/*
					System.out.print ("Enter the custom format : ");
					String formattingType = reader.readLine();
					
					if (null != formattingType)
					{
						NumberFormat outputFormat = new DecimalFormat (formattingType);
						System.out.println ("The desired format is " + outputFormat.format(number));
					}
					
					
					System.out.print ("Please enter the currency value : " );
					
					String strCurrency = reader.readLine() ;
					
					NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
					Number numberCurrency = currency.parse(strCurrency);
					System.out.println ("The formatted currency is " + currency.format(numberCurrency));
					*/
					
				}
				
				/*
				catch (NumberFormatException eNumberFormatException)
				{
					System.err.println("Bad Double Input : " + input);
				}
				*/
				
				catch (ParseException eParseException)
				{
					System.out.println ("There was an error during the parsing process");
					eParseException.printStackTrace();
				}
			}
			
			System.out.print ("\nPlease enter the Hex Number :  ");
			String hexNumber = reader.readLine();
			
			if (null != hexNumber)
			{
				try
				{
					long l = Long.parseLong(hexNumber, 36);
					System.out.println ("The desired hexanumber is " + l);
				}
				catch (NumberFormatException eNum)
				{
					System.err.println("Bad Hex Input : " + hexNumber);
				}
				
			}
			
			
			
		}
		catch (IOException eIO)
		{
			System.out.println ("There was an IOException duirng reading from Console");
			eIO.printStackTrace() ;
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
					System.out.println ("There was an IO EXception during the closing of the input stream");
					eIO.printStackTrace();
				}
			}
		}	
		
	}
}
