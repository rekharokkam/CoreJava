package com.junit.tests;

import junit.framework.Test;
import junit.framework.TestSuite;



public class MathTestSuite
{
	public static Test suite ()
	{
		TestSuite testSuite = new TestSuite("Math Calculation Test Suites");
		testSuite.addTestSuite(MathTest.class);
//		testSuite.addTest(new MathTest ("tAddZero"));
		
		return testSuite;
	}
}
