/**This is for testing the File and it's proeprties.
 * All the errors are written into the Error.log and all the System.outs into Output.log
 * Flies
 */

package com.itreya.test1;

import java.io.*;

class FileTest
{
	
	/*	
	void errorAndOutput()
	{
		System.out.println("with in the function");
		try
		{
			int c = 45/0;
		}
		catch(ArithmeticException ae)
		{
			ae.printStackTrace();
		}
	}
	*/
	
	void createTempFileTest () throws IOException
	{
		File file = File.createTempFile("rekha", ".txt");
	}
	
	public static void main (String args[])
	{
		
		/*
		String parentPathName = "d:/Testing/JavaTesting";
		String errorFileName = System.getProperty("ERRORFILENAME");
		String outputFileName = System.getProperty("OUTPUTFILENAME");
		
		File fileError = new File(parentPathName,errorFileName);
		File fileOutput = new File(parentPathName,outputFileName);
		
		try
		{
			if (!(fileError.exists()))
			{
				fileError.createNewFile();
			}
			if (!(fileOutput.exists()))
			{
				fileOutput.createNewFile();
			}
			System.setErr(new PrintStream(new FileOutputStream(fileError)));
			System.setOut(new PrintStream(new FileOutputStream(fileOutput)));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	
		FileTest test = new FileTest();
		test.errorAndOutput();
		*/
		
		
		//File file = new File ("e:/justChecking");
		//file.mkdir ();
		
		//System.out.println ("pathseperator = " + File.pathSeparator + "  seperator = " + File.separator);
		
		/*
		*to know the difference between the different constructors of FIle class
		*/
		
		
		File file = new File ("e:\\rekha");	
		File f = new File (file, "jad");
		
		System.out.println ("the child is " + f.toString  ());
		
		FileTest test = new FileTest ();
		try
		{
			test.createTempFileTest();	
		}
		catch (IOException eIO)
		{
			System.out.println ("There is an IOError during the temporary file creation");	
			eIO.printStackTrace();
		}
	}
}