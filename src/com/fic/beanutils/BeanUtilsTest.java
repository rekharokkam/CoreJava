package com.fic.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsTest
{
	public static void main(String[] args)
	{
		Employee employee = new Employee ("Radhika", "Mahadev");
		Employer employer = new Employer ();
		
		try
		{
			PropertyUtils.copyProperties(employer,employee);
System.out.println(employer);
		}
		catch (Exception exception)
		{
exception.printStackTrace();			
		}		
	} 
}