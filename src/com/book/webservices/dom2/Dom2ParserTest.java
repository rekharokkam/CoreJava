package com.book.webservices.dom2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Rekha Murthy
 */
public class Dom2ParserTest
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
    public Dom2ParserTest(String fileName)
    	throws Exception
    {
        this.fileName = fileName;
        setDocument(buildDocument());
    }
    public Dom2ParserTest()
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

    public void printDocument ()
    {
        Node rootElement = document.getDocumentElement();
System.out.println("ROOT ELEMENT : \nNode name : " + rootElement.getNodeName() + 
        	" \nlocalName : " + rootElement.getLocalName() + " \nprefix : " + rootElement.getPrefix() +
        	" \nname space uri : " + rootElement.getNamespaceURI() + "\n\n");

System.out.println("root parent element : " + rootElement.getParentNode().getNodeName());

		printElements(rootElement);
    }
    
    private void printElements(Node node)
    {
System.out.println("NODE NAME : " + node.getNodeName()+ " NODE VALUE : " + node.getNodeValue());

		if (node.getNodeType() == Node.ELEMENT_NODE && node.hasAttributes())
		{
System.out.println("\n\n");		            
		    printattributes((Element)node);
System.out.println("\n\n");		            
		}

		if (node.getNodeType() == Node.ELEMENT_NODE
			&& (node.hasChildNodes()))
		{
		    NodeList nodeList = node.getChildNodes();
		    for (int childCounter = 0; childCounter < nodeList.getLength(); childCounter ++)
		    {
		        printElements(nodeList.item(childCounter));
		    }
		}
    }
    
    private void printattributes (Element element)
    {
        Attr attribute = null;
        NamedNodeMap attributes = element.getAttributes();
        for (int arrCounter = 0; arrCounter < attributes.getLength(); arrCounter ++)
        {
            attribute = (Attr)attributes.item(arrCounter);
System.out.println("Attribue Name : " + attribute.getName() + " , Attribute Value : " + attribute.getValue());                
        }
    }
    
    public static void main(String[] args)
    	throws Exception
    {
        new Dom2ParserTest("xml/pagination.xml").printDocument();
    }
}
