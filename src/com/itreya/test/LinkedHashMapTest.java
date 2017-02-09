/**This class represents each object in the dictionary
 */
package com.itreya.test;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LinkedHashMapTest
{
	//static Map hash = new HashMap ();
	static Map hash = new LinkedHashMap (16,.75f, true);
	
	static void init ()
	{
		hash.put("bbb", new Counter());
		hash.put("ccc", new Counter());
		hash.put("aaa", new Counter());		
	}
	
	static void useWord (String a_strKey)
	{
		Counter counter = (Counter)hash.get(a_strKey);
		counter.increaseCounter();
	}
	
	static void displayMap ()
	{
		Iterator it = hash.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry entry = (Map.Entry) it.next();
System.out.println (entry.getKey() + "  " + entry.getValue());
		}
	}
	
	static Map copyMap (Map map)
	{
		return new LinkedHashMap (map);
	}
	
	public static void main (String args[])
	{
System.out.println("hither");	
	}
	
/*	
	public static void main (String args [])
	{
		//init ();
		
		Map treeMap = new TreeMap ();
		treeMap.put("ccc", new Counter ());
		treeMap.put("bbb", new Counter ());
		treeMap.put("aaa", new Counter ());
		treeMap.put("ddd", new Counter ());
		
		Map map1 = copyMap (treeMap);
		
		Iterator it = map1.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry entry = (Map.Entry) it.next();
System.out.println (entry.getKey() + "  " + entry.getValue());
		}
		
		//displayMap ();
		//System.out.println ("\n\n");
		
		//useWord ("aaa");
		//useWord ("bbb");
		//useWord ("ccc");
		//useWord ("aaa");
		
		//displayMap ();
		
	}
*/
	private static class Counter
	{
		private int m_iCounter;
		
		public Counter ()
		{
			m_iCounter = 0; 
		}
		
		void increaseCounter ()
		{
			m_iCounter ++;
		}
		
		final int getCounter ()
		{
			return m_iCounter;
		}
		
		public String toString ()
		{
			return Integer.toString(m_iCounter);
		}
	}
}