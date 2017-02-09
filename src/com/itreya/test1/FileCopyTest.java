/**This class looks into one of the efficient ways of copying a file
 */

package com.itreya.test1;

import java.io.*;

class FileCopyTest
{
	void copyFileContents ()
	{
		InputStream input = null;
		
		try
		{
			input = new BufferedInputStream (new FileInputStream ("e:/Output/rose.doc"));
			int iBufLength = 3000;
			byte buf [] = new byte [iBufLength];
			byte temp [] = null;
			int iEachChar = -1;
			int iCounter = 0;
			int iLength = 0;			
			
			while (-1 != (iLength = input.read (buf, 0, iBufLength)))
			{
				
				temp = new byte [iLength];
				System.arraycopy (buf, 0, temp, 0, iLength);
				System.out.println (iLength);					
				
			}
			
			
			
		}
		
		catch (FileNotFoundException eFNF)
		{
			System.out.println ("The referenced file was not found");
			eFNF.printStackTrace ();
		}
		catch (IOException eIO)
		{
			System.out.println ("An exception during the FILE Copying");
			eIO.printStackTrace ();
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
					System.out.println ("AN IOException during the closing of the input file");
					eIO.printStackTrace ();
				}
			}
		}		
	}
	
	public static void main (String args [])
	{
		FileCopyTest test = new FileCopyTest ();
		test.copyFileContents ();
	}
}

