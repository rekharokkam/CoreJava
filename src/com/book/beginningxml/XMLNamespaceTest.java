package com.book.beginningxml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNamespaceTest 
{
    private Document document;
    
    /**
     * @param document The document to set.
     */
    public void setDocument(Document document)
    {
        this.document = document;
    }
 
    public XMLNamespaceTest(String fileName)    	
    {
    	try
    	{
    		setDocument(buildDocument(fileName));
    	}
    	catch (Exception exception)
    	{
System.err.println("there was an exception during the building of dom object");
exception.printStackTrace();
    	}
    }

    private Document buildDocument (String fileName)
    	throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        return parser.parse(fileName);
    }
	
    public void printDocument ()
    {
        Node rootElement = document.getDocumentElement();
System.out.println("ROOT ELEMENT : \nNode name : " + rootElement.getNodeName() + 
        	" \nLocal Name : " + rootElement.getLocalName() + " \nPrefix : " + rootElement.getPrefix() +
        	" \nName Space URI : " + rootElement.getNamespaceURI() + "\n\n");

		printElements(rootElement);
    }
    
    private void printElements(Node node)
    {
    	if ((node.getNodeType() == Node.ELEMENT_NODE))
    	{
	    	System.out.println("EACH ELEMENT : \nNode name : " + node.getNodeName() + 
	            	" \nLocal Name : " + node.getLocalName() + " \nPrefix : " + node.getPrefix() +
	            	" \nName Space URI : " + node.getNamespaceURI() + "\n\n");
	    	if (node.hasChildNodes())
	    	{
			    NodeList nodeList = node.getChildNodes();
			    for (int childCounter = 0; childCounter < nodeList.getLength(); childCounter ++)
			    {
			        printElements(nodeList.item(childCounter));
			    }
	    	}
    	}
    }
    
	public static void main(String[] args) 
	{
		new XMLNamespaceTest("xml/namespace.xml").printDocument();
	}
}
