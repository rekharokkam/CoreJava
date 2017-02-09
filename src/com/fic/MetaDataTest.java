package com.fic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/**
 * @author brekha
 */
public class MetaDataTest
{
    private static MetaDataTest rowSetHelper;
    
    public static MetaDataTest getRowSetHelper ()
    {
        if (null == rowSetHelper)
        {
            rowSetHelper = new MetaDataTest();
        }
        return rowSetHelper;
    }
    
    private MetaDataTest()
    {        
    }
    
    private Connection getConnection ()
    	throws Exception
    {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url ="jdbc:oracle:thin:@192.168.85.6:1521:faws";
		return DriverManager.getConnection(url, "wf_66_vtmp_02", "wf_66_vtmp_02");        
    }
    
    private void testTableMetadata()
    {
        try
        {
            Connection conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
System.out.println(metaData.getDriverName() + ", version : " + metaData.getDriverVersion());
			ResultSet rs = metaData.getSchemas();
			while (rs != null && rs.next())
			{
System.out.println(rs.toString());			    
			}
System.out.println(metaData.supportsTransactions());			
        }
        catch (Exception e)
        {
System.err.println("there was an unexpected exception");
e.printStackTrace(System.err);
        }
    }
    
    private void testTableColumnInfo ()
    {
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from workflow_context_type where 1 = 0");
            pstmt.execute();
            ResultSetMetaData metaData = pstmt.getMetaData();
System.out.println("# of columns : " + metaData.getColumnCount());
System.out.println("first columns : " + metaData.getTableName(1));
        }
        catch (Exception e)
        {
System.err.println("THERE WAS AN EXCEPTION ");
e.printStackTrace(System.err);
        }
    }
    
    public static void main(String[] args)
    {
        getRowSetHelper().testTableColumnInfo();   
    }
}
