package com.itreya.test;

import java.sql.*;

public class Scrollable_ResultSet
{
	void scroll()
	{
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
		try
		{
			Class.forName("weblogic.jdbc.sqlserver.SQLServerDriver");
			String url = "jdbc:bea:sqlserver://localhost:1433;databaseName=Test";
			connection = DriverManager.getConnection(url,"sa","rekha");
			
			stmt = connection.createStatement();
			String sequel = "SELECT * FROM EMPLOYEE";
			rs = stmt.executeQuery(sequel);
			
			if (rs.next())
			{
System.out.println("data exists");			    
			}
			else
			{
System.out.println("No Data");			    
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		    if (null != connection)
		    {
		        try
		        {
		            connection.close();
		        }
		        catch (SQLException eSQLException)
		        {
		            //doNothing
		        }
		    }
		}
	}
	public void getEmployeeDetails (long employeeId)		
	{
System.out.println("Inside the getEMployeeDetails Method of SQLDAOImpl class : " + employeeId);
		Connection connection = null;
		CallableStatement callableStmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("weblogic.jdbc.sqlserver.SQLServerDriver");
			String url = "jdbc:bea:sqlserver://localhost:1433;databaseName=Test";
		    
//		    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//		    String url ="jdbc:sqlserver://localhost:1433;databaseName=Test";
		    
			connection = DriverManager.getConnection(url,"sa","rekha");
			
		    callableStmt = connection.prepareCall("{call getEmployeeDetails (?, ?, ?, ?)}");
		    
		    callableStmt.setLong(1, employeeId);
		    
		    callableStmt.registerOutParameter(2, Types.VARCHAR);
		    callableStmt.registerOutParameter(3, Types.NUMERIC);
		    callableStmt.registerOutParameter(4, Types.VARCHAR);
		    
		    callableStmt.execute();
		    
		    
		    String employeeName = callableStmt.getString(2);
		    long employeeAddressId = callableStmt.getLong(3);
		    String employeeAddress = callableStmt.getString(4);
		    
System.out.println("employee details are : " ); 
System.out.print("\t" + employeeName);
System.out.print("\t" + employeeAddressId);
System.out.print("\t" + employeeAddress);
	
		}
		catch (Exception exception)
		{
System.err.println("there was an exception during the get employee details");
exception.printStackTrace(System.err);
		}
		finally
		{
		    if (null != connection)
		    {
		        try
		        {
		            connection.close();
		        }
		        catch (SQLException eSQLException)
		        {
		            //doNothing
		        }
		    }
		}
	}	
	public static void main(String args[])
	{
		Scrollable_ResultSet scro_res = new Scrollable_ResultSet();
		scro_res.getEmployeeDetails(11);
	}
}