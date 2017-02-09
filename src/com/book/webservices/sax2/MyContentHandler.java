package com.book.webservices.sax2;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Rekha Murthy
 */
public class MyContentHandler extends DefaultHandler
{
    private int counter ;
    private int indent;
    
    Stack stack = null;
    
    public void startDocument ()
    {
System.out.println("INSIDE THE START DOCUMENT METHOD");
		counter = 0;
		indent = 0;
		stack = new Stack();
    }
    
    public void startElement (String uri, String localName, String qName, 
            Attributes attributes)
    {
        
System.out.println("INSIDE THE START ELEMENT TAG");
System.out.println("EVERY ELEMENT URI : " + uri);		
System.out.println("EVERY ELEMENT LOCALNAME : " + localName);
System.out.println("EVERY ELEMENT QNAME : " + qName);

		for (int i = ++indent; --i >= 0;) 
		{
System.out.print("\t");
		}       
        
System.out.println("Start element : <" + qName + ">");        
        
		counter ++;
		
//handling the attributes
		if (attributes.getLength() > 0)
		{
//System.out.println("THE # OF ATTTRIBUTES ARE : " + attributes.getLength());
			for (int i = 0; i < attributes.getLength(); i++) 
			{
//System.out.println("each attribute name : " + attributes.getQName(i) +
//        " , value : " + attributes.getValue(i) + " Type : " + attributes.getType(i));			    
            }
		}
		
		//This is for characters to be displayed
		StringBuffer sb = new StringBuffer (200);
		stack.push(sb);
		
    }
    
    public void endElement (String uri, String localName, String qName)
    {
        for (int i = indent--; --i >= 0;) 
        {
System.out.print("\t");
        }  
System.out.println("End Element : </" + qName + ">");   

		StringBuffer sb = (StringBuffer)stack.pop();
System.out.println("Characters : " + sb.toString());		

    }
    
    public void endDocument ()
    {
System.out.println("THE TOTAL NUMBER OF ELEMENTS : " + counter);        
    }
    
    public void startPrefixMapping (String prefix, String uri)
    	throws SAXException
	{
System.out.println("Inside the start prefix mapping method");
System.out.println("prefix : " + prefix + " , uri : " + uri);
	}
    
    public void endPrefixMapping (String prefix)
    	throws SAXException
	{
System.out.println("Inside the end prefix mapping method");
System.out.println("prefix : " + prefix );
	}
    
    public void characters (char[] ch, int start, int length)
    	throws SAXException
	{
System.out.println("INSIDE THE CHARACTERS METHOD");
System.out.println("TEXT : " + String.valueOf (ch, start, length)+ " , start : " + start + " , length : " + length);
		StringBuffer sb = (StringBuffer)stack.peek();
		sb.append(ch, start, length);
	}
    
    public void error (SAXParseException eSAXParseException)
    	throws SAXException
    {
System.out.println("This is inside the error method");
eSAXParseException.printStackTrace(System.err);
    }
    
    public void fatalError (SAXParseException eSAXParseException)
    	throws SAXException
    {
System.out.println("This is inside the fatal error method");
eSAXParseException.printStackTrace(System.err);
    }
    
    public void warning (SAXParseException eSAXParseException)
    {
System.out.println("This is inside the warning method");
eSAXParseException.printStackTrace(System.err);
    }
    
}
