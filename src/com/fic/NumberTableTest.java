package com.fic;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.driver.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * @author brekha
 */
public class NumberTableTest
{
    private Connection getConnection ()
    	throws Exception
    {
        Class.forName ("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@192.168.85.203:1521:DEVDB5", "ds", "ds");        
    }
    
    private void testCallableStmt()
    	throws Exception
    {
        //CallableStatement callableStmt = getConnection().prepareCall("{call date_test(?)}");
        CallableStatement callableStmt = getConnection().prepareCall("{call PKG_USER_PREFERENCES.get_releasenotes_popup(?, ?, ?)}");
        
        callableStmt.setLong(1, 121);
        callableStmt.registerOutParameter(1, OracleTypes.NUMBER);
        
        callableStmt.registerOutParameter(2, OracleTypes.VARCHAR);
        callableStmt.registerOutParameter(3, OracleTypes.NUMBER);
        callableStmt.execute();
        
//		ArrayDescriptor nDesc = new ArrayDescriptor("NUMBER_TABLE",getConnection());
//		long l[] = {2022, 10100259};
//		ARRAY pdPartyIds = new ARRAY(nDesc, getConnection(), l);
//		callableStmt.setArray(2, pdPartyIds); 
//        callableStmt.registerOutParameter(3, OracleTypes.CURSOR);
        
        
System.out.println("The return parameter : " + callableStmt.getInt(3));        
        
//        WLCachedRowSet deliveryRequestRowSet = null;
//        
//		deliveryRequestRowSet = new CachedRowSetImpl();
//		deliveryRequestRowSet.populate((ResultSet) callableStmt.getObject(1));
        
//        ResultSet rs = (ResultSet)callableStmt.getObject(1);
        
//        while (deliveryRequestRowSet.next())
//        {
//Timestamp timeStamp = deliveryRequestRowSet.getTimestamp(1);
//java.util.Date date = new java.util.Date (timeStamp.getTime());
//System.out.println(deliveryRequestRowSet.getString(1));       

//System.out.println("after formatting " + getDateFromString (deliveryRequestRowSet.getString(1), "MM/dd/yyyy HH:mm:ss"));
//        }
    }
    
    
    
    
    private void testResultSet ()
    	throws Exception
    {
//        PreparedStatement pstmt = getConnection().prepareStatement("select * from routing_account where PARTY_ID=1025");
        PreparedStatement pstmt = getConnection().prepareStatement("select * from REQUESTING_PARTY where order_product_id = 2093966");
        ResultSet rs = pstmt.executeQuery();
        if (null != rs && rs.next())
        {
            do
            {
                
//System.out.println("PARTY_ID : " + rs.getLong("PARTY_ID") + " , OFFERING : " + rs.getString("OFFERING") +
//        " , OFFERING_DESCRIPTION : " + rs.getString("OFFERING_DESCRIPTION"));                
System.out.println("first name = " + rs.getString("FIRST_NAME"));  
System.out.println("last name = " + rs.getString("LAST_NAME"));

//System.out.println("bundle_id : " + rs.getLong("bundle_id") + ", offering_id : " + rs.getLong("offering_id"));

//System.out.print("ROUTING_ACCOUNT_ID:" + rs.getLong("ROUTING_ACCOUNT_ID"));
//System.out.print("\tROUTING_ACCOUNT:" + rs.getString("ROUTING_ACCOUNT"));
//System.out.print("\tROUTING_ACCOUNT_DESCRIPTION:" + rs.getString("ROUTING_ACCOUNT_DESCRIPTION"));
//System.out.print("\tPARTY_ID:" + rs.getLong("PARTY_ID"));
//System.out.print("\tLOGIN_NAME:" + rs.getString("LOGIN_NAME"));
//System.out.print("\tPASSWORD:" + rs.getString("PASSWORD"));
//System.out.print("\tRECORD_StatUS_ID:" + rs.getInt("RECORD_StatUS_ID"));

System.out.println("\n\n");
            }while (rs.next());
        }
    }
    
    private void testNumberTableOutput ()
    	throws Exception
    {
        Connection connection = getConnection();
        CallableStatement cstmt = connection.prepareCall("{call test_array(?, ?)}");

        ArrayDescriptor nDesc = new ArrayDescriptor("NUMBER_TABLE",connection);
        ARRAY intArr = new ARRAY(nDesc, connection, new int[]{1, 2, 3});
        
        cstmt.setArray(1, intArr); 
         
        cstmt.registerOutParameter(2, OracleTypes.ARRAY, "VARCHAR2_100_TABLE");
        
        cstmt.execute();
System.out.println("done successfully");        
		
		Object junkArr = cstmt.getArray(2).getArray();
		String[] intArrOut = (String[])junkArr;
		for (int i = 0; i < intArrOut.length; i++) 
		{
System.out.println("each big decimal : " + intArrOut[i]);
        }
    }
    
    public static void main(String[] args)
    {
        try
        {
            new NumberTableTest().testCallableStmt();
        }
        catch (Exception e)
        {
System.err.println("there was an exception");
e.printStackTrace(System.err);
        }
    }
}
