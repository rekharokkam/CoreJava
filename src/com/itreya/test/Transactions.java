package com.itreya.test;

import java.sql.*;

/**This class is only for database transactions deomnstraions
 * @author Rekha Murthy
 * @version	1.2
 */
public class Transactions
{
	
	void trans()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.168.4:1521:itreya";
			Connection con = DriverManager.getConnection(url,"prime","prime");
			con.setAutoCommit(false);
			
			
			PreparedStatement ps = con.prepareStatement("UPDATE TPNMA_TPNUSER SET USERNAME =? WHERE ROLE LIKE ?");
			PreparedStatement ps1 = con.prepareStatement("UPDATE TPNMA_USERADDRESS SET ADDRESSTYPE=? WHERE USERID LIKE ?");
			
			ps.setString(1,"MANAS");
			ps.setString(2,"ADMIN");
			
			ps1.setString(1,"ELECTRONICS");
			ps1.setInt(2,300);
			
			try
			{
				System.out.println("\n\nTHIS IS WITH IN THE TRY BLOCK\n\n");
				ps.executeUpdate();			
				ps1.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
				System.out.println("\nthis is after the two update statement\n\n");
				
			}
			
			catch(Exception e)
			{
				
				System.out.println("\n\nthis is with in the first catch block \n\n");
				con.rollback();
				e.printStackTrace();
			}		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String args[])
	{
		Transactions trans1 = new Transactions();
		trans1.trans();
	}
}
