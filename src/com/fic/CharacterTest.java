package com.fic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brekha
 * http://java.sun.com/developer/JDCTechTips/2001/tt0109.html#using
 */
public class CharacterTest
{
    private static void testCharList ()
    {
        List charList = new ArrayList(3);
        charList.add(new Character('a'));
        charList.add(new Character('b'));
        charList.add(new Character('c'));

        for (int charCounter = charList.size(); --charCounter >= 0;)
        {
System.out.println("each character : " + charList.get(charCounter));            
        }
    }
    
    private static void testIsDefined()
    {
        int digit_count = 0, defined_count = 0;
        for(int counter = 0; counter <= 0xffff; counter++)
        {
            if (Character.isDigit((char)counter))
            {
//System.out.println("each charized : " + ((char)counter));               
                digit_count++;
            }
            if (Character.isDefined((char)counter))
            {
System.out.println("each defined : " + ((char)counter));                
                defined_count ++;
            }            
        }
System.out.println("THE DIGITS COUNT : " + digit_count + "  DEFINED COUNT : " + defined_count);        
    }
    
    private static void upperLower ()
    {
        char cUpper = 'Z';
        char cLower;
        
        //convert to lower case using ASCII 
        cLower = (char)(cUpper + 0x20);
System.out.println("upper " + cUpper);
System.out.println("lower : " + cLower);

		cLower = (char)Character.toUpperCase(cUpper);
System.out.println("\nupper " + cUpper);
System.out.println("lower : " + cLower);

    }
    
    private static void testDigit()
    {
        int digit = Character.digit('Z', 36);
System.out.println("THE DIGIT AFTER CONVERSION : " + digit);
		
		char character = Character.forDigit(digit, 36);
System.out.println("THE CHARACTER : " + character);

		int numericValue = Character.getNumericValue('\u217c');
System.out.println("numeric value : " + numericValue);		

    }
    
    private static void testCurrency ()
    {
        for(int counter = 0; counter <= 0xffff; counter++)
        {
            if (Character.getType((char)counter) == Character.CURRENCY_SYMBOL)
            {
System.out.println("HERE IS THE CURRENCY : " + counter );                
            }
        }
    }
    
    private static void testCategories()
    {
        for (int counter = 0; counter <= 0xffff; counter++)
        {
            if (Character.UnicodeBlock.of((char)counter) == Character.UnicodeBlock.GREEK)
            {
System.out.println("greek character : " + ((char)counter));                
            }
        }
    }
    
    public static void main(String[] args)
    {
        //testCharList();
        //testIsDefined();
        //upperLower();
        //testDigit();
        //testCurrency();
        testCategories();
    }
}
