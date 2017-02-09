/*
 * Created on Sep 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author brekha
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReflectionTest
{
    private static final String DATE_CLASS = "java.util.Date";
    private static final String SQL_DATE_CLASS = "java.sql.Date";
    private static final String STRING_CLASS = "java.lang.String";
    private static final String INT_CLASS = "int";
    private static final String LONG_CLASS = "long";
    private static final String DOUBLE_CLASS = "double";
    private static final String BOOLEAN_CLASS = "boolean";
    private static final String STRING_ARRAY_CLASS = "[Ljava.lang.String;";
    
    private static void setOrderFormFromOldBean (Object oldObject, Object newObject) 
    	throws Exception
    {
	    Field[] allFields = oldObject.getClass().getDeclaredFields();
	    Method getterMethod = null;
	    Method setterMethod = null;
	    Object returnedObj = null;
	    Class[] parameterType = null;
	    Class methodReturnType = null;
	
	    //get all the getters of these fields
	    for (int fieldCounter = 0; fieldCounter < allFields.length; fieldCounter++)
	    {
	        parameterType = null;

            try
            {
                getterMethod = oldObject.getClass().getDeclaredMethod(getMethodName (allFields[fieldCounter].getName(), 1), null);
                methodReturnType = getterMethod.getReturnType();
                returnedObj = getterMethod.invoke(oldObject, null);

                if (methodReturnType.getName().equals( STRING_CLASS ))
                {
                    if (isStringValid( (String)returnedObj))
                    {
                        parameterType = new Class[]{String.class};
                    }
                }
                else if (methodReturnType.getName ().equals(STRING_ARRAY_CLASS))
                {
                    if ((null != returnedObj) && (((String[])returnedObj).length > 0))
                    {
                        parameterType = new Class[]{String[].class};
                    }
                }
                else if (methodReturnType.getName ().equals(BOOLEAN_CLASS))
                {
                    if ((null != returnedObj) && ( ((Boolean)returnedObj).booleanValue()))
                    {
                        parameterType = new Class[]{boolean.class};

                    }
                }
                if (null != parameterType)
                {
                    setterMethod =  newObject.getClass().getDeclaredMethod(getMethodName(allFields[fieldCounter].getName(), 2), parameterType);
                    setterMethod.invoke(newObject, new Object[]{returnedObj});
                }
            }
            catch (Exception e)
            {
                throw new Exception (e.getMessage());
            }
        }   
	}
    
    private static String getMethodName (String methodName, int mutatorType)
	{
		String firstLetter = methodName.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();
		String secondPart = methodName.substring(1, methodName.length());

        String mutatorTypeStr = (mutatorType == 1) ? "get" : "set";

		return mutatorTypeStr + firstLetter + secondPart;
	}    

    private static boolean isStringValid (String toBeValidated)
    {
        if (null != toBeValidated)
        {
            toBeValidated = toBeValidated.trim();
            if ( !(toBeValidated.equals("")) )
            {
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args)
    {
    }
}
