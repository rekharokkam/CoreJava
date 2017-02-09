package com.fic.jdk5tutorials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericsTest
{
	private void listOldType ()
	{
		List oldTypeList = new ArrayList();
		oldTypeList.add("One");
		oldTypeList.add("Two");
		oldTypeList.add(new Long(10));
		
		//Explicit cast is required
		String listElement = (String)oldTypeList.get(0);
	}
	
	private void genericsTypeList ()
	{
		/*
		 * Generics Type ensures type safety.
		 * Commented line illustrates tat
		 */
		List<String> newTypeList = new ArrayList<String>();
//		newTypeList.add(new Long(10));
		newTypeList.add("One");
		
		/*
		 * Explicit cast is not required 
		 */
		String listElement = newTypeList.get(0);
		
		/*
		 * Wrong casting are caught at the compile time
		 */
//		Long listElement2 = newTypeList.get(1);
	}
	
	private void oldTypeIterator ()
	{
		List oldTypeList = new ArrayList(2);
		oldTypeList.add("One");
		oldTypeList.add("Two");
		
		Iterator it = oldTypeList.iterator();
		while (it.hasNext())
		{
			String eachOldTypeListElement = (String)it.next();
		}
	}
	
	private void newTypeIterator ()
	{
		List<String> newTypeList = new ArrayList<String>();
		newTypeList.add("One");
		newTypeList.add("Two");
		
		Iterator<String> it = newTypeList.iterator();
		while (it.hasNext())
		{
			String eachNewTypeListElement = it.next();
		}
	}
	
	private void oldNewCombi ()
	{
		List oldType = new ArrayList();
		oldType.add("One");
		oldType.add("Two");
		Iterator<String> it = oldType.iterator();
		while (it.hasNext())
		{
			String eachOldListContent = it.next();
System.out.println(eachOldListContent);			
		}
	}

	/*
	 * Generics and Subtyping
	 */
	private void subTyping ()
	{
		List<String> ls = new ArrayList<String>();
		/*
		 * Below code is illegal because using obj any object type not only strings
		 * can be added into the list ls which causes the violation of Generics
		 * So below code causes compilation error 
		 */  
//		List<Object> obj = ls;
		
		List<Object> lObj = new ArrayList<Object>();
		//Same as above. causes violation of generics so prevents it causing 
		//compilation error
//		List<String> lstr = lObj;
	}
	
	private void printSpecificListElements (List<Number> coll)
	{
		for (Object object : coll)
		{
System.out.println("each collection element : " + object);			
		}
	}
	
	/*
	 * ? - represents Unknown
	 * List<?> - Allows any type of List to be passed.
	 * Does not confine only to Number and its subclasses.
	 * Even List of Strings can be passed to this method 
	 */
	private void printWildcardUnknownListElements (List<?> coll)
	{
		for (Object object : coll)
		{
System.out.println("each generic collection element : " + object);			
		}
	}
	
	private void testWildCardOfUnknown ()
	{
		List<Integer> lI = new ArrayList<Integer>();
		lI.add(new Integer (10));
		
		//This is incorrect because the method takes only List of Objects as input.
//		printSpecificListElements(lI);
		
		printWildcardUnknownListElements(lI);
		
		List<String> ls = new ArrayList<String>();
		ls.add("One");
		
		printWildcardUnknownListElements(ls);
		
		List<Object> lObj = new ArrayList<Object>();
		lObj.add(new Object());
		printWildcardUnknownListElements (lObj);
	}
	
	/*
	 * This method only accepts Number and its subtypes as input parameter
	 */
	private void printBoundedWildcardListElements (List<? extends Number> coll)
	{
		for (Number number : coll)
		{
System.out.println("each number element : " + number);			
		}
	}
	
	private void testBoundedWildcard ()
	{
		List<Number> lN = new ArrayList<Number>();
		printBoundedWildcardListElements (lN);
		
		List<String> ls = new ArrayList<String>();
		ls.add("One");		
		//Because the method takes only bounded wildcard the below way of calling the method is illegal
//		printBoundedWildcardListElements (ls);
		
		List<Integer> lI = new ArrayList<Integer>();
		lI.add(new Integer(10));
		printBoundedWildcardListElements (lI);
		
		List<Long> lL = new ArrayList<Long>();
		lL.add(new Long(10));
		printBoundedWildcardListElements (lL);
	}
	
	private <Number> void arrayToCollection (Number[] a, Collection<? extends Number> c)
	{
		for (Number str : a)
		{
//			c.add(str);
		}
	}
	
	public static void main(String[] args)
	{
		new GenericsTest().oldNewCombi();
	}
}