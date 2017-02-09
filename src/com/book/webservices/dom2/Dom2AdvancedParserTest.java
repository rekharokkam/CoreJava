package com.book.webservices.dom2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Roopa Murthy
 */
public class Dom2AdvancedParserTest
{
    private String fileName;
    private Document document;
    
    /**
     * @param document The document to set.
     */
    public void setDocument(Document document)
    {
        this.document = document;
    }
    public Dom2AdvancedParserTest(String fileName)
    	throws Exception
    {
        this.fileName = fileName;
        setDocument(buildDocument());
    }
    public Dom2AdvancedParserTest()
    {        
    }
    
    /**
     * @return Returns the fileName.
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * @param fileName The fileName to set.
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    private Document buildDocument ()
    	throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        return parser.parse(fileName);
    }
    
    public void printSibling()    	
    {
        document.normalize();
        Node rootElement = document.getDocumentElement();        
        printSibling(rootElement);
    }
    
    private void printSibling (Node node)
    {
System.out.println("\nThe current Node : " + node.getNodeName() + ", Value : " + node.getNodeValue());
		if (null != node.getNextSibling())
		{
System.out.println("Next sibling Name : " + node.getNextSibling().getNodeName() +
        	" , Value : " + node.getNextSibling().getNodeValue());			    
		}
		if (null != node.getPreviousSibling())
		{
System.out.println("Previous sibling Name : " + node.getPreviousSibling().getNodeName() +
        	" , Value : " + node.getPreviousSibling().getNodeValue());			    
		}
		
		if (node.getNodeType() == Node.ELEMENT_NODE && node.hasChildNodes())
		{
		    NodeList nodeList = node.getChildNodes();
		    for (int childCounter = 0; childCounter < nodeList.getLength(); childCounter++)
		    {
		        printSibling(nodeList.item(childCounter));
		    }
		}
    }
    
    public static void main(String[] args)
    	throws Exception
    {
        new Dom2AdvancedParserTest("xml/dom2.xml").printSibling();
    }
}
