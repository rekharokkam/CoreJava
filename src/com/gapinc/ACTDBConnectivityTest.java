package com.gapinc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ACTDBConnectivityTest
{
	private void testConnection ()
	{
		try
		{
		    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		    String url ="jdbc:sqlserver://USRCCDBP84GAPW.americas.gap.com:1520;databaseName=ACT2";
			Connection con= DriverManager.getConnection(url, "s_act", "g@p@ct");
			
			String query = "select top 10 * from T_TRN_STYLE where sty_nbr='319544'";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		
			if (null != rs )
			{
				while (rs.next())
				{
System.out.println (rs.getInt("STY_ID"));
				}
			}
		}
		catch (Exception eSQLException)
		{
System.err.println ("Exception occured while trying to connect to ACT DB");			
			eSQLException.printStackTrace ();
		}		
	}
	
	
	public static void main(String[] args)
	{
		new ACTDBConnectivityTest().testConnection();
	}
}
