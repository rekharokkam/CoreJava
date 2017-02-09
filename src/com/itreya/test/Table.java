package com.itreya.test;

import java.sql.*;


/**This class demonstrates the table creation 
 * @author Rekha Murthy
 * @version 1.0
 */
public class Table
{	
	private void testConnection ()
	{
		try
		{
/*			
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url ="jdbc:odbc:TestDS";
*/
		    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		    String url ="jdbc:sqlserver://localhost:1433;databaseName=Test";
			Connection con= DriverManager.getConnection(url, "sa", "roopa");
			
			String query = "select  *  from  employee  where  employee_name  =  ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "a");
			
			ResultSet rs = stmt.executeQuery ();
			if (null != rs && rs.next() )
			{
System.out.println (rs.getInt ("employee_id"));				
			}
		}
		catch (Exception eSQLException)
		{
System.err.println ("IN THE EXCEPTION BLOCK");			
			eSQLException.printStackTrace ();
		}		
	}
	
	public void testEmployeeCallableStmt ()
	{
        Connection connection = null;
        CallableStatement callableStmt = null;
        try
        {
		    Class.forName("weblogic.jdbc.sqlserver.SQLServerDriver");
		    String url ="jdbc:sqlserver://localhost:1433;databaseName=Test";
		    connection = DriverManager.getConnection(url, "sa", "roopa");

		    connection.setAutoCommit(false);
    	    callableStmt = connection.prepareCall("{call insertEmployeeFullDetails(?, ?, ?, ?, ?)}");
	        	    
    	    callableStmt.setInt(1, 30);
    	    callableStmt.setString(2, "Umesh");
	        	    
    	    callableStmt.setInt(3, 3);
    	    callableStmt.setString(4, "jayanagar");
    	    
    	    callableStmt.registerOutParameter(5, Types.INTEGER);
	        	    
	        callableStmt.execute();
	        
System.out.println("callable stmt out put : " + callableStmt.getInt(5));	        
       	}
        catch (Throwable exception)
        {
exception.printStackTrace(System.err);
			try
			{
			    connection.rollback();
			}
			catch (SQLException eSQLException)
			{
eSQLException.printStackTrace(System.err);			    
			}
        }
        finally
        {	    
            try
            {
                if (null != callableStmt)
                {
                    callableStmt.close();
                }
                if (null != connection)
                {
                    connection.close();
                }
            }
            catch (SQLException eSQLException)
            {
eSQLException.printStackTrace(System.err);                
            }
        }
	        	    
        System.out.println("after the callable stmt for inserting employee is called");		
	}
	
	public static void main(String args[])
	{
		new Table().testEmployeeCallableStmt();
//System.out.println("here");	    
	}
}