
package com.itreya.test2;

public class Person implements Comparable
{
	private String m_name;
	private int m_id;
	private String m_address;
	
	public Person (int a_id, String a_name, String a_address)
	{
		m_id = a_id;
		m_name = a_name;
		m_address = m_address;
	}
	
	public void setName (String a_name)
	{
		m_name = a_name;
	}
	
	public String getName ()
	{
		return m_name;
	}

	public void setId (int a_id)
	{
		m_id = a_id;
	}
	
	public int getId ()
	{
		return m_id;
	}
	public void setAddress (String a_address)
	{
		m_address = a_address;
	}
	
	public String getAddress ()
	{
		return m_address;
	}
	
	
	public boolean equals (Object a_person)
	{
		boolean isEqual = false;
		System.out.println ("Inside the equals method of Person class");
		if ( (null != a_person) && (a_person instanceof Person))  
		{
			Person person = (Person)a_person;
			if (person.getId () == this.getId ())
			{
				isEqual = true;
			}
		}
		return isEqual;			
	}
	
	
	//Ascending sort
	public int compareTo (Object a_person)
	{
		System.out.println ("INSIDE THE COMPARETO METHOD OF PERSON CLASS");
		int compare = -1;
		
		if ((null != a_person) && (a_person instanceof Person))
		{
			Person person = (Person)a_person;
			int currentId = this.getId ();
			int toBeComparedId = person.getId ();
			compare = (currentId < toBeComparedId  ? -1 : (currentId > toBeComparedId ? 1 : 0));
		}

		System.out.println ("THE VALUE TO BE COMPARED = " + compare);
		return compare;
	}
	
}
