/*
 * http://developers.sun.com/mobility/midp/ttips/HTTPPost/ - some thing useful may not be much relevant.
 */

package com.fic.httpClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;


/**
 * @author brekha
 * Created to test HttpClient provided by Commons 
 */
public class HttpClientTest
{
    final HttpClient httpClient = new HttpClient ();
    
    public HttpClientTest(int retryNumber)
    {
//        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//                new DefaultHttpMethodRetryHandler(retryNumber, false));
    }
    
    public HttpClientTest()
    {
        this (2);
    }
    
    private HttpMethod getHttpMethod (short methodName, String uri)
    {
        HttpMethod httpMethod = null;
        if (methodName == 1)
        {
            httpMethod = new GetMethod (uri);
        }
        else
        {
            httpMethod = new PostMethod (uri);
        }        
        return httpMethod;            
    }
    
    /*
     * Test for OMORSServlet doGet Method 
     */
    public void testServletGet(String uri)
    {
        GetMethod getMethod = (GetMethod)getHttpMethod ((short)1, uri);
        
        NameValuePair[] parameters = {new NameValuePair("company", "FIC"), new NameValuePair("hobby", "sleep")};
        
        getMethod.setQueryString(parameters);
        
        try
        {
            int statusCode = httpClient.executeMethod(getMethod);
            
            if (statusCode == HttpStatus.SC_OK)
            {
System.out.println("Response stream : " + getMethod.getResponseBodyAsString());                
            }
        }
        catch (HttpException eHttpException)
        {
System.err.println("there was an exception");
eHttpException.printStackTrace(System.err);
        }
        catch (IOException eIOException)
        {
System.err.println("there was an IO Exception");
eIOException.printStackTrace(System.err);
        }
        finally
        {
            getMethod.releaseConnection(); 
        }
        
    }
    
    public void testServletPost (String uri)
    {
        PostMethod postMethod = (PostMethod)getHttpMethod ((short)2, uri);
        
        /*
         * Can have either addParameter or nameValuePair.
         * If name value pair then addParameter becomes inactive
         */
        
/*
        postMethod.addParameter("company", "FIC");
        NameValuePair nameValuePair[] = {new NameValuePair("hobby", "sleeping")};
        postMethod.setRequestBody(nameValuePair);
*/
        
        try
        {
            int statusCode = httpClient.executeMethod(postMethod);
System.out.println("the status code : " + statusCode);           

			if (statusCode == HttpStatus.SC_OK)
			{
			    
//			    String response =  postMethod.getResponseBodyAsString();
//System.out.println("response String : " + response);	
			    InputStream inputStream = postMethod.getResponseBodyAsStream(); 
			    BufferedInputStream bufInputStream = new BufferedInputStream (inputStream);
			    BufferedOutputStream bufOutputStream = new BufferedOutputStream(new FileOutputStream("received.pdf"));
			    
			    int read = -1;
			    while ((read = bufInputStream.read ()) != -1)
			    {
			        bufOutputStream.write (read);
			    }
			    
			    bufOutputStream.flush();
			    bufInputStream.close();
			    bufOutputStream.close();
			}
        }
        catch (HttpException eHttpException)
        {
System.err.println("there was an exception");
eHttpException.printStackTrace(System.err);
        }
        catch (IOException eIOException)
        {
System.err.println("there was an IO Exception");
eIOException.printStackTrace(System.err);
        }
        finally
        {
            postMethod.releaseConnection(); 
        }
    }

    public static void main(String[] args)
    {
        new HttpClientTest().testServletGet("http://localhost:8080/servletTesting/servlet/OMORSServlet");
    }
}
