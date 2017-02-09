package com.itreya.test;

import java.sql.*;

/**
 */
public class Batch
{
	void batch_update() throws BatchUpdateException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.168.4:1521:itreya";
			Connection con = DriverManager.getConnection(url,"prime","prime");
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			stmt.addBatch("INSERT INTO TPNMA_TPNUSER (userid,username,role) VALUES (307,'TPN','PROJECT LEAD')");
			//stmt.addBatch("INSERT INTO TPNMA_TPNUSER (username,role,userid) VALUES ('eCommunics','CEO',304)");
			//stmt.addBatch("INSERT INTO TPNMA_TPNUSER (username,role,userid) VALUES ('eNamics','DIRECTOR',305)");
			
			try
			{
			int updatecounts [] = stmt.executeBatch();
			con.commit();
			}
			catch(SQLException s)
			{
				con.rollback();
				s.printStackTrace();
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Batch batch= new Batch();
		try
		{
			batch.batch_update();
		}
		catch(BatchUpdateException b)
		{
			
			b.printStackTrace();
		}		
			
	}
}