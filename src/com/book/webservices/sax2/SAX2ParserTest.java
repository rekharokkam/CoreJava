package com.book.webservices.sax2;

//import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Rekha Murthy
 */
public class SAX2ParserTest
{
    public static void main(String[] args)    	
    {
        try
        {
            XMLReader sax2Parser = XMLReaderFactory.createXMLReader();
            ContentHandler contentHandler = (ContentHandler)Class.forName(args[0]).newInstance();
            ErrorHandler errorHandler = (ErrorHandler)Class.forName(args[0]).newInstance();
            
            //Name Space feature
            sax2Parser.setFeature("http://xml.org/sax/features/namespaces", true);
            
            //Schema validation feature - Xerces specific features
            sax2Parser.setFeature("http://apache.org/xml/features/validation/schema", false);
//            sax2Parser.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
            sax2Parser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation",
                    "http://schemas.xmlsoap.org/soap/envelope/SOAP-1_1.xsd " +
                    "http://www.Monson-Haefel.com/jwsbook/BookQuote.xsd");
            
            
            sax2Parser.setContentHandler(contentHandler);
            sax2Parser.setErrorHandler(errorHandler);
            sax2Parser.parse("xml/sax2.xml");
        }
        catch (Exception exception)
        {
System.out.println("there was an exception");
exception.printStackTrace (System.err);
        }
    }
}
