package com.gapinc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ACTPlanningServiceConnectivity
{
	public static void main(String[] args)
	{
		 try 
		 {
			 
			URL url = new URL("http://plnsvc.gapinc.com:4080/planning-service/targets");
System.out.println("Before opening the connection with the remote server");			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
System.out.println("After opening the connection with the remote server");			
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
System.out.println("After setting some default attributes on the connection object");	 
			String input = "{" +
					"'ts': '2013-05-07T15:41:03.432Z'," +
					"'resource': {" +
					"'targets': [" +
					"{" + 
					"'market': 'USA'," +
					"'channel':'Retail'," + 
					"'destinationCountry':'HK'," +
					"'itemId': '123456789'," +
					"'ccId': '123456789012'," +
					"'year': 2013," +
					"'qty': 150," +
					"'season':'SP'," +
					"'fiscalWeek':'5'" +
		 			"},{" +
		 			"'market': 'USA'," +
		 			"'channel':'Retail'," +
		 			"'destinationCountry':'HK'," +
		 			"'itemId': '123456789'," +
		 			"'ccId': '123456789012'," + 
		 			"'year': 2013," +
		 			"'qty': 100," +
		 			"'season':'SP'," +
		 			"'fiscalWeek':'6'" + 
		 			"}" + 
		 			"]" +
		 			"}" +
		 			"}" ;
			

System.out.println("Before output stream is extracted from connection");
			OutputStream os = conn.getOutputStream();
			
			os.write(input.getBytes());
			os.flush();
	 
			int responseCode = conn.getResponseCode();
System.out.println("Response Code : " + responseCode);			
			
			if (responseCode != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
System.out.println(output);
			}	 
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace(System.err);
	 
		  } catch (IOException e) {
	 
			e.printStackTrace(System.err);
	 
		 }	
	}
}
