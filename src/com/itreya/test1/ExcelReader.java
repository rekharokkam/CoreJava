/**This class reads the data from the excel file "c:\TWTriangleTest.xls"
 */

package com.itreya.test1;

import java.sql.*;
import java.util.*;

public class ExcelReader
{
	
	/**This method establishes the connection with the Excel bookwork 
	 * and returns the connection object
	 */
	
	public Object excelResult()
	{
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;		
		ArrayList allRows = new ArrayList();
			
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:ExperienceTriangle");
			//System.out.println("\nafter the connection is established\n");
			
			stat = con.createStatement();
			String strQuery = "SELECT * FROM [ExperienceTriangle$]";
			rs = stat.executeQuery(strQuery);
			
			rsmd = rs.getMetaData();
			int iColumnCount = rsmd.getColumnCount();
			//System.out.println("\nThe number of columns is\t"+iColumnCount+"\n");
			
			int iDataCount = 0;
			while(rs.next())
			{				
				HashMap eachRow = new HashMap();
				for (int i = 1; i<=iColumnCount;i++)
				{
					eachRow.put(rsmd.getColumnName(i),rs.getString(i));					
				}
				allRows.add(eachRow);								
				iDataCount++;
			}
			
			//System.out.println("\nthe number of data rows is\t"+iDataCount+"\n");
		}
		catch(Exception se)
		{
			System.out.println("AN error during transaction\n");
			se.printStackTrace();
		}		
		
		finally
		{
			try
			{
				if (null!=con)
				{
					con.close();
				}
				
				if (null!=stat)
				{
					stat.close();
				}
				
				if (null!=rs)
				{
					rs.close();
				}			
				
			}
			catch(SQLException e)
			{
				System.out.println("\nAn error during the closing of the connection \n");
				e.printStackTrace();				
			}
		}
		
		return allRows;
	}
	
	/*
	public static void main (String args[])
	{
		ExcelReader reader = new ExcelReader();
		ArrayList result = (ArrayList)reader.excelResult();		
		System.out.println("\nthe number of results from the hasmap is\t"+result.size()+"\n");		
	}*/
}

