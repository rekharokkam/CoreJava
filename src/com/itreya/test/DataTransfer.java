/*
 *  @ Datatransfer.java 5/12/2001
 *
 */

package com.itreya.test;

import java.sql.*;
import java.util.*;

/**
 * This class is used for data transfer from one database to another
 * Here Data is transferred from Access Database to Sybase Database
 * To fetch the data from Access database Jdbc - Odbc Driver is used 
 * To insert the data into Sybase database Merant Driver is used
 * 
 * @version 1.0
 * @author Rekha Murthy
 */

class Datatransfer{
	
	/* This class will have Two methods One for fetching the data from Access 
	   And another for inserting those values to the sybase table	
	*/
	

	/**
	 * This method fetches the data from the Access table and puts it into a vector
	 * @param nothing
	 * @return Vector containing the String arrays of all the columns of the Access database
	 * @exception SQL Exception
	 * @see Exception
	 */
	
	private Vector vecAllRows = new Vector();
	
	/**This method fetches the data from the Access table and stores it in the Vector object
	 * It uses Jdbc - Odbc Driver to connect to the Data Source "Experience Triangle" which is mapped to an mdb file containing the 
	 * required data to be transferred this method can be used by only this class not any other class
	 * It returns the data in the form of vector with each of the element of the vector representing a column Array of the Access table
	 */
	
	private Vector dataFromAccess(){
		
		Connection con = null;
		ResultSet rs = null;
		
		try
		{
			
			//First connects to the Access Database using Jdbc Odbc Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");				
			con = DriverManager.getConnection("jdbc:odbc:LTC");			
			
			Statement stmt = con.createStatement();			
			String strQuery = "SELECT Field6,Field7,Field8,Field9 FROM SHEET1";			
			//String strQuery = "SELECT * FROM ExperienceTriangle";
			//String strQuery = "SELECT * FROM ToBeMigrated";
			System.out.println("\n\nAfter the Statement is made \n\n");
			rs = stmt.executeQuery(strQuery);	//executes the select statement to fetch the data from the Access Table
			System.out.println("\n\nAfter the Statement is executed \n\n");
			
			/*
			ResultSetMetaData rsmd = rs.getMetaData();
			int iColCount = rsmd.getColumnCount();
			String strLabel = null;
			
																													   
			for (int iCol = 1; iCol <iColCount; iCol++)
			{
				System.out.println("ColumnName : " + rsmd.getColumnName(iCol));
			}*/		
			
			
			int i = 0;
			
			//Each of the string arrays holds values for each column of the Database table
			String strField6[] = new String[99];
			String strField7[] = new String[99];
			String strField8[] = new String[99];
			String strField9[] = new String[99];
			//String strSumOfIBNRArr[] = new String[2199];
			
			
			//the data from the result set is put into each of the String arrays
			while(rs.next())
			{
				
				strField6[i] = rs.getString(1);
				strField7[i] = rs.getString(2);
				strField8[i] = rs.getString(3);
				strField9[i] = rs.getString(4);				
				
				//System.out.println("\n\t"+strField6[i]+"\t\t"+strField7[i]+"\t\t"+strField8[i]+"\t\t"+strField9[i]+"\n");				
				i = i+1;				
			}	
				
			System.out.println("\n\nthe number of rows is \t\t"+i+"\n\n");		
			
			
			//All the String arrays containing columns values are put into the vector			
			vecAllRows.addElement(strField6);
			vecAllRows.addElement(strField7);
			vecAllRows.addElement(strField8);
			vecAllRows.addElement(strField9);			
			
			System.out.println("\nThe length of the array is \t"+vecAllRows.size()+"\n");
			
			
			
			
		}catch(Exception e){
			System.out.println("\n\nThere is an error \n");
			e.printStackTrace();
			
		}			
		
		 finally{
			 try{
				 if ((con!=null)&&(rs!=null)){
					con.close();
					//rs.close();
				}
			 }catch(Exception ex){
				 ex.printStackTrace();
			 }
		 }
		return vecAllRows;		
		
	}
	
	/**
	 * This Method takes the data from the dataFromAccess method and puts them to Sybase dataabse
	 * This method uses Merant driver for database connectivity to Sybase
	 * @param nothing
	 * @return nothing void
	 * @exception 
	 * @see 
	 */
	public void datatoSybase(){
		
		Connection con = null;
		ResultSet rs = null;
		
		//these string arrays are for storing the column values of the access tables 
		//fecthed from the dataFromAccess method
		String UA_UserNameArr[] = null;
		String UA_AnnotationArr[] = null;
		String UA_BookMarkArr[] = null;
		String UA_Impairment_NameArr[] = null;
		
		
		//The method dataFromAccess returns a vector contaning string arrays which contain the column values of the access table
		//this vector is used to hold the vector returned by the method dataFromAccess
		Vector vecAllColumns = dataFromAccess();
		
		try{
			
			//establish the connection with sybase database using the merant driver for sybase
			Class.forName("com.merant.datadirect.jdbc.sybase.SybaseDriver");			
			System.out.println("\n\nthis is after the Classforname method for sybase table\n\n");
			con = DriverManager.getConnection("jdbc:sybase://192.168.168.176:5000;databasename=LTC;user=sa");								
			System.out.println("\n\nthis is after the connection is established for sybase table\n\n");							
			
			//To insert data into every column and every row of the sybase table
			PreparedStatement ps = con.prepareStatement("INSERT INTO USER_ATTRIBUTE (UA_UserName,UA_Annotation,UA_BookMark,UA_Impairment_Name) values (?,?,?,?)");			
			
			//the string arrays from the vector are stored into the instance string arrays 
			if (vecAllColumns!=null){
				UA_UserNameArr = (String[])vecAllColumns.elementAt(0);					
				UA_AnnotationArr = (String[])vecAllColumns.elementAt(1);
				UA_BookMarkArr = (String[])vecAllColumns.elementAt(2);
				UA_Impairment_NameArr = (String[])vecAllColumns.elementAt(3);
			
				
			}
			//if the vector contanining the string arrays having the column values of the access table is null 
			//then there is some serious error and futhur processing cannot be done
			else{
				System.out.println("\nthe data is not transferred properly to the sybase\n");
				System.exit(0);
			}
			
			System.out.println("\nthe length of each array is UA_UserNameArr\t"+UA_UserNameArr.length+"\tUA_AnnotationArr\t"+UA_AnnotationArr.length+"\tUA_BookMarkArr\t"+UA_BookMarkArr.length+"\tUA_Impairment_NameArr\t"+UA_Impairment_NameArr.length+"\n");
			
			//the preparted statement is set with the data from the string arrays
			
			for(int j=0;j<UA_UserNameArr.length;j++){
				System.out.println("\nThis is with in the loop\t"+j);
				ps.setString(1,UA_UserNameArr[j]);
				ps.setString(2,UA_AnnotationArr[j]);
				ps.setString(3,UA_BookMarkArr[j]);
				ps.setString(4,UA_Impairment_NameArr[j]);			
				
				try{
					//the statement is executed every time to insert values into the sybase table
					ps.executeUpdate();					
				}catch(Exception e){
					System.out.println("\n\nThere is an error in the inner try block while the prepared statement is executed\n\n");
					e.printStackTrace();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 finally{
		    try{
		   	 if ((con!=null)&&(rs!=null)){
		   		con.close();
		   		//rs.close();
		   	}
		    }catch(Exception ex){
		   	 ex.printStackTrace();
		    }
		}
	
	}
	
	/**
	 * This method is used only for viewing the sybase table values poppulated 
	 * from the access table
	 */
	void sybaseDataViewing(){
		
		Connection con = null;
		ResultSet rs = null;
		
		try
		{
			
			Class.forName("com.merant.datadirect.jdbc.sybase.SybaseDriver");			
			System.out.println("\n\nthis is after the Classforname method for sybase table\n\n");
			con = DriverManager.getConnection("jdbc:sybase://192.168.168.176:5000;databasename=ExperienceTriangle;user=sa");								
			System.out.println("\n\nthis is after the connection is established for sybase table\n\n");							
					
			
			Statement stmt = con.createStatement();			
			//String strQuery = "SELECT UA_UserName,UA_Annotation,UA_BookMark,UA_Impairment_Name FROM USER_ATTRIBUTE";
			String strQuery = "SELECT name,age FROM DUMMYTABLE";									
			//String strQuery = "SELECT * FROM SUMMARY_DATA";						
			rs = stmt.executeQuery(strQuery);	//executes the select statement to fetch the data from the Access Table			
			
			/*
			ResultSetMetaData rsmd = rs.getMetaData();
			int iColCount = rsmd.getColumnCount();	
			
			System.out.println("\nthe number of columns in the database are\t"+iColCount+"\n");
																													   
			for (int iCol = 1; iCol <=iColCount; iCol++)
			{
				System.out.println("ColumnName : " + rsmd.getColumnName(iCol));
			}*/		
			
			int i = 0;		
			
			//the data from the result set is put into each of the String arrays
			while(rs.next())
			{
				
				//System.out.println("\n\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)
				//				   +"\t\t"+rs.getString(4)+"\n");
				System.out.println("\n\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\n");
								   
				i = i+1;				
			}		
				
			System.out.println("\n\nthe number of rows is \t\t"+i+"\n\n");
	
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
		    try{
		   	 if ((con!=null)&&(rs!=null)){
		   		con.close();
		   		//rs.close();
		   	}
		    }catch(Exception ex){
		   	 ex.printStackTrace();
		    }
		}
	}
	
	
	
	public static void main(String args[]){
		Datatransfer data = new Datatransfer();
		//data.datatoSybase();
		data.sybaseDataViewing();
		//data.dataFromAccess();
	}
	
	
	
}