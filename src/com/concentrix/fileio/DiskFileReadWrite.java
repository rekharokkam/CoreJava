package com.concentrix.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class DiskFileReadWrite implements FileReadWriter
{
	public boolean verifyDestinationLocation(String toBeVerifiedDiskPath) throws FileWriteFailedException
	{
System.out.println("Destination location to be verified in verifyDestinationLocation() of DiskFileReadWrite : " + toBeVerifiedDiskPath); 
		try
		{
			File file = new File (toBeVerifiedDiskPath);			
			boolean isFolderExists = file.exists() && file.isDirectory() ;
System.out.println("Does the disk file location exists and also a directory : " + isFolderExists);
			
			if (!isFolderExists)
			{
				file.mkdir();				
			}
			return true;
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);				
			throw new FileWriteFailedException("", exception.getMessage(), exception);
		}
	}

	public void writeFile(String destinationFileName, String destinationFilePath, InputStream inputStream)
			throws FileWriteFailedException
	{	BufferedOutputStream bufferedOutputStream = null;
	BufferedInputStream bufferedInputStream = null;
	
		OutputStream outputStream = null;
		ReadableByteChannel source = null;
		WritableByteChannel dest = null;
		
		try
		{
			String destinationFileWithFullPath = destinationFilePath + File.separator  + destinationFileName;
System.out.println("Disk Full path for the file upload : " + destinationFileWithFullPath);
			if (verifyDestinationLocation(destinationFilePath))
			{
System.out.println("Folder location is valid, so writing the file uploaded by user");
				outputStream = new FileOutputStream(destinationFileWithFullPath);
				
				bufferedOutputStream = new BufferedOutputStream(outputStream);
				bufferedInputStream = new BufferedInputStream(inputStream);
//				
//				source = Channels.newChannel(bufferedInputStream);
//				dest = Channels.newChannel(bufferedOutputStream);
//				
//				ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
//				
//				while (source.read(buffer) != -1)
//				{
//					buffer.flip();
//					
//					while (buffer.hasRemaining())
//					{
//						dest.write(buffer);
//					}
//					
//					buffer.clear();
//				}
//				
//				
////				for (int c = bufferedInputStream.read(); c != -1; c = bufferedInputStream.read())
////				{
////					bufferedOutputStream.write (c);
////				}
//				
		        byte[] buffer = new byte[1024 * 16];
		     
		        int n = 0;
		        while (-1 != (n = bufferedInputStream.read(buffer))) {
		        	bufferedOutputStream.write(buffer, 0, n);
//		        	bufferedOutputStream.flush();		     
		        }		     
			}
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);				
			throw new FileWriteFailedException("", exception.getMessage(), exception);
		}
		finally
		{
			try
			{
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != source)
				{
					source.close();
				}
				if (null != dest)
				{
					dest.close();
				}
			}
			catch (IOException ioException)
			{
ioException.printStackTrace(System.err);	
			}
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File ("C:/Rekha/from/Quote Download Mapping - LCM Analysis.xlsx"));
			
			new DiskFileReadWrite().writeFile("Quote Download Mapping - LCM Analysis.xlsx",
					"C:/Rekha/to/Hp Fixed Care Pack", fileInputStream);
			
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);			
		}
		
	}
}
