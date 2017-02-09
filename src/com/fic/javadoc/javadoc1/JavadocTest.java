package com.fic.javadoc.javadoc1;

import java.io.IOException;
import java.util.Date;

/**
 * This class is for testing the javadocs
 * <br>
 * This is the second line of comments 
 * 
 * @author brekha
 * @version 1.0
 */

public class JavadocTest
{

    /**
     * Th.
     * is is the first variable
     */
    public final String name = "rekha";
    
    /**
     * this is the second variable 
     * @see #name
     */
    public final String address = "nagendra block";

    /**
     * This. is the test method with param and return attributes
     * 
     * @param name a name attribute {@link JavadocTest2}.
     * @return an int representing a dummy integer
     * @see JavadocTest2     
     */
    public int test(String name)
    {        
        return 0;
    }

    public JavadocTest(String name)
    {        
    }
    
    /**
     * just a test method to test the different tag order.
     *  
     * @param a an int parameter
     * @param name junk name
     * @return 
     * @throws IOException If in case there is an out bound rules violation
     * @version 2.0
     * @author roopa 
     * @see #name
     * @see #address
     * @see JavadocTest2
     * @see JavadocTest2#a
     * @see JavadocTest2#test(String)
     * @see <br><a href="http://mail.yahoo.com">MAIL </a>
     * @since 1.0
     * 
     */
    public String test (int a, String name)
    	throws IOException
	{
        throw new IOException ("IO exception created by me ");
	}
    
    /**
     * for testing each javadoc attribute.     
     *     
     * @param name
     * @param date 
     */
    public void tst(String name, Date date)
    {
        
    }
    
    /**
     * This method is for testing the depricated tag
     * 
     * @param a just an input parameter
     * 
     * @deprecated As of version 2.0, replaced with the new func 
     * 				{@link <a href="http://mail.yahoo.com">Link Attribute test</a>}
     * 				&nbsp;&nbsp;&nbsp;{@link #name}}
     */
    public void testDep (String a)
    {        
    }
    
    public void testDep1 (int x)
    {
        
    }
    
    public static void main(String[] args)
    {
    }
}
