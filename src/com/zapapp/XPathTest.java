/**
 * Created based on DOM
 */
package com.zapapp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest
{
    public Document getDocument (String filePath)
    {
        try
        {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        return builder.parse(filePath);
        }
        catch (ParserConfigurationException eParserConfigurationException)
        {
System.err.println("THERE WAS ParserConfigurationException");
			eParserConfigurationException.printStackTrace(System.err);            
        }
        catch (IOException eIOException)
        {
System.err.println("THERE WAS AN IOEXCEPTION");
			eIOException.printStackTrace(System.err);        
		}
    
        catch (SAXException eSAXException)
        {
System.err.println("THERE WAS SAXException");
			eSAXException.printStackTrace(System.err);        
		}
        return null;
    }
    
    public void printXpath (String xpath)
    {       
       Document doc = getDocument("CoreJava/xml/xpathTest.xml");
       try
       {
           NodeList nodeList = XPathAPI.selectNodeList(doc, xpath);
           Attr attribute = null;
           Element element = null;
System.out.println("THE TOTAL NUMBER OF NODES : " + nodeList.getLength());           
           
           for (int i=0; i < nodeList.getLength(); i++) 
           {
               // Get element
               element = (Element)nodeList.item(i);
               
System.out.println("each element name : " + element.getNodeName());               
               
           }
       }
       catch (Exception e)
       {
System.err.println("EXCEPTION DURING XPATH OPERATIONS");
			e.printStackTrace(System.err);
       }
    }
    
    public static void main(String[] args)
    {
        //new XPathTest().printXpath("//*[position() = ceiling (last() div 2 + 0.5) or position() = floor (last() div 2 + 0.5) ]");
        new XPathTest().printXpath("//*[position() = floor (last() div 2 + 0.5) ]");
//System.out.println(1 % 2);        
    }
}
