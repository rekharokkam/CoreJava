/*
 * XPath tutorials
 */
package com.zapapp.general;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
        catch (Exception e)
        {
System.err.println("there was an exception");
			e.printStackTrace(System.err);
			return null;
        }
    }
    
    public void printXpath (String xpath)
    {
        Document doc = getDocument("xml/xpathTest.xml");
        try
        {
            NodeList nodeList = XPathAPI.selectNodeList(doc, xpath);
            Attr attribute = null;
            Element element = null;
            
System.out.println("total number of nodes : " + nodeList.getLength());

			for (int i = 0; i < nodeList.getLength(); i++) 
			{
                element = (Element)nodeList.item(i);
System.out.println("each element : " + element.getNodeName());                
            }

        }
        catch (Exception e)
        {
System.err.println("THERE WAS AN EXCEPTION AGAIN ");
			e.printStackTrace(System.err);
        }
    }
    
	public static void main(String[] args) 
	{
//	    new XPathTest().printXpath("//CCC[position() mod 2 = 1]");
System.out.println(Math.floor(89/50));	    
	}
}
