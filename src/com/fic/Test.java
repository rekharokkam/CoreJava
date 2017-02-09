package com.fic;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Roopa Murthy
 */
public class Test
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
    public Test(String fileName)
    	throws Exception
    {
        this.fileName = fileName;
        setDocument(buildDocument());
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
		printElements(rootElement);
    }
    
    private void printElements(Node node)
    {
System.out.println("NODE NAME : " + node.getNodeName()+ " NODE VALUE : " + node.getNodeValue());

		if (node.getNodeType() == Node.ELEMENT_NODE && node.hasAttributes())
		{
		    printattributes((Element)node);
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
    	new Test("xml/sp.xml").printDocument();
//    	String sp = "&#8482;";
//System.out.println("replaced string : " + sp.replaceAll("&#8482;", "™"));    	
    }
}
