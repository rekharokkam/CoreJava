/**this class test looks into the clonning methods
 * If there are no object references inside the class which implements cloneable
 * then a shallow copy suffices the requirements other wise a deep copy has to be made
 */

package com.itreya.test1;

import java.util.HashMap;

class ClonningTest
{
	public static void main (String args [])
	{
		TestObject obj1 = null;
		TestObject obj2 = null;
		HashMap m_map = new HashMap ();
		m_map.put ("one", "one");
		m_map.put ("two", "two");
		
		
		try
		{
			//this is a shallow copy
			/*
			if (null == obj1)
			{
				obj1 = new TestObject ("manas", true);
				obj2 = (TestObject)obj1.clone ();			
			}
		
			obj1.setObjectName ("itreya");			
			System.out.println ("OBJ2 Name = " + obj2.getObjectName ());
			*/
			
			//deep copy
			
			if (null == obj1)
			{
				obj1 = new TestObject ("manas", true, m_map);
				obj2 = (TestObject)obj1.clone ();			
				
				obj1.getMap ().remove ("one");
				
			}
			
			System.out.println ("the OBJ2 value is " + obj2.getMap ().get ("one"));
			
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
	}
}