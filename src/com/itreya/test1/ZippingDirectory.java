/**this class zips a directory and all the subdirectory
 * If the directory is empty then it is not added
 */

package com.itreya.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.*;


class ZippingDirectory
{
	private String [] directoryContents (File a_strDirectoryPath)
	{
		String strDirContents [] = a_strDirectoryPath.list ();			
		return strDirContents;
	}
	
	private void zipDirectory (File a_strDirectory, ZipOutputStream out)
	{
		try 
		{
			String [] strDirContenets = null;							
			
			strDirContenets = directoryContents (a_strDirectory);		
		
			for (int i = 0; i < strDirContenets.length; i++)
			{
				File file = new File (a_strDirectory, strDirContenets [i]);
				System.out.println ("each file is " + strDirContenets [i]);
				if (file .isDirectory ())
				{
					System.out.println ("if it is directory = " + file.getPath ());
					zipDirectory (file, out);				
				}
				
				ZipEntry zipEntry = new ZipEntry (file.getPath ());
				out.putNextEntry (zipEntry);
				
				FileInputStream input = new FileInputStream (file);				
				byte fileContents[] = new byte[input.available()];
				
				out.write (input.read (fileContents));				
				input.close ();				
				
			} 
			
		}
		catch (FileNotFoundException eFNF)
		{
			//System.out.println ("the required file either doesn't exist or there is access permissions");
			//eFNF.printStackTrace ();
		}
		
		catch (IOException eIE)
		{
			System.out.println ("there is some problem during the read operation");
			eIE.printStackTrace ();
		}
		
		
	}
							 
	public static void main (String args [])
	{
		ZippingDirectory test = new ZippingDirectory ();
		try
		{
			FileOutputStream fout = new FileOutputStream ("e:\\new\\test.zip");
			ZipOutputStream out = new ZipOutputStream (fout);
			out.setComment ("this is for testing");
			File file = new File ("e:\\zip");
			test.zipDirectory (file, out);							   
			out.close ();
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		
		
	}
}