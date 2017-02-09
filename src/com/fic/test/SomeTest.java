package com.fic.test;

import junit.framework.TestCase;
import junit.textui.TestRunner;

public class SomeTest extends TestCase
{
    public SomeTest()
    {        
    }
    
    public SomeTest(String testCaseName)
    {
        super (testCaseName);
System.out.println("\ninside the constructor of some test");		
    }
    
    public void testFirstMethod ()
    {
System.out.println("\n\ninside the test first method");
		assertEquals("this is not the correct approach", 0, 1);
    }
    
    public void testSecondMethod()
    {
System.out.println("\n\nInside the test second method ");        
    }
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {        
        super.setUp();
        throw new IllegalStateException("I threw it Wonderful Isn't");
    }
    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        // TODO Auto-generated method stub
        super.tearDown();
    }
    
    public static void main(String[] args)
    {
        TestRunner.run(SomeTest.class);
    }
}
