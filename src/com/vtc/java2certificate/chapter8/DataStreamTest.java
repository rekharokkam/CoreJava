package com.vtc.java2certificate.chapter8;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest
{
	void readData()
	{
		
	}
	
	void writeData (File outFile)
	{
		DataOutputStream dataOutStream = null;
		try
		{
			FileOutputStream fileOutStream = new FileOutputStream(outFile);
			dataOutStream = new DataOutputStream(fileOutStream);
			dataOutStream.writeBoolean(true);
			dataOutStream.writeChar('X');
			dataOutStream.writeInt(123);
			dataOutStream.writeDouble(12.34);
			dataOutStream.writeUTF("ABCD");			
		}
		catch (IOException ioException)
		{
ioException.printStackTrace(System.err);			
		}
		finally
		{
			if (null != dataOutStream)
			{
				try
				{
					dataOutStream.close();
				}
				catch (Exception exception)
				{
exception.printStackTrace(System.err);					
				}
			}
		}		
	}
	
	public static void main(String[] args)
	{
	}
}
