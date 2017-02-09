package com.book.webservices.dom2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * @author Rekha Murthy
 */
public class DomBuilder
{
    private static final String SOAP_NS = "http://schemas.xmlsoap.org/soap/envelope/";
    private static final String MH_NS = "http://www.Monson-Haefel.com/jwsbook/BookQuote";
    private static final String XSD_NS = "http://www.w3c.org/2001/XMLSchema";
    private static final String XSI_NS = "http://www.w3c.org/2001/XMLSchema-instance";
    
    private Document document;
    private String filePath;
    
    public DomBuilder()
    {        
    }
    
    public DomBuilder(String xmlFileName)
    {
        this.filePath = xmlFileName;
    }
    
    private void buildDocument ()
    	throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        DOMImplementation domImplementation = parser.getDOMImplementation();
        this.document = domImplementation.createDocument(SOAP_NS, "soap:Envelope", null);
        
        //set the root node attributes
        Element root = document.getDocumentElement();
        root.setAttribute("xmlns:soap", SOAP_NS);
        root.setAttribute("xmlns:mh", MH_NS);
        root.setAttribute("xmlns:xsd", XSD_NS);
        root.setAttribute("xmlns:xsi", XSI_NS);
        
        Element soapBody = document.createElementNS(SOAP_NS, "soap:Body");
        root.appendChild(soapBody);
        
        //Comment section
        Comment comment = document.createComment("THIS IS A TEST COMMENT");
        soapBody.appendChild(comment);
        
        //CDataSection
        CDATASection cDataSection = document.createCDATASection(
                getCdataSectionFromAFile("xml/CDataSection.xml"));
        soapBody.appendChild(cDataSection);
        
        Element getBookPrice = document.createElementNS(MH_NS, "mh:getBookPrice");
        soapBody.appendChild(getBookPrice);
        
        Element isbn = document.createElement("isbn");
        
        //isbn.setAttribute("xsi:type", "xsd:string");
        Attr xsiAttr = document.createAttributeNS(XSI_NS, "xsi:type");
        xsiAttr.setValue("xsd:string");
        isbn.setAttributeNodeNS(xsiAttr);
        Text text = document.createTextNode("0321146182");
        isbn.appendChild(text);
        
        getBookPrice.appendChild(isbn);  
        
        //writeDocument ("xml/soap.xml");
    }
    	
    private String getCdataSectionFromAFile (String cdataFilePath)
    	throws Exception
    {
        BufferedReader bufReader = new BufferedReader(new FileReader(cdataFilePath));
        StringWriter strWriter = new StringWriter();
        String eachLine = bufReader.readLine();
        while (null != eachLine)
        {
            strWriter.write(eachLine);
            eachLine = bufReader.readLine();
        }
        
        return strWriter.toString();
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
    
    public void buildXmlFile()
    	throws Exception
    {
        File file = new File (filePath);
        if (!file.exists())
        {
            file.createNewFile();
        }
        
        DOMSource source = new DOMSource (document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(new BufferedWriter (new FileWriter(filePath, false)));
        transformer.transform(source, result);
    }
    
    public static void main(String[] args)
    	throws Exception
    {
        DomBuilder domBuilder = new DomBuilder("xml/soap.xml");
        domBuilder.buildDocument();
        //domBuilder.printDocument();
        domBuilder.buildXmlFile();
    }
}
