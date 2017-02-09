package com.book.webservices.dom2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * @author Rekha Murthy
 */
public class Dom2OtherFeaturesTest
{
    private Document source;
    private Document target;
    private String filePath;
    
    public Dom2OtherFeaturesTest()
    {        
    }
    
    public Dom2OtherFeaturesTest(String xmlFileName)
    {
        this.filePath = xmlFileName;
    }
    
    public void buildDocument ()
    	throws Exception
    {
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        DOMImplementation domImpl = parser.getDOMImplementation();
        source = domImpl.createDocument(null, "source", null);
        target = domImpl.createDocument(null, "target", null);
        
        Element sourceRoot = source.getDocumentElement();
        Element targetRoot = target.getDocumentElement();
        
        Element sourceElement = source.createElement("sourceElement");
        sourceElement.setAttribute("xyz", "junk");
        sourceRoot.appendChild(sourceElement);
        Text text = source.createTextNode("this is the text node");
        sourceElement.appendChild(text);
        
        Element sourceElementChild = source.createElement("sourceElementChild");
        sourceElementChild.setAttribute("abc", "junk");
        sourceElement.appendChild(sourceElementChild);
        
        Node clonedNode = sourceElement.cloneNode(true);
System.out.println("Parent of cloned node : " + clonedNode.getParentNode());        
        sourceRoot.appendChild(clonedNode);
        
System.out.println("Source Document : ");        
        printDoc (source);        
        
        Element targetElement = target.createElement("targetElement");
        targetRoot.appendChild(targetElement);
        
        Node importedNode = target.importNode(sourceElement, true);
System.out.println(" \nBefore The parent node of imported node : " + importedNode.getParentNode());        
        targetRoot.appendChild(importedNode);
System.out.println("After The parent node of imported node : " + importedNode.getParentNode());        
        
System.out.println("\n\nTarget Document : ");        
        printDoc (target);           
        
//        Node removedElement = sourceRoot.removeChild(sourceElement);
//        targetRoot.appendChild(removedElement);
//        targetRoot.replaceChild(removedElement, targetElement);
    }
    	
    public void printDoc(Document doc)
	throws Exception
	{
	    DOMSource source = new DOMSource (doc);
	    TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	    Transformer transformer = transformerFactory.newTransformer();
	    StreamResult result = new StreamResult(System.out);
	    transformer.transform(source, result);
	}
    
    
    
    public static void main(String[] args)
    	throws Exception
    {
        new Dom2OtherFeaturesTest().buildDocument();
    }
}
