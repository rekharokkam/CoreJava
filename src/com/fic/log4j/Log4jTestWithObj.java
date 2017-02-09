package com.fic.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTestWithObj 
{
	private final static Logger myLogger = Logger.getLogger(Log4jTestWithObj.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("C:/Rekha/Testing_Workspace/CoreJava/logs/log4j.properties");		
		myLogger.debug("THIS IS THE DEBUG LOG");
		NestedClass nestedClass = new NestedClass("rekha");
		myLogger.debug("" + nestedClass);
	}

	private static class NestedClass
	{
		private String name;
		public NestedClass (String name)
		{
			this.name = name;
		}
		
		public NestedClass()
		{			
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}
		
		public String toString()
		{
System.out.println("INSIDE THE TOSTRING METHOD");
			return "THIS IS THE TO STRING METHOD OF NESTED CLASS";			
		}
	}
}
