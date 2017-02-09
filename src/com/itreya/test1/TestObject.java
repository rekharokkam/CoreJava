/**this is a test object to test clonning
 */

package com.itreya.test1;

import java.util.HashMap;

class TestObject implements Cloneable
{
	private String m_strObjectName;
	private boolean m_isAlive;
	private HashMap m_map;
	
	public TestObject (String a_strObjectName, boolean a_isAlive, HashMap a_map)
	{
		m_strObjectName = a_strObjectName;
		m_isAlive = a_isAlive;
		m_map = a_map;
	}
	
	public TestObject ()
	{
	}
	
	public Object clone ()
	{
		try
		{
			TestObject test = (TestObject)super.clone ();
			m_map = test.getMap ();
			test.setMap ((HashMap)test.getMap ().clone ()) ;
			return test;
			
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println ("inside the catch block");
			return null;
			
		}
		
	}
	
	public void setObjectName (String a_strObjectName)
	{
		m_strObjectName = a_strObjectName;
	}
	
	public final String getObjectName ()
	{
		return m_strObjectName;
	}
	
	public void setObjectState (boolean a_isAlive)
	{
		m_isAlive = a_isAlive;
	}
	
	public final boolean getObjectState ()
	{
		return m_isAlive;
	}
	
	public void setMap (HashMap a_map)
	{
		m_map = a_map;
	}
	
	public final HashMap getMap ()
	{
		return m_map;
	}
	
}