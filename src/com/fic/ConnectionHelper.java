package com.fic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

/**
 * @author brekha
 * This is a repeation of the ConnectionHelper class in ejbTesting
 */
public class ConnectionHelper 
{
	private static Map<String, Object> allLookUpObjects = new HashMap<String, Object> ();
	
	private static final String DATASOURCE_KEY = "DATASOURCE_KEY";
	private static final String DS_LOOKUPNAME = "FAWSDATASOURCE";

	//take connection from datasource
	public static Connection getConnection ()
		throws SQLException
	{
		if (null != allLookUpObjects.get (DATASOURCE_KEY))
		{
			return ((DataSource)allLookUpObjects.get (DATASOURCE_KEY)).getConnection ();
		}
		
		try
		{
			Context context = new InitialContext ();
System.out.println(context.getEnvironment());			
			Object obj = context.lookup (DS_LOOKUPNAME);
System.out.println("\n\nDATASOURCE NAME :: " + obj.getClass().getName());			
			allLookUpObjects.put (DATASOURCE_KEY, obj);
			Connection connection = ((DataSource)obj).getConnection ();
System.out.println("\n\nCONNECTION NAME :: " + connection.getClass().getName());			
			return ((DataSource)obj).getConnection ();
		}
		catch (NamingException eNamingException)
		{
			throw new RuntimeException (eNamingException);
		}
	}
	
	public static void testDataFetchThroPS ()
		throws SQLException
	{
		Connection connection = getConnection();
		PreparedStatement pr = connection.prepareStatement("Select offering from offering where offering_id = 76");
		//PreparedStatement pr = connection.prepareStatement("Select * from partner where partner_id = 81");
		ResultSet rs = pr.executeQuery();
		
		while (rs.next())
		{
System.out.println("OFFERING NAME : " + rs.getString("offering"));			
		}
		
		rs.close();
		pr.close();
		connection.close();
	}
	
	public static void testDataFetchThroCS ()
		throws SQLException
	{
		Connection connection = getConnection();
		CallableStatement cs = connection.prepareCall("{call UP_GET_StatE(?)}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		
		int returnValue = cs.executeUpdate();
		
System.out.println("return value : " + returnValue);

		ResultSet rs = (ResultSet)cs.getObject(1);

		rs.close();
		cs.close();
		connection.close();
	}
	
	public static void main(String[] args)
	{
		try
		{
			ConnectionHelper.testDataFetchThroPS();
		}
		catch (Exception exception)
		{
exception.printStackTrace(System.err);			
		}
	}

}
