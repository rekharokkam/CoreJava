/**this class zips the files under the given folder includes all it's subfolder
 */

package com.itreya.learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

class ZippingTest
{
	
	private static File [] getFiles (String a_strPath) throws Exception
	{
		if (null != a_strPath)
		{
			File file = new  File (a_strPath);
			
			//System.out.println ("EACH FILE NAME " + file.getName ());
			//System.out.println ("THE RETURNED BOOLEAN IS " + file.exists ());
			
			if (file.exists ())
			{
				File files [] = null;
				if (file.isDirectory ())
				{
					files  = file.listFiles ();					
				}
				else
				{					
					files = new File[1];
					files [0] = file;					
				}
				return files;
			}			
			else
			{
				//System.out.println ("INside the FILE NOt Found exceptions block");
				throw new FileNotFoundException ("the specified file was not found");
			}
		}
		
		else
		{
			throw new Exception ("The argument passed was null");
		}
	}
	
	private void zipTheFiles (String a_strFileName, ZipOutputStream output)
	{
		try
		{
			File files [] = getFiles (a_strFileName);
			int iNumberOfFiles = files.length;
			
			//System.out.println ("The length of the array is " + iNumberOfFiles);
			
			if (iNumberOfFiles != 0)
			{
				for (int i = iNumberOfFiles; --i >= 0;)
				{	
					//System.out.println ("Inside the for loop " + files[i].getName () );
					
					if (files [i].isDirectory ())
					{
						//System.out.println ("it's the directory  " + files[i].getName ());
						//System.out.println ("1111111111  " + files[i].getPath  ());
						zipTheFiles (files[i].getAbsolutePath (),output);
						
					}
					else
					{
						
						ZipEntry eachEntry = new ZipEntry (zipPath(files[i].getAbsolutePath ()));
						//File f = new File ("d:/Output");
						String strOutput = "d:/Output/" + eachEntry.getName ();
						//File f1 = new File ("d:/Output", eachEntry.getName ());
						File f1 = new File (strOutput);
						
						System.out.println ("\nThe Zip Entry name is " + eachEntry.getName ());
						System.out.println ("The File name is  " + f1.getName ());						
						System.out.println ("THE required path is " + f1.getParent ());
						
						//System.out.println (files[i].getAbsolutePath ());
						output.putNextEntry (eachEntry);
					}					
				}
			}
			else
			{
				//System.out.println ("THE OUT PUT DIRECTORY DIDN'T HAVE ANY FILES AT ALL");
			}
			
		}
		catch (IOException e)
		{
			//System.out.println ("in the IOException block");
			e.printStackTrace ();
		}
		
		catch (Exception ex)
		{
			//System.out.println ("In the exception block");
			ex.printStackTrace ();
		}
		
		
		
	}
	
	void zipDirectory (String a_strDirectory)
	{
		if (null != a_strDirectory)
		{
			ZipOutputStream output = null;
			try
			{
				output = new ZipOutputStream (new FileOutputStream(a_strDirectory));
				zipTheFiles ("d:/Test", output);
			}
		
			catch (IOException eIO)
			{
				//System.out.println ("An error in the output stream");
				eIO.printStackTrace ();
			}
			finally
			{
				if (null != output)
				{
					try
					{
						output.close ();
					}
					catch (IOException eIO)
					{
						//System.out.println ("there was an IO Error during the Closing of the file");
						eIO.printStackTrace ();
					}
				}
			}
		}
		else
		{
			//System.out.println ("The path passed was null");
			
		}
		
	}
	
	private String zipPath (String a_strFileAbsolutePath)
	{
		int iIndexOf = a_strFileAbsolutePath.indexOf ("\\");
		
		//System.out.println (iIndexOf);
		
		String strRequiredPath = a_strFileAbsolutePath.substring (iIndexOf + 1);
		//System.out.println (strRequiredPath);
		return strRequiredPath;
	}
	
	public static void main (String args [])
	{
		ZippingTest test = new ZippingTest ();
		test.zipDirectory ("d:/Output/test.zip");
		
	}
}