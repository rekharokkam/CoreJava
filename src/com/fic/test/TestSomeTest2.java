package com.fic.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Roopa Murthy
 */
public class TestSomeTest2
{

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(TestSomeTest2.suite());
    }

    public static Test suite()
    {
//        TestSuite suite = new TestSuite(SomeTest2.class, "For testing");
        TestSuite suite = new TestSuite("SomeTest2.class");
        suite.addTest(new SomeTest2("testAdd"));
        suite.addTest(new SomeTest2("testSub"));
        return suite;
    }
}
