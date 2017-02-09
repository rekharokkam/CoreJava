package com.fic.beanutils;

public class Employer
{
	private String firstName;
	private String lName;
	private String middleName;
	
	public Employer () {}
	
	public Employer (String firstName, String lastName)
	{
		this.firstName = firstName;
//		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLName()
	{
		return lName;
	}
	public void setLName(String lName)
	{
		this.lName = lName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String toString ()
	{
		return "Employer Details\n" + "\tFirst Name : " + getFirstName() + "\tMiddle Name : " + getMiddleName() + "\tLast Name : " +getLName();
	}
}
