package com.concentrix.fileio;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Metadata {
	private List<String> headerList = new ArrayList<String>();
	private List<String> dataList 	= new ArrayList<String>();
	private String delimiter		= "#";
	private String destinationType;	
	private String path;
	private String folderName;
	private String fileName;
	private InputStream inputStream;
	

	public Metadata() {
		super();
	}

	public String getDelimiter()
	{
		return delimiter;
	}

	public void setDelimiter(String delimiter)
	{
		this.delimiter = delimiter;
	}

	
	public List<String> getHeaderList()
	{
		return headerList;
	}

	public void setHeaderList(List<String> header)
	{
		headerList = header;
	}

	public List<String> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<String> data)
	{
		dataList = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}	
	
	public void setMetadata(String header, String data){
		this.headerList.add(header);
		this.dataList.add(data);
	}

	public String[] createHeader(){
		return createIt(headerList);
	}
	
	public String[] createData(){
		return createIt(dataList);
	}
	
	public String[] createIt(List<String> l){
		StringBuilder s = new StringBuilder();
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) {
			if (s.length() != 0)
				s.append(delimiter);	
			s.append(iterator.next());
		}
		return s.toString().split(delimiter);
	}
	
	public String toString ()
	{
    	StringBuilder sb = new StringBuilder();
		sb.append("\nClass : com.cnx.renewsolv.fileio.Metadata");
		sb.append("\n\tDelimiter : ").append(getDelimiter());
		sb.append("\n\tDestination Type : ").append(getDestinationType());
		sb.append("\n\tPath : ").append(getPath());
		sb.append("\n\tFolder Name : ").append(getFolderName());
		sb.append("\n\tFile Name : ").append(getFileName());
		sb.append("\n\tHeader List : ").append(getHeaderList());
		sb.append("\n\tData List : ").append(getDataList());
    	return sb.toString();
		
	}
}
