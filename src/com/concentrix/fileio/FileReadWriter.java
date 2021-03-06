package com.concentrix.fileio;

import java.io.InputStream;

public interface FileReadWriter
{
	boolean verifyDestinationLocation(String diskPath) throws FileWriteFailedException;
	
	void writeFile (String destinationFileName, String destinationFilePath, InputStream inputStream)
		throws FileWriteFailedException;
}
