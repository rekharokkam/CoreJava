package com.gapinc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TradestonePreProdDBConnectivityTest
{
	private void testConnection ()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    String url ="jdbc:oracle:thin:@pgphxcstdb006.phx.gapinc.com:1521:TDSRPTP1";
			Connection con= DriverManager.getConnection(url, "tdsapp", "chang3m3");
			
			String query = "select VERSION from tss_version";
			
			Statement stmt = con.createStatement();
			if (stmt.execute(query)) 
			{
				ResultSet rs = stmt.getResultSet();
				if (null != rs)
				{
					while (rs.next())
					{
System.out.println (rs.getString("VERSION"));
					}
				}
			}
		}
		catch (Exception eSQLException)
		{
System.err.println ("Exception occured while trying to connect to Tradestone Pre-Prod DB TDSRPTP1");			
			eSQLException.printStackTrace ();
		}		
	}
	
	public static void main(String[] args)
	{
		new TradestonePreProdDBConnectivityTest().testConnection();
	}
}
