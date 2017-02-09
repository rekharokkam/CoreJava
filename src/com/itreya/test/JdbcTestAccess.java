/*this is for Merant Driver for Access database*/

package com.itreya.test;

import java.sql.*;
import java.util.*;

class JdbcTestAccess{
	
	/* this method first connects to the Access database and fetches the data from the table
	   ProgramTrianglesDataSummary and then puts it to the database */
	
	
	void test(){
		
		Connection con = null;
		Statement stmt;
		ResultSet rs;
		ResultSetMetaData metaData;
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				
			con = DriverManager.getConnection("jdbc:odbc:LTC");						 			
			stmt = con.createStatement();
			String query = "SELECT * FROM SHEET1";			
			rs = stmt.executeQuery(query);		
			
			metaData = rs.getMetaData();
			
			int iColumnCount = metaData.getColumnCount();
			//System.out.println("\niColumnCount\t"+iColumnCount);
			//System.out.println(metaData.getColumnType(1));
			for(int i=1;i<=iColumnCount;i++)
			{
				
				System.out.println("\n"+metaData.getColumnName(i)+"\t"+metaData.getColumnType(i)+"\n");				
			}	
		
		
		}
		catch(Exception e){
			System.out.println("\n\nthere is an error\n\n");
			e.printStackTrace();
		}
		finally
		{
			if (null!=con)
			{
				try{
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}			
		}			
	}
	
	public static void main (String args[]){
		JdbcTestAccess te = new JdbcTestAccess();
		te.test();
		
	}
	
}