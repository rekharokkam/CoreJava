package com.fic;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHelper {
	
	public static final String getNodeAttributeValue(Node node,
			String strAttribute) 
	{
		    String strValue = null;
		    NamedNodeMap nnmap = node.getAttributes();
		    node = nnmap.getNamedItem(strAttribute);

		    if (null != node) 
		    {
		      strValue = node.getNodeValue();
		    }
		    return strValue;
	}
	
	public static Document loadXml(String xml)  
	{
	    DocumentBuilder builder = null;
	    try 
	    {
	    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    	Document doc = null;
	       
	    	builder = factory.newDocumentBuilder();
	      
	    	doc = builder.parse(xml);
	    	return doc;
	    }
	    catch (Exception e) 
	    {
System.err.println("THERE WAS AN ERROR DURIONG THE PARSING OF THE FILE");
e.printStackTrace(System.err);
	    }
	    return null;
	  }	
	  public static final NodeList getNodeListByPattern(Document doc,
		      String strPattern)  
	 {
		    try 
		    {
		      NodeList nlList = null;
		      nlList = XPathAPI.selectNodeList( (Node) doc, strPattern);
		      if ( (null == nlList) || (0 == nlList.getLength())) {
		        return null;
		      }
		      return nlList;
		    }
		    catch (Exception exp) {
System.err.println("there was an excepting during fetching of nodelist");
exp.printStackTrace(System.err);
		    }
		    return null;
		  }

	public static void main(String[] args) 
	{
		String xmlStr = "<?xml version='1.0' encoding='UTF-8'?>" +
				"<Trustees>" +
				"<Trustee stateCode='AT' useTitleCompany='Y'/>" +
				"<Trustee useTitleCompany='N' companyName='FIC' address1='indiranagar' zip='92104'/>" +
				"</Trustees>";
		Document doc = XMLHelper.loadXml(xmlStr);
		NodeList nodeList = XMLHelper.getNodeListByPattern(doc, "\\Trustee");

System.out.println("the length of node list  :"+ nodeList.getLength());		
	}

	
}
