/**this class first zips the given directory structure and also extracts into
 * the mentioned folder structure
 * This class can be used only for zipping the folders or only extracting the 
 * contents of a zip file or for both the operations
 */

package com.itreya.learn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipException;

import java.util.Enumeration;


class ZippingAndExtracting
{
	
	private String m_strInputDirectory;
	private String m_strOutputDirectory;
	private static final String ZIPFILE = "test.zip";
	
	ZippingAndExtracting (String a_strInputDirectory, String a_strOutputDirectory)
	{
		m_strInputDirectory = a_strInputDirectory;
		m_strOutputDirectory = a_strOutputDirectory;
	}
	
	public final String getInputDirectory ()
	{
		return m_strInputDirectory;
	}
	
	public final String getOutputDirectory ()
	{
		return m_strOutputDirectory;
	}
	
	public void setInputDirectory (String a_strInputDirectory)
	{
		m_strInputDirectory = a_strInputDirectory;
	}
	
	public void setOutputDirectory (String a_strOutputDirectory)
	{
		m_strOutputDirectory = a_strOutputDirectory;
	}
	
	//This method returns files of the Directory passed as the parameter
	public static File [] getFiles (String a_strDirectory)
	{
		File files [] = null;
		
		if (null != a_strDirectory)
		{
			File file = new File (a_strDirectory);
			//System.out.println ("The input directory " + a_strDirectory);
			if (file.exists ())
			{
				if (file.isDirectory ())		
				{
					files = file.listFiles (); 				
				}
				else
				{
					System.out.println ("The given path is not a Directory");
				}				
			}
			else
			{
				System.out.println ("The given directory doesn't exist");
			}			
		}
		else
		{
			System.out.println ("The Directory path is null");
		}		
		return files;
	}
	
	//This method zipps the contents of the Directory passed as the parameter
	public boolean zipDirectory (String a_strInputDirectory, ZipOutputStream zipOutputStream)
	{
		File files [] = getFiles (a_strInputDirectory);
		boolean isZipped = false;	
		InputStream input = null;
		
		if (null != files)
		{	
			ZipEntry eachEntry = null;	
			
			for (int i = files.length; --i >= 0;)
			{
				if (files [i].isDirectory ())
				{
					zipDirectory (files [i].getAbsolutePath (), zipOutputStream);
				}
				else
				{
					//System.out.println ("the absolute path of the file is " + files [i].getAbsolutePath ());
					
					String strZipPath = getZipEntryPath (files [i].getAbsolutePath ());
					if (null != strZipPath)
					{
						//System.out.println ("strZipPath = " +  strZipPath);
						
						
						eachEntry = new ZipEntry (strZipPath);
						try
						{
							input = new BufferedInputStream (new FileInputStream (files [i]));
							byte bytes [] = new byte [input.available ()];
							input.read (bytes);							
							zipOutputStream.putNextEntry (eachEntry);
							zipOutputStream.write (bytes, 0, bytes.length);						
						}
						catch (ZipException eZipEx)
						{
							System.out.println ("there was ZipException during adding the contents to the zip file");
							eZipEx.printStackTrace ();
							continue;
						}
						catch (IOException eIO)
						{
							System.out.println ("There was an exception duirng the adding of the Zip contents to a zip file");
							eIO.printStackTrace ();
							continue;
						}
						
						finally
						{
							if (null != input)
							{
								try
								{
									input.close ();
								}
								catch (IOException eIO)
								{
									System.out.println ("IOException duirng closing of the input stream");
									eIO.printStackTrace ();
								}
							}
						}
					}
				}
			}
		}
		
		return isZipped;		
	}
	
	void zipping ()
	{
		ZipOutputStream out = null;
		String fileSpeperator = System.getProperty ("file.separator");
		try
		{
			out = new ZipOutputStream (new FileOutputStream(getOutputDirectory () + File.separator + ZIPFILE));
			boolean isZipped = zipDirectory (getInputDirectory (), out);
			
		}
		
		catch (IOException eIO)
		{
			System.out.println ("An IO Exception during the formation of zip file");
			eIO.printStackTrace ();
		}
		finally
		{
			if (null != out)
			{
				try
				{
					out.close ();
				}
				catch (IOException ex)
				{
					System.out.println ("An error duirng the closing of the zip output stream");
					ex.printStackTrace ();
				}
			}
		}
		
	}
	
	public String getZipEntryPath (String a_strFileAbsolutePath)
	{
		int iZipPathLength = getInputDirectory ().length () + 1;
		//System.out.println ("Input directory is " + iZipPathLength);
		
		String strZipPath = null;
		
		if (0 != iZipPathLength)
		{
			strZipPath = a_strFileAbsolutePath.substring (iZipPathLength);
			//System.out.println ("strZipPath = " + strZipPath);
		}
		
		return strZipPath;
	}
	
	
	boolean extractZip ()
	{
		boolean isExtracted = false;
		File file = new File (getOutputDirectory () + File.separator + ZIPFILE);
		if (file.exists ())
		{
			InputStream input = null;
			OutputStream output = null;
			
			try
			{
				ZipFile zipFile = new ZipFile (file);
				Enumeration enum1 = zipFile.entries ();
				
				ZipEntry eachEntry = null;
				
				while (enum1.hasMoreElements ())
				{
					
					eachEntry = (ZipEntry)enum1.nextElement ();					
					File eachFile = new File (eachEntry.getName ());
					//System.out.println ("each File is " + eachEntry.getName ());
					
					String strParentPath = eachFile.getParent ();
					if (null != strParentPath)
					{
						//System.out.println ("PARENT IS " + strParentPath);
						File eachFileParent = new File (strParentPath);
						if (!eachFileParent.exists ())
						{
							File parentFolders = new File (getOutputDirectory () + File.separator + eachFileParent);
							//System.out.println ("inside the If block");
							parentFolders.mkdirs ();
						}
					}
					
					input = zipFile.getInputStream (eachEntry);
					
					byte bytes [] = new byte [50000];
					byte temp [] = null;
					int iRead = -1;
					
					output = new BufferedOutputStream (new FileOutputStream (getOutputDirectory () + File.separator + eachEntry.getName ())); 
					while (-1 != (iRead = input.read (bytes)))
					{
						temp = new byte [iRead];
						System.arraycopy (bytes,0,temp,0,iRead);
						output.write (temp);
					}
					
					isExtracted = true;
				}
					   
				
			}
			catch (ZipException eZipEx)
			{
				System.out.println ("There was ZipException during the ");
				eZipEx.printStackTrace ();
			}
			catch (IOException eIO)
			{
				System.out.println ("There was IOException during ZipFile Formation");
				eIO.printStackTrace ();
			}
			
			finally
			{
				if ((null != output) && (null != input))
				{
					try
					{
						input.close ();
						output.close ();
					}
					catch (IOException eIO)
					{
						System.out.println ("There was an IOException either duirng the closing of input or output stream");
						eIO.printStackTrace ();
					}
				}
			}
		}
		else
		{
			System.out.println ("The Given zip file does not exist");			
		}
		
		
		return isExtracted;
		
	}
	
	public static void main (String args [])
	{
		ZippingAndExtracting test = new ZippingAndExtracting ("d:\\Test", "d:\\Output");
		test.zipping ();
		boolean isDone = test.extractZip ();
	}
}