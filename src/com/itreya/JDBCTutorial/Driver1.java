package com.itreya.JDBCTutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver1
{
	
	private Connection con;
	private static final String URL = "jdbc:odbc:Pagination";
	private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	
	private static void establishConnection (Connection a_con)
	{
		try
		{
			Class.forName(DRIVER);
			a_con = DriverManager.getConnection(URL);
		}
		catch (ClassNotFoundException eCLass)
		{
			System.err.println ("Driver Class could not be found");
			eCLass.printStackTrace();
		}
		catch (SQLException eSQL)
		{
			System.err.println ("SQL Exception during the fetching of the connection from driver");
			eSQL.printStackTrace();
		}
	}
	
	private static void closeConnection (Connection con )
	{
		if (null != con)
		{
			try
			{
				con.close();
			}
			catch (SQLException esql)
			{
				System.err.println("An SQL Exception during the closing of connection");
				esql.printStackTrace();
			}
		}
	}
	
	public static void main (String args[])
	{
		Driver1 driver1 = new Driver1();
		establishConnection(driver1.con);
		closeConnection(driver1.con);		
		
	}
}
