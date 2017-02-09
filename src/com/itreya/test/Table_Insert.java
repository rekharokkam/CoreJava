package com.itreya.test;

import java.sql.*;


/**This class demonstrates Inserting values into table 
 * @author Rekha Murthy
 * @version 1.0
 */
public class Table_Insert
{
	
	void table_create()
	{
		
		try
		{
			Class.forName("weblogic.jdbc.mssqlserver4.Driver");
			String url ="jdbc:weblogic:mssqlserver4:TEST@192.168.168.16";
			Connection con= DriverManager.getConnection(url,"sa","");
			con.setAutoCommit(false);
			
		
			
			
			/* this part of the code is for inserting the values into the 
			Employee and COmpany tables created only four rows are inserted*/
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?)");					
			
			/* Take the ids from the table company and insert the ids of tat table into the table employee
			*/
			
			Statement stmt = con.createStatement();
			String sequel = "SELECT * FROM COMPANY where company_name like 'Itreya'";			
			ResultSet rs = stmt.executeQuery(sequel);			
			rs.next();			
			String id_com = rs.getString(1);
			int company_id1 = Integer.parseInt(id_com);							
			int ids_emp[] = {200,201,202,203};
			String names[]={"Max","Heidi","Clara","Adelide"};
			String address[]={"#773 100 ft.Road Indiranagar","#774 101 ft.Road Hal III stage","#775 102 ft.Road Indiranagar","#776 103 ft.Road Hal II stage"};
			String email[] = {"max@itreya.com","heidi@itreya.com","clara@itreya.com","adelide@itreya.com"};
			String phone[]={"5266100","5266101","5266102","5217274"};
			
			
			for(int i=0;i<names.length;i++)
			{	
				
				ps.setInt(2,company_id1);
				ps.setInt(1,ids_emp[i]);
				ps.setString(3,names[i]);
				ps.setString(4,address[i]);
				ps.setString(5,email[i]);
				ps.setString(6,phone[i]);
			
				try
				{
					
					ps.executeUpdate();
					con.commit();
					System.out.println("\n this is after the insertions are successful\n\n");
					
				}
				catch(Exception e)
				{
					System.out.println("\nTHIS IS WITH IN THE INNER CATCH BLOCK\n");
					con.rollback();
					e.printStackTrace();
				}
			}
			
			
			// this is selecting the inserted statements from the table 
			
			Statement stmt1 = con.createStatement();
			String sequel1 = "SELECT * FROM EMPLOYEE";
			
			ResultSet rs1= stmt1.executeQuery(sequel1);
			System.out.println("\nTHIS IS THE FIRST RESULT SET CONTENTS OF THE TABLE COMPANY\n\n");
			
			while(rs1.next())
			{
				String id_emp = rs1.getString(1);
				int id_emp1 = Integer.parseInt(id_emp);
				
				String id_com1 = rs1.getString(2);
				int id_com11 = Integer.parseInt(id_com1);
				
				String name_emp = rs1.getString(3);
				String address_emp = rs1.getString(4);
				String email_emp = rs1.getString(5);
				String phone_emp = rs1.getString(6);
				System.out.println("EMPLOYEE Id : "+id_emp1+"\tCOMPANY ID : "+id_com1+"\tName : "+name_emp+"\tAddress : "+address_emp+"\tPhone : "+phone_emp+"\tEmail : "+email_emp+"\n");
			}	
			
		}
		catch(Exception e)
		{
			System.out.println("\nTHIS IS WITH IN THE EXTERNAL CATCH BLOCK\n");
			e.printStackTrace();
		}
	}
	
	
	/**this is the main method which creates an object of the class table and calls it's method
	 */
	public static void main(String args[])
	{
		Table_Insert tab = new Table_Insert();
		tab.table_create();
	}
}