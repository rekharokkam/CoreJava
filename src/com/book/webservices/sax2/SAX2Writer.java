package com.book.webservices.sax2;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.xalan.serialize.Serializer;
import org.apache.xalan.serialize.SerializerFactory;
import org.apache.xalan.templates.OutputProperties;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * @author Rekha Murthy
 */
public class SAX2Writer
{
    public static void writeToFile ()
    	throws SAXException, ParserConfigurationException, IOException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        SAXParser parser = factory.newSAXParser();
        XMLReader xmlReader = parser.getXMLReader();
        
        Serializer serializer = SerializerFactory.getSerializer(OutputProperties.getDefaultMethodProperties("xml"));
        serializer.setWriter(new FileWriter("xml/sax2Output.xml"));
        xmlReader.setContentHandler(serializer.asContentHandler());
        xmlReader.parse("xml/sax2.xml");
    }
    
    public static void writeToCMD ()
    	throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        SAXParser parser = factory.newSAXParser();
        XMLReader xmlReader = parser.getXMLReader();
        
        Serializer serializer = SerializerFactory.getSerializer(OutputProperties.getDefaultMethodProperties("xml"));
        serializer.setOutputStream(System.out);
        xmlReader.setContentHandler(serializer.asContentHandler());
        xmlReader.parse("xml/sax2.xml");
        
    }

    public static void main(String[] args)
    {
        try
        {
            writeToCMD ();
        }
        catch (Exception exception)
        {
System.out.println("there was an exception");
exception.printStackTrace(System.err);
        }
    }
}
