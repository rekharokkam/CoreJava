/*
 * Created on Jul 21, 2006
 * From the pdf E:\Rekha\Materials\Java\Basic\ClassForName.pdf
 */
package com.fic.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClassForNameTest
{
    private String className;
    
    public ClassForNameTest(String className)
    {
        this.className = className;        
    }
    
    private Class loadClass ()
    {
        try
        {
            return Class.forName(className, true, this.getClass().getClassLoader());            
        }
        catch (ClassNotFoundException eClassNotFoundException)
        {
System.err.println("there was this class not found exception");
eClassNotFoundException.printStackTrace(System.err);
        }
        
        return null;
    }
    
    private Class[] getMethodArgs(List methodParams)
    {
        if (null != methodParams && methodParams.size() > 0)
        {
            Class[] methodArgs = new Class[methodParams.size()];
            for (int counter = 0; counter < methodParams.size(); counter ++) 
            {
                methodArgs[counter] = methodParams.get(counter).getClass();                
            }
        }
        return null;
    }
    
    public void invokeMethod (String methodName, List methodParams)
    {
        Class toBeRun = loadClass();
        if (null != toBeRun)
        {
            //gets all the class parameters as an array of class object
            Class[] methodArgs = getMethodArgs(methodParams);
            
            //get the method
            try
            {
                Method toBeCalledMethod = toBeRun.getDeclaredMethod(methodName, methodArgs);
                
                Object[] methodArgsObj = (null != methodParams && methodParams.size() > 0) 
                	? methodParams.toArray() : null;
                toBeCalledMethod.invoke(null, methodArgsObj);                
            }
            catch (NoSuchMethodException eNoSuchMethodException)
            {
eNoSuchMethodException.printStackTrace(System.err);
            }
            catch (IllegalAccessException eIllegalAccessException)
            {
eIllegalAccessException.printStackTrace(System.err);                
            }
            catch (InvocationTargetException eInvocationTargetException)
            {
eInvocationTargetException.printStackTrace(System.err);                
            }
        }
    }
    
    public static void main(String[] args)
    {
        ClassForNameTest test = new ClassForNameTest("com.fic.classloader.Echo");
        test.invokeMethod("main", null);
    }
}
