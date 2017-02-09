package com.itreya.test2;


import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLTest
{
	private static final String XMLFILE = "testXml.xml";
	
	public static final DocumentBuilder getDOMParser()
	{
		
		DocumentBuilder db = null;
		
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			
			db = dbf.newDocumentBuilder();
			return db;
		}
		catch (ParserConfigurationException e)
		{
			System.out.println ("THERE WAS AN ERROR DURING THE GETTING OF DOM PARSER");
			e.printStackTrace();			
		}
		
		return db;
	}

	private static Document getDocument ()
	{
		Document docuement  = null;
		try
		{
			DocumentBuilder parser = getDOMParser();			
			File xmlFile = new File(XMLFILE);
			docuement = parser.parse(xmlFile);
			return docuement;
		}
		catch (Exception e)
		{
			System.out.println ("THERE WAS AN ERROR DURING THE GETTING OF DOCUMENT");
			e.printStackTrace();
		}
		return docuement;
	}
	
	private void test ()
	{
		Element root = getDocument().getDocumentElement();
		System.out.println("ROOT ELENENT NAME = " + root.getNodeName ());
		
		NodeList allChildren =root.getChildNodes ();
		for(int i = allChildren.getLength(); --i > 0;)
		{
			
			Node eachChild = allChildren.item(i);
			if (eachChild.getNodeType() != Node.TEXT_NODE)
			{
				Element eachChildElement = (Element)eachChild;	
				
				PrintStream stream = null;
				
				try
				{
					FileOutputStream logFile = new FileOutputStream("xml.log", true);
					stream = new PrintStream(logFile);
					stream.println("EACH CHILD NAME = " + eachChild.getNodeName() + "  AND REQUIRED ATTRIBUTE NAME = " + eachChildElement.getAttribute("description"));
					
					eachChildElement.removeAttribute("description");
					eachChildElement.setAttribute ("hi", "HELLO");
					
					stream.println();
					stream.println();					
					
				}
				catch (Exception IOE)
				{
					System.err.println("THERE WAS AN ERROR DURING LOGGIN");
					IOE.printStackTrace();
				}
				finally
				{
					if (null != stream)
					{
						stream.close();
					}
				}
			}
		}
	}
	
	public static void main (String args[] )
	{
		XMLTest test = new XMLTest();
		test.test();
	}
}
