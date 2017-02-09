package com.vtc.java2certificate.chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Buffering
{
	void readFileUsingBuffer ()
	{
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try
		{
			//When ever a fileReader/Writer Object is created File is automatically opened for reading/Writing.
			FileReader fileReader = new FileReader ("C:/Rekha/Testing_Workspace/CoreJava/xml/trinad.xml");			
			FileWriter fileWriter = new FileWriter ("C:/Rekha/Testing_Workspace/CoreJava/xml/trinad1.xml");
			
			bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//Use PrintWriter instead of FileWriter as it has better methods
			printWriter = new PrintWriter (bufferedWriter);
			
			String line = null;
			while (null != (line = bufferedReader.readLine()))
			{
				printWriter.println(line);
			}
			
		}
		catch (FileNotFoundException fileNotFoundException)
		{
fileNotFoundException.printStackTrace(System.err);			
		}
		catch (IOException ioException)
		{
ioException.printStackTrace(System.err);			
		}
		finally
		{
			try
			{
				/*
				 * Closing the buffered reader/writer closes all the underlying chain of File streams and also flushes the output to files.
				 * Only way to re-open is to create new Objects again. 
				 */
				if (null != bufferedReader)
				{
					bufferedReader.close();
				}
				if (null != printWriter)
				{
					printWriter.close();
				}
			}
			catch (IOException ioException)
			{
				//do nothing
			}
		}
	}	
	
	public static void main(String[] args)
	{
		new Buffering().readFileUsingBuffer();
	}
}
