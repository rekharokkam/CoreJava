package com.vtc.java7.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard
{
	public static void main(String[] args)
	{
		List<String> strList = new ArrayList<String>();
		strList.add("# 1");
		printList(strList);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		printList(intList);
	}
	
	/* Wildcard accepts list of any type*/
	public static void printList (List<?> list)
	{
System.out.println(list);		
	}
}
