/**
 * nslookup is a command in cmd
 */
package com.fic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author brekha
 */
public class InetAddressTest
{
    public static void main(String[] args)    	
    {
		try
		{
		    for (int counter = args.length; --counter >= 0;)
		    {
		        //InetAddress inetAddress = InetAddress.getByName(args[inetCounter]);
		        InetAddress[] inetAddress = InetAddress.getAllByName(args[counter]);
		        for (int inetCounter = inetAddress.length; --inetCounter>= 0;)
		        {		        
System.out.println("HOST NAME : " + inetAddress[inetCounter].getHostName());
System.out.println("HOST ADDRESS : " + inetAddress[inetCounter].getHostAddress());
System.out.println("CANONICAL NAME : "+ inetAddress[inetCounter].getCanonicalHostName() + "\n");
		        }
		    }
		}
		catch (UnknownHostException eUnknownHostException)
		{
System.err.println("here is the exception");
			eUnknownHostException.printStackTrace();
		}
    }
}
