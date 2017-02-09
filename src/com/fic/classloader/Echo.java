/*
 * Created on Jul 21, 2006
 * From the pdf E:\Rekha\Materials\Java\Basic\ClassForName.pdf.
 */
package com.fic.classloader;

public class Echo
{
    public static void main(String[] args)
    {
        if (null != args && args.length > 0)
        {
            for (int i = 0; i < args.length; i++) 
            {
System.out.println("EACH ARG : " + args[i]);                
            }
        }
    }
}
