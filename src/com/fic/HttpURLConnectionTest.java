package com.fic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author brekha
 * Created to test the OMORSSERVLET servlet by using HttpUrlConnection object
 * PGM from LearningJava book 13th chapter
 */
public class HttpURLConnectionTest
{
    private static String getInputData ()
    	throws Exception
    {
        StringBuffer sb = new StringBuffer();
        sb.append(URLEncoder.encode("hobby", "UTF-8") + "=");
        sb.append(URLEncoder.encode("sleep", "UTF-8"));
        sb.append("&" + URLEncoder.encode("company", "UTF-8") + "=");
        sb.append(URLEncoder.encode("FIC", "UTF-8"));
System.out.println("the form data : " + sb.toString());        
        return sb.toString();
    }

    public static void main(String[] args)    	
    {
        HttpURLConnection httpURLConnection = null;
        OutputStream pwriter = null;
        
        try
        {
	        URL url = new URL("http://localhost:8080/servletTesting/servlet/OMORSServlet");
	        httpURLConnection = (HttpURLConnection)url.openConnection();
	        
	        httpURLConnection.setRequestMethod("POST");
//	        httpURLConnection.setRequestProperty("Content-type", 
//	        	"application/x-www-form-urlencoded");
	        httpURLConnection.setDoOutput(true);
	        httpURLConnection.setDoInput(true);
	        
	        String formData = getInputData();
	        
	        //PrintWriter pwriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "8859_1"), true);
	        pwriter = httpURLConnection.getOutputStream();
	        
	        pwriter.write(getInputData().getBytes()) ;
	        pwriter.flush();
	        
	System.out.println("THE RESPONSE CODE : " + httpURLConnection.getResponseCode());
			if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
			{
			    BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			    String eachLine = "";
			    while ((eachLine = reader.readLine()) != null)
			    {
	System.out.println(eachLine);		        
			    }
			}
        }
        catch (Exception exception)
        {
System.err.println("THERE WAS AN EXCEPTION");
exception.printStackTrace(System.err);
        }
        finally
        {
            if (null != httpURLConnection)
            {
                httpURLConnection.disconnect();
            }
            if (null != pwriter)
            {
	            try
	            {
	                pwriter.close();
	            }
	            catch (Exception exception)
	            {
System.err.println("there was an unwanted exception");	            
	            }
            }
        }
    }
}
