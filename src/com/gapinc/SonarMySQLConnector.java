package com.gapinc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SonarMySQLConnector 
{
	private static final String SNAPSHOT_QUERY = 
			"select id as id, created_at as created, depth as depth, islast as islast, parent_snapshot_id as parent_snapshot_id, " +
//			"path as path, period1_date as period1_date," +
			//"period1_mode as period1_mode, period1_param as period1_param, period2_date as period2_date, period2_mode as period2_mode, period2_param as period2_param," +
			//"period3_date as period3_date, period3_mode as period3_mode, period3_param as period3_param, period4_date as period4_date, period4_mode as period4_mode," +
			//"period4_param as period4_param, period5_date as period5_date, period5_mode as period5_mode, period5_param as period5_param, 
			"qualifier as qualifier, project_id as project_id, " + 
//			"root_snapshot_id as root_snapshot_id, root_project_id as root_project_id, scope as scope, status as status, version as version" +
			"from sonar.snapshots where islast = true and id in (9255009, 9255324) ";

    private static Connection getConnection ()
    {
    	try
    	{
		    Class.forName("com.mysql.jdbc.Driver");
		    String url ="jdbc:mysql://ci.gap.dev:3306/sonar";
			return DriverManager.getConnection(url, "sonar", "sonar");
    	}
    	catch (Exception exception)
    	{
exception.printStackTrace(System.err);    		
    	}
    	return null;
    }

    private static void printAllTables (Connection databaseConnection)
    {
    	try
    	{
    		if (null != databaseConnection)
    		{
    			DatabaseMetaData databaseMetadata = databaseConnection.getMetaData();
    			ResultSet rs = databaseMetadata.getTables(null, null, "%", null);
    			while (rs.next())
    			{
System.out.println("Each table from sonar database : " + rs.getString("TABLE_NAME"));    				
    			}
    		}
    	}
    	catch (Exception exception)
    	{
exception.printStackTrace(System.err);    		
    	}
    	finally
    	{
    		try
    		{
    			if (null != databaseConnection)
    			{
    				databaseConnection.close();
    			}
    		}
    		catch (Exception exception)
    		{
exception.printStackTrace(System.err);    			    			
    		}
    	}
    }
    
    private static void printSnapShotRecords (Connection databaseConnection, int firstFewRecords)
    {
    	if (null != databaseConnection)
    	{
    		try
    		{
    			int rowCount = firstFewRecords;
    			Statement stmt = databaseConnection.createStatement();
    			stmt.setFetchSize(firstFewRecords);
    			if (stmt.execute(SNAPSHOT_QUERY)) 
    			{
    				ResultSet rs = stmt.getResultSet();
    				if (null != rs)
    				{
    					while (rs.next())
    					{
System.out.println("\n");
System.out.println(rowCount-- + " Record : ");
							StringBuilder sb = new StringBuilder();
							sb.append("\t ID : ").append(rs.getString("id"));
							sb.append("\t CREATED AT : ").append(rs.getString("created"));
							sb.append("\t DEPTH : ").append(rs.getInt("depth"));
							sb.append("\t IS_LAST : ").append(rs.getBoolean("islast"));
							sb.append("\t parent_snapshot_id : ").append(rs.getInt("parent_snapshot_id"));
							sb.append("\t project_id : ").append(rs.getString("project_id"));
System.out.println(sb);							
    					}
    				}
    			}    				
    		}
    		catch (Exception exception)
    		{
exception.printStackTrace(System.err);    			
    		}
        	finally
        	{
        		try
        		{
        			if (null != databaseConnection)
        			{
        				databaseConnection.close();
        			}
        		}
        		catch (Exception exception)
        		{
    exception.printStackTrace(System.err);    			    			
        		}
        	}
    	}
    }
    
	public static void main(String[] args) 
	{
		Connection sqlConnection = getConnection();		
System.out.println("Connection Object was obtained successfully");
		printSnapShotRecords (sqlConnection, 25);
	}
}
