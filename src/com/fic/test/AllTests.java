	package com.fic.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(AllTests.suite());
    }

    public static Test suite()
    {
        //TestSuite suite = new TestSuite("Test for com.fic.test");
        //suite.addTestSuite(TestJunitTest.class);
        //suite.addTest(new SomeTest("testFirstMethod"));
        
        TestSuite suite = new TestSuite(SomeTest.class, "Some test suite");
//        suite.addTest(new SomeTest2("testSub"));
        suite.addTestSuite(SomeTest2.class);
        
//        suite.addTest(TestSomeTest2.suite());
        
        return suite;
        
    }
}
