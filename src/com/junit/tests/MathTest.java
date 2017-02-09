package com.junit.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.junit.source.MathCalculations;

public class MathTest extends TestCase
{
	public MathTest (String name)
	{
		super (name);
	}
	
	private MathCalculations mathCalculation;
	
	@Before
	public void setUp() throws Exception
	{
		mathCalculation = new MathCalculations();
	}

	@After
	public void tearDown() throws Exception
	{
		mathCalculation = null;
	}
	
	public void tAddZero ()
	{
		assertEquals("Add should return zero", 0, mathCalculation.add(0, 0));
	}
	
	@Test
	public void testAddNonZero ()
	{
		assertEquals("Add Should return non-zero value", 10, mathCalculation.add(5, 4));
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testIndexOutOfBounds ()
	{
		List<String> users = new ArrayList<String>();
		users.get(1);
	}
}
