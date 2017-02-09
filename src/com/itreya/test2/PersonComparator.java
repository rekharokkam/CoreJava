package com.itreya.test2;

import java.util.Comparator;
import java.lang.reflect.*;

public class PersonComparator implements Comparator
{
	private String m_criteria;
	private int m_Order;
	
	private static final int ASC = 0;
	private static final int DESC = 1;
	
	public PersonComparator (String a_criteria, int a_order)
	{
		m_criteria = a_criteria;
		m_Order = a_order;
	}
	
	public int compare (Object a_person, Object a_person2)
	{
		int compare = 0;
		
		if ((null != a_person) && (a_person instanceof Person)
				&& (null != a_person2) && (a_person2 instanceof Person))
		{
			Person person = (Person)a_person;
			Person person2 = (Person)a_person2;
			
			switch (m_Order)
			{
			
			case DESC :
					compare = descingSort (person, person2, compare);
					break;
				
			case ASC:				
			
			default:
					compare = ascendingSort (person, person2, compare);
					break;
			}
			
		}
		return compare;
	}
	
	private int ascendingSort (Person a_person, Person a_person2, int a_compare)
	{
		Object obj1 = getMethodValue (a_person, m_criteria);
		Object obj2 = getMethodValue (a_person2, m_criteria);
		
		Comparable value1 = null;
		Comparable value2 = null;
		
		if ((obj1 instanceof String) && (obj2 instanceof String))
		{
			String value1str = (String)obj1;
			String value2str = (String)obj2;
			
			String value11 = value1str.toLowerCase ();
			String value21 = value2str.toLowerCase();
			
			value1 = value11;
			value2 = value21;
		}
		else
		{
			value1 = (Comparable)obj1;
			value2 = (Comparable)obj2;
			
		}
		
		a_compare = ((value1.compareTo (value2) < 0) ? -1 : ((value1.compareTo (value2) > 0 ? 1 : 0)));
		return a_compare;
	}
	
	private int descingSort (Person a_person, Person a_person2, int a_compare)
	{
		Object obj1 = getMethodValue (a_person, m_criteria);
		Object obj2 = getMethodValue (a_person2, m_criteria);
		
		Comparable value1 = null;
		Comparable value2 = null;
		
		if ((obj1 instanceof String) && (obj2 instanceof String))
		{
			String value1str = (String)obj1;
			String value2str = (String)obj2;
			
			String value11 = value1str.toLowerCase ();
			String value21 = value2str.toLowerCase();
			
			value1 = value11;
			value2 = value21;
			
		}
		
		else
		{
			value1 = (Comparable)obj1;
			value2 = (Comparable)obj2;
			
		}
		
		a_compare = ((value1.compareTo (value2) < 0) ? 1 : ((value1.compareTo (value2) > 0) ? -1 : 0));
		return a_compare;
		
	}
	
	//Assumed tat the method takes no argument and returns a value
	private static Object getMethodValue (Person a_person, String a_methodName)
	{
		
		String completeMehodName = "get" + a_methodName;
		
		Object returnValue = null;
		try
		{
			Class[] methodArguments = null;
			Method method = a_person.getClass ().getDeclaredMethod (completeMehodName, methodArguments);
		
			Object[] allParameters = null;
			returnValue = method.invoke (a_person, allParameters);
		}
		catch (Exception e)
		{
			System.err.println ("AN ERROR DURING REFLECTION");
			e.printStackTrace ();
		}
		return returnValue;
		
		
	}
	
}
