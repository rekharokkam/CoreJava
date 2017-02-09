package com.fic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author brekha
 */
public class CSVTest
{

    private void writeToFile (String fileName)
    {
        try 
        {
            BufferedWriter bfWriter = new BufferedWriter(new FileWriter (getFileForName(fileName)));
            bfWriter.write("itreya");
            bfWriter.write(",");
            bfWriter.write("zapapp");
            bfWriter.write(",");
            bfWriter.write("fic");
            bfWriter.write("\n");
            bfWriter.write("itreya");
            bfWriter.write(",");
            bfWriter.write("zapapp");
            bfWriter.write(",");
            bfWriter.write("fic");
            
            
            bfWriter.flush();
        } 
        catch (IOException eIOException) 
        {
System.err.println("THERE WAS AN IO EXCEPTION");
			eIOException.printStackTrace(System.err);
        }
    }
    
    private File getFileForName (String fileName)
    {
        return new File (fileName);        
    }
    
    public static void main(String[] args)
    {
        new CSVTest().writeToFile("test.csv");
    }
}
