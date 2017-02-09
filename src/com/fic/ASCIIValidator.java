/*
 * Created on Oct 25, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Roopa Murthy
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ASCIIValidator
{
    private void readTextFile (String filePath)
    	throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String eachLine = null;
        while (null != (eachLine = reader.readLine()))
        {
System.out.println("each line : " + eachLine);
			validateEachLine(eachLine);
        }
    }
    
    private boolean validateEachLine (String eachLine)
    {
        byte[] eachLineContents = new byte[eachLine.getBytes().length];
        eachLineContents = eachLine.getBytes();
        
        for (int i = 0; i < eachLineContents.length; i++) 
        {
System.out.println(eachLineContents[i]);            
        } 
        
        return true;
    }
    
    public static void main(String[] args)
    {
        ASCIIValidator validator = new ASCIIValidator();
        try
        {
            validator.readTextFile("D:/Testing/JavaTesting/plainText/junky.doc");
        }
        catch (FileNotFoundException eFileNotFoundException)
        {
eFileNotFoundException.printStackTrace(System.err);            
        }
        catch (IOException eIOException)
        {
eIOException.printStackTrace(System.err);            
        }
        
    }
}
