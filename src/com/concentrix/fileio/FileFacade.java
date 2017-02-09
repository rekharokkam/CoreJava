package com.concentrix.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class FileFacade 
{
	private static final String DISK = "DISK";
	
	public FileFacade (){}
	
	public void processUploadedFile(Metadata uploadedFileMetaData) throws FileWriteFailedException
	{	
System.out.println("Metadata Object passed to processUploadedFile of FileFacade class : " + uploadedFileMetaData);		
		
		try
		{
System.out.println("Inside the processUploadedFile method after clean up");			
			//Create the FileReadWriter based on the writeType
			FileReadWriter fileReadWriter = getFileReadWriter(uploadedFileMetaData.getDestinationType());
System.out.println("FileReadWrite Instace created from Desitnation type : " + fileReadWriter.getClass().getName());

			//Create CSV from the metadata Object
			createMetadataFile(uploadedFileMetaData, fileReadWriter);
			
			String destinationFileDiskFullPath = uploadedFileMetaData.getPath() + File.separator + uploadedFileMetaData.getFolderName();
System.out.println("Desintaion file full disk path : " + destinationFileDiskFullPath);
			fileReadWriter.writeFile(uploadedFileMetaData.getFileName(), destinationFileDiskFullPath, uploadedFileMetaData.getInputStream());
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);		
			throw new FileWriteFailedException("", exception.getMessage(), exception);
		}
	}
	
	private void createMetadataFile(Metadata uploadedFileMetaData, FileReadWriter fileReadWriter) 
		throws FileWriteFailedException
	{	
		String destinationFileFullPath = uploadedFileMetaData.getPath() + File.separator + uploadedFileMetaData.getFolderName();
System.out.println("Desitnation location full path : " + destinationFileFullPath);
		boolean isDestinationLocationValid = fileReadWriter.verifyDestinationLocation(destinationFileFullPath);
System.out.println("Is destination location valid : " + isDestinationLocationValid);
		
		if (isDestinationLocationValid)
		{
			String destinationMetadataFileWithFullPath = destinationFileFullPath + 
				File.separator  +  
				uploadedFileMetaData.getFileName().substring(0, uploadedFileMetaData.getFileName().indexOf('.')) + 
				"_metadata.csv";
System.out.println("Destination Metadata File with full path : " + destinationMetadataFileWithFullPath);
			CSVWriter csvWriter = null;
			
			try
			{
				csvWriter = new CSVWriter(
						new BufferedWriter(new FileWriter(new File (destinationMetadataFileWithFullPath))) );
				csvWriter.writeNext(uploadedFileMetaData.createHeader());
				csvWriter.writeNext(uploadedFileMetaData.createData());
			}
			catch (Exception exception)
			{
exception.printStackTrace(System.err);				
				throw new FileWriteFailedException("", exception.getMessage(), exception);
			}
			finally
			{
				if (null != csvWriter)
				{
					try
					{
						csvWriter.close();
					}
					catch (IOException ioException)
					{
ioException.printStackTrace(System.err);					
					}
				}
			}
		}
	}
	
	private FileReadWriter getFileReadWriter (String fileWriteLocationType)
	{
		if (fileWriteLocationType.equals(DISK))
		{
			return new DiskFileReadWrite();
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		try
		{
			Metadata metadata = new Metadata();
			
			metadata.setFileName("Quote Download Mapping - LCM Analysis.xlsx");
			metadata.setFolderName("HP Fixed Care Pack");
			FileInputStream fileInputStream = new FileInputStream(new File ("C:/Rekha/from/Quote Download Mapping - LCM Analysis.xlsx"));
			metadata.setInputStream(fileInputStream);
			metadata.setDestinationType("DISK");
			metadata.setPath("C:/Rekha/to");
			List<String> headerList = new ArrayList<String>();
			headerList.add("UserId");
			headerList.add("UserOId");
			headerList.add("FileType");
			metadata.setHeaderList(headerList);
			List<String> dataList = new ArrayList<String>();
			dataList.add("dm");
			dataList.add("00111222323");
			dataList.add("Hp FIxed Care Pack");
			metadata.setDataList(dataList);
			
			new FileFacade ().processUploadedFile(metadata);
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);			
		}
	}
}
