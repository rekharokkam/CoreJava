/**This class reads the contents of a file in a JAR file
 * This class is not very properly coded. It can be coded in a better way
 * This class has three methods which perform independent of each other
 * All the three mehods thorw their own exceptions. All the exception handling has to be done in the method which calls them
 * All the Exception handling is done by the method fianlOutput
 */

package com.itreya.learn;

import java.net.URL;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.zip.ZipException;

class JarReader
{
	//This method returns a JarURLConnection when a jarFile and the file inside the archive to be read is passed
	JarURLConnection getURLConnection (String a_strJarFileName, String a_strJarFileEntry) throws MalformedURLException, IOException
	{
		URL url = null; 
		JarURLConnection jarConnection = null;
		
		if (null == url)		 
		{
			url = new URL ("jar:file:///" + a_strJarFileName + "!/" + a_strJarFileEntry);
			jarConnection = (JarURLConnection)url.openConnection ();			
		}		
		
		return jarConnection;
		
	}
	
	//This method returns the Input stream from the UrlConnection established
	InputStream getInputStream (JarURLConnection jarConnection) throws MalformedURLException, IOException
	{
		InputStream input = null; 
		if (null != jarConnection)
		{
			jarConnection.setDoInput(true);
			input = jarConnection.getInputStream ();		
		}
		return input;	
	}
	
	//This method prints the contents of the input stream passed and returns a boolean value indication success or failure
	boolean printContents (InputStream input) throws IOException
	{
		boolean isSuccess = false;
		if (null !=  input)
		{
			
			BufferedReader reader = new BufferedReader (new InputStreamReader (input));
			String strEachLine = null;
				
			while ((strEachLine = reader.readLine ()) != null)
			{
				System.out.println (strEachLine);
			}
				
			isSuccess = true;
			
		}
		return isSuccess;
		
	}
	
	/*This method is used only for the display purpose.
	* All the three methods throw exceptions and none handle them.
	* All the exception handling is done here. 
	* Very good exception handling is done here as there are no custom exceptions	
	* The boolean value of this method is not used any where later can be used if needed
	*/
	void fianlOutput ()
	{	
		boolean isDone = false;
		try
		{
			isDone = printContents(getInputStream(getURLConnection ("D:\\new.jar", "JdbcTestAccess.java")));							
		}
		
		catch (MalformedURLException eMalURL)
		{
			System.out.println ("there was MalFormed URL exception during the Jar UrlConnection");
			eMalURL.printStackTrace ();
		}
		
		catch (IOException eIO)
		{
			System.out.println ("There was an IOException during the reading of the FIle");
			eIO.printStackTrace ();
		}
		
	}
	
	public static void main (String args [])
	{
		JarReader jarReader = new JarReader ();
		jarReader.fianlOutput ();		
	}
	
}
