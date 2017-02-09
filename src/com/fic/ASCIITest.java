/*
 * Created on Nov 24, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fic;

/**
 * @author brekha
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ASCIITest
{

    public static void main(String[] args)
    {
        int aChar = 'ÿ';
        char charchar = 'ÿ';
System.out.println("INT : " + aChar + ", CHAR : " + charchar);
		
System.out.println("UNICODE REP : " + Character.getNumericValue('ÿ'));		
    }
}
