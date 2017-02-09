/**this class unloads files from a jar file
 * refernece: http://www.devx.com/free/tips/tipview.asp?content_id=2303&Java=ON
 * This class assumes tat there is already a jar file.
 */

package com.itreya.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import java.util.Enumeration;

class LoadImages
{
	private String m_strJarFile;
	private String m_strOutputPath;
	
	LoadImages (String a_strJarFile, String a_strOutputPath)
	{
		m_strJarFile = a_strJarFile;
		m_strOutputPath = a_strOutputPath;
	}
	
	boolean unJar ()
	{
		boolean isDone = false;
		ZipInputStream in = null;
		ZipFile file = null;
		ZipEntry eachEntry = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;

		
		try
		{
			file = new ZipFile (m_strJarFile);
			Enumeration enum1 = file.entries ();			
			in = new ZipInputStream (new BufferedInputStream (new FileInputStream (m_strJarFile)));
			
			while (enum1.hasMoreElements())
			{
				eachEntry = (ZipEntry)enum1.nextElement ();				
				String strEachEntryName = eachEntry.getName ();												
				try
				{
					File files = new File(m_strOutputPath + "\\" + directoryPath (strEachEntryName));
					if (!files.exists ())
					{
						files.mkdirs ();
					}
					
					inputStream = file.getInputStream (eachEntry);
					
					outputStream = new BufferedOutputStream (new FileOutputStream(m_strOutputPath + "\\" + strEachEntryName));
					
					int iEachChar = -1;
					
					while (-1 != (iEachChar = inputStream.read()))
					{
						outputStream.write (iEachChar);
					}
					
					isDone = true;
				}
				
				catch (Exception eIOEX)
				{
					System.out.println ("There was an exception during writing to the output");
					eIOEX.printStackTrace ();
				}
				
				
				finally
				{
					if ((null != outputStream)&& (null != inputStream))
					{
						try
						{
							outputStream.close ();
							inputStream.close ();
						}
						catch (IOException eIO)
						{
							System.out.println ("There was an IO Exception duirng the closing of Output stream");
							eIO.printStackTrace ();
						}
					}
				}
				
			}				
		}
		
		catch (FileNotFoundException eFileNotFound)
		{
			System.out.println ("The jar file specified does not exist");
			eFileNotFound.printStackTrace ();
		}
			
			
		catch (ZipException eZIPEx)
		{
			System.out.println ("ZipException during ZipFile Formation");
			eZIPEx.printStackTrace ();
		}
		
		catch (IOException eIO)
		{
			System.out.println ("There was an IOException");
			eIO.printStackTrace ();
		}
		
		finally
		{
			if (null != in)
			{
				try
				{
					in.close ();
				}
				catch (IOException eIO)
				{
					System.out.println ("there was an exception during the closing of zipInPut Stream");
					eIO.printStackTrace ();
				}
			}
		}		
		return isDone;
	}
	
	//this method returns the required path like
	//
	private String directoryPath (String a_strZipFilepath)
	{
		
		String strFilePath = null;
		int iIndex = -1;
		iIndex = a_strZipFilepath.lastIndexOf ("/");	
		strFilePath = a_strZipFilepath.substring (0,iIndex);		
		return strFilePath;
		
	}
	
	public static void main (String args [])
	{
		LoadImages test = new LoadImages ("d:\\Testing\\JavaTesting\\src\\test.jar", "e:\\OutputZIP");		
		System.out.println (test.unJar ());
	}
}