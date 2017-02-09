/**
 * From the Sun Site
 * Java Tech tips 
 */

package com.itreya.test2;

import java.lang.reflect.*;
    
    public class DriverTest 
    {
        Class cls;
    
        Object obj;
    
        Constructor ctor;
        Object ctorargs[];
    
        Method meth;
        Object methargs[];
    
        String args[];
        int divpos;
    
        // parse input of the form:
        //
        //  classname arg1 arg2 ... 
        //   @ methodname arg1 arg2 ...
    
        public DriverTest(String a[]) 
        throws ClassNotFoundException, NoSuchMethodException 
        {
    
            args = a;
    
            // search for @ divider in input
    
            divpos = -1;
            for (int i = 0; i < args.length; i++) 
            {
                if (args[i].equals("@")) 
                {
                    divpos = i;
                    break;
                }
            }
            if (divpos < 1 || divpos + 1 == args.length) 
            {
                throw new IllegalArgumentException("bad syntax");
            }
    
            // load appropriate class 
            // and get Class object
    
            String classname = args[0];
            cls = Class.forName(classname);
    
            // find the constructor, 
            // if arguments specified for it
    
            if (divpos > 1) 
            {
                Class ptypes[] = new Class[divpos - 1];
                for (int i = 0; i < ptypes.length; i++) 
                {
                    ptypes[i] = String.class;                    
            	}
                ctor = cls.getConstructor(ptypes);
    
                // set up the constructor arguments
    
                ctorargs = new Object[divpos - 1];
                for (int i = 0; i < ctorargs.length; i++) 
                {
                    ctorargs[i] = args[i+1];
                }
            }
    
            // find the right method
    
            String methodname = args[divpos + 1];
            int firstarg = divpos + 2;
            Class ptypes[] = new Class[args.length - firstarg];
            for (int i = 0; i < ptypes.length; i++) 
            {
                ptypes[i] = String.class;
            }
            meth = cls.getMethod(methodname, ptypes);
    
            // set up the method arguments
    
            methargs = new Object[ptypes.length];
            for (int i = 0; i < methargs.length; i++) 
            {
                methargs[i] = args[firstarg + i];
            }
        }
    
        // create an object of the specified class
    
        public void createObject() 
        throws InstantiationException, IllegalAccessException, InvocationTargetException 
        {
        
            // if class has no-arg constructor, 
            // use it
    
            if (ctor == null) 
            {
                obj = cls.newInstance();
            }
    
            // otherwise use constructor with arguments
    
            else 
            {
                obj = ctor.newInstance(ctorargs);
            }
        }
    
        // call the method and display its return value
    
        public void callMethod() 
        throws IllegalAccessException, InvocationTargetException 
        {
    
            Object ret = meth.invoke(obj, methargs);
            System.out.println("return value: " + ret);
        }
    
        public static void main(String args[]) 
        {
    
            // create a NewDemo instance 
            // and call the method
    
            try 
            {
                DriverTest nd;
    
                nd = new DriverTest(args);
                nd.createObject();
                nd.callMethod();
            }
    
            // display any resulting exception
    
            catch (Exception e) 
            {
                System.out.println(e);
                System.exit(1);
            }
        }
    }
    
    
    /**
     * Different combinations of calling the same are :
     * 
     */
