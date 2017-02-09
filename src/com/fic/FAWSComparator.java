package com.fic;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

/**
 * @author brekha
 */
public class FAWSComparator implements Comparator
{
    private String[] m_criteria;
	private int m_order;
	
	private final static int ASC = 1;
	private final static int DESC = 2;

	/**
	 * Constructor of the comparator 
	 * @param criteria
	 * @param order
	 */
	public FAWSComparator (String[] criteria, int order)
	{
	    m_criteria = criteria;
		m_order = order;
		 
	}

    /**
     * compares 2 objects. 
     * @param firstObj first object to be compared
     * @param secondObj second object with which the first object is compared
     * @return result of comparison between the first and the second objects
     */
	public int compare (Object firstObj, Object secondObj)
	{
	    if (null != firstObj && null != secondObj)
	    {
		    for (int criteriaCounter = 0; criteriaCounter < m_criteria.length; criteriaCounter ++)
		    {
		        int comparedValue = compareEachType (firstObj, secondObj, m_criteria[criteriaCounter]);
		        
		        if (comparedValue != 0)
		        {
		            return comparedValue;
		        }
		    }
	    }
	    
	    return 0;
	}

	private int compareEachType (Object firstObj, Object secondObj, String attributeName)
	{
	    try
	    {
		    Method method1 = firstObj.getClass().getMethod(getMethodName(attributeName), null);
			Method method2 = secondObj.getClass().getMethod(getMethodName(attributeName), null);
			
			Class returnType = method1.getReturnType();
			
			Object result1 = method1.invoke(firstObj, null);
			Object result2 = method2.invoke(secondObj, null);

			if (returnType.getName().equalsIgnoreCase("java.lang.String"))
			{
				String name1 = (String) result1;
				name1 = (null == name1) ? "" : name1.toLowerCase();
				
				String name2 = (String) result2;
				name2 = (null == name2) ? "" : name2.toLowerCase();
	
				return ((m_order == ASC) ? name1.compareTo (name2) : -(name1.compareTo (name2)));
			}
			
	        else if (returnType.getName().equalsIgnoreCase("java.sql.Date"))
	        {
	            java.sql.Date date1 = (java.sql.Date)result1;
	            java.sql.Date date2 = (java.sql.Date)result2;
	            
	            return ((m_order == ASC) ? date1.compareTo(date2) : -(date1.compareTo(date2))) ;
	        }
	        
	        else if (returnType.getName().equalsIgnoreCase("java.util.Date"))
	        {
	            java.util.Date date1 = (java.util.Date)result1;
	            java.util.Date date2 = (java.util.Date)result2;
	            return ((m_order == ASC) ? date1.compareTo(date2) : -(date1.compareTo(date2))); 
	        }
		
	        else if (returnType.getName().equalsIgnoreCase("int"))
	        {
	            int id1 = ((Integer) result1).intValue();
	            int id2 = ((Integer) result2).intValue();
	            
				if (id1 != id2)
				{
				    return ((m_order == ASC) ? (id1 > id2) ? 1 : -1 : (id1 > id2) ? -1 : 1);
				}
				
				return 0;
	        }
	        else if (returnType.getName().equalsIgnoreCase("long"))
	        {
	            long id1 = ((Long) result1).longValue();
	            long id2 = ((Long) result2).longValue();
	            
	            if (id1 != id2)
	            {
	                return ((m_order == ASC) ? (id1 > id2) ? 1 : -1 : (id1 > id2) ? -1 : 1);
	            }
	            return 0;
	        }
	        else if (returnType.getName().equalsIgnoreCase("double"))
	        {
	            double id1 = ((Double) result1).doubleValue();
	            double id2 = ((Double) result2).doubleValue();
	            
	            if (id1 != id2)
	            {
	                return ((m_order == ASC) ? (id1 > id2) ? 1 : -1 : (id1 > id2) ? -1 : 1);
	            }
	            return 0;
	        }
	    }
	    catch (Exception eException)
	    {
	        //DO Nothing
	    }

	    return 0;	    
	}
	
    /**
     * returns the method name based on the criteria to be compared
     * @param methodName method by which the comparison of 2 happens
     * @return method name by which the comparison happens
     */
	private static String getMethodName (String methodName)
	{
		String firstLetter = methodName.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();		
		String secondPart = methodName.substring(1, methodName.length());
		
		return "get" + firstLetter + secondPart;
	}
}
