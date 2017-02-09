package com.itreya.test;

import java.sql.*;


public class PreparedStatementDemo
{
	
	/**this method does the actual demonstration of the prepared statements
	 * @param nothing
	 * @return nothing
	 * @exception SQLException
	 * @see	java.sql.SQLException
	 */
	void prepare_statement()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.168.4:1521:itreya";
			Connection con = DriverManager.getConnection(url,"prime","prime");
			
			/*PreparedStatement ps = con.prepareStatement("INSERT INTO TPNMA_USERADDRESS VALUES(?,?,?)");
			int ids [] = {300,301,302};
			String names[]= {"ELECTRONICS LEARNING","ZAMBIA","PRIME"};	
			String address [] ={"HOUSE","SCHOOL","COLLEGE"};
			
			for(int i=0;i<names.length;i++)
			{
				ps.setInt(1,ids[i]);
				ps.setString(2,names[i]);
				ps.setString(3,address[i]);
				ps.executeUpdate();
				
			}		
			
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM TPNMA_USERADDRESS";	
			
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next())
			{			
				String id = rs.getString(1);
				int id1 = Integer.parseInt(id);		
			
				String strname = rs.getString(2);
				String strrole = rs.getString(3);
			
				System.out.println("\n\t\t"+id1+"\t"+strname+"\t"+strrole+"\n");	
			}*/
			
			Statement stmt = con.createStatement();
			
			String strQuery = "select name from tpnma_useraddress b,tpnma_tpnuser a where a.userid=b.userid and b.addresstype='PRIME'";
			
			
			ResultSet rs = stmt.executeQuery(strQuery);
			
			while(rs.next())
			{
				String name = rs.getString(1);
				System.out.println("\n"+name+"\n");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	}
	
	public static void main(String args[])
	{
		PreparedStatementDemo demo = new PreparedStatementDemo();
		demo.prepare_statement();
	}
}