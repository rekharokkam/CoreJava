package com.gapinc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TradeStoneRestServiceClient
{
	public static void main(String[] args)
	{
		try
		{
			System.setProperty("javax.net.ssl.keyStore", "jssecacerts");
			System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
			System.setProperty("javax.net.ssl.trustStore", "jssecacerts");
			// System.setProperty("javax.net.ssl.trustStorePassword",
			// "changeit");
			System.setProperty("javax.net.ssl.keyStoreType", "jks");

			URL url = new URL(
					"https://devkey.tradestonesoftware.com/services/resource/generatekey");
			System.out
					.println("Before opening the connection with the remote server");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out
					.println("After opening the connection with the remote server");

			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			System.out
					.println("After setting some default attributes on the connection object");
			String input = "<?xml version='1.0' encoding='UTF-8'?>"
					+ "<tradestone_key>" + "<owner></owner>"
					+ "<partyId></partyId>" + "<partyType></partyType>"
					+ "<validity></validity>" + "<noUsers></noUsers>"
					+ "<userId></userId>" + "<userEmailId></userEmailId>"
					+ "<companyName></companyName>" + "<emailId></emailId>"
					+ "<country></country>" + "<renewal></renewal>"
					+ "<accessKeyId></accessKeyId>" + "<signature></signature>"
					+ "</tradestone_key>";

			System.out
					.println("Before output stream is extracted from connection");
			OutputStream os = conn.getOutputStream();

			os.write(input.getBytes());
			os.flush();

			int responseCode = conn.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			if (responseCode != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null)
			{
				System.out.println(output);
			}
			conn.disconnect();

		} 
		catch (MalformedURLException e)
		{

			e.printStackTrace(System.err);

		} 
		catch (IOException e)
		{
			e.printStackTrace(System.err);
		}
	}
}
