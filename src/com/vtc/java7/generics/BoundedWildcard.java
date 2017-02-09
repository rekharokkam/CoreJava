package com.vtc.java7.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcard
{
	/* Question mark indicates wildcard any class and extends means child of Number and Number class itself. No other class is accepted*/
	public static void printListChild (List<? extends Number> list)
	{
System.out.println(list);		
	}

	public void testPrintListChild ()
	{
		//Acceptable List
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(100);
		printListChild (numbers);
		
		//Acceptable List
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(200);
		printListChild (intList);
		
		//Unacceptable list
		List<String> strList = new ArrayList<String>();
		strList.add ("# 1");
//		printListChild (strList); Results in compile time error since String is neither Number nor extends from Number
	}
	
	/* Question mark indicates wildcard any class and super means Parent of Integer(Number) and Integer class itself. No other class is accepted*/
	public static void printListParent (List<? super Integer> list)
	{
System.out.println(list);	
	}

	public void testPrintListParent ()
	{
		//Acceptable List
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(100);
		printListParent (numbers);
		
		//Acceptable List
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(200);
		printListParent (intList);

		//Unacceptable List
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(200.99);
//		printListParent (doubleList);Results in compile time error since Double is neither Integer nor parent of Integer

		//Unacceptable list
		List<String> strList = new ArrayList<String>();
		strList.add ("# 1");
//		printListChild (strList); Results in compile time error since String is neither Integer nor parent of Integer
	}

	public static void main(String[] args)
	{
	}
}
