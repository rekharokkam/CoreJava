package com.fic.test;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * @author Roopa Murthy
 *
 * Second test class to test test suite
 */
public class SomeTest2 extends TestCase
{
    public SomeTest2(String testCaseName)
    {
        super (testCaseName); 
System.out.println("INSIDE THE ARG CONSTRUCTOR");        
    }
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception
    {   
        super.setUp();
System.out.println("\nsetup");        
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        super.tearDown();
System.out.println("teardown");        
    }

    public void testAdd ()
    {
System.out.println("INSIDE THE TESTADD METHOD OF SOME TEST 2222222222");
    }
    
    public void testSub ()
    {
System.out.println("INSIDE THE TEST SUB METHOD OF SOME TEST 22222222222");        
    }
    public static void main(String[] args)
    {
        TestRunner.run(SomeTest2.class);
    }
}
