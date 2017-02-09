package com.itreya.test;

import java.sql.*;

public class ResultSet_Update
{
	void update_result_set()
	{	
		try
		{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@192.168.168.4:1521:itreya";
				Connection con = DriverManager.getConnection(url,"prime","prime");
				
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query = "SELECT * FROM TPNMA_TPNUSER";
				ResultSet rs = stmt.executeQuery(query);				
				
				rs.last();				
				rs.updateString("username","PARK");
				rs.updateString("role","CTO");
				rs.updateRow();		
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		ResultSet_Update res = new ResultSet_Update();
		res.update_result_set();
	}
	
}
