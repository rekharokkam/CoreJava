package com.itreya.test2;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class DOMBuilderTest
{
	private static String XMLFILE = "d:/newXML.xml";
	
	private static void buildDOMTree ()
	{
		File file = new File (XMLFILE);
		Document newDoc = null;
		Element root = null;
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			newDoc = builder.newDocument();
		}
		catch (ParserConfigurationException ePCE)
		{
			System.err.println("There was an error during the configuration of the xml file");
			ePCE.printStackTrace();
		}
		
		
		try
		{
			root = newDoc.createElement ("Animal");
			
			root.appendChild (newDoc.createComment ("HAHA"));
			
			Element eachAnimal = newDoc.createElement ("Dog");			
			eachAnimal.setAttribute ("name", "Doggie");
			eachAnimal.appendChild (newDoc.createTextNode ("Doggie text"));
			
				
			root.appendChild (eachAnimal);
			
		}
		catch (DOMException eDOM)
		{
			System.err.println ("THERE WAS A DOM EXCEPTION");
			eDOM.printStackTrace();
		}
		PrintWriter pw = null;
		try
		{
			FileWriter writer = new FileWriter (file);
			pw = new PrintWriter (writer);
			pw.println (root.toString ());
		}
		catch (IOException eIO)
		{
			System.err.println ("THERE WAS AN EXCEPTION DURING WRITING TO FILE");
			eIO.printStackTrace();
		}
		finally
		{
			if (null != pw)
			{
				pw.close();
			}
		}
	}
	
	public static void main (String args[])
	{
		buildDOMTree ();
	}
}
