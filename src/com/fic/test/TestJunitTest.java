/*
 * Created on Feb 21, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fic.test;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * @author Roopa Murthy
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestJunitTest extends TestCase
{
    private JunitTest junitTest;
    
    public TestJunitTest(String junittestcasename)
    {
        super (junittestcasename);
System.out.println("inside the constructor with argument");        
    }

    public TestJunitTest ()
    {
System.out.println("no argument");        
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
System.out.println("\n\nsetup");        
        junitTest = new JunitTest();
//        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
System.out.println("teardown");        
        junitTest = null;
//        super.tearDown();
    }

    public void testAddItem()
    {
System.out.println("add item ");        
        junitTest.addItem("name");
        assertEquals(1, junitTest.getCartItemsCount());
    }

    public void testGetCartItemsCount()
    {
System.out.println("inside the get cart items count method");
		junitTest.addItem("junky");
		assertEquals(1, junitTest.getCartItemsCount());
    }
    
    public void testGetCartItems()
    {
System.out.println("inside the getcart items method");
		junitTest.addItem("junky");
		boolean isCartEmpty = (junitTest.getCartItems().size() > 0);
		assertTrue(isCartEmpty);
    }
    
    public void testException() 
    	throws IOException
    {
System.out.println("Inside the testException method");
    	junitTest.exception();
	    fail ("If this line is reached then there the test case has failed");
    }
    
    public static void main(String[] args)
    {
        TestRunner.run(TestJunitTest.class);
    }
}
