package com.fic.mail;

//import javax.mail.SendFailedException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author brekha
 */
public class SimpleEmailTest
{
    private void testSimpleEmail()
    {
        SimpleEmail simpleEmail = new SimpleEmail ();
        simpleEmail.setHostName("smtp.firstam.com");
        try
        {
	        simpleEmail.addTo("brekha@firstam.com");
//	        simpleEmail.addTo("bre@firstam.in");
	        simpleEmail.addCc("brek@firstam.com");
	        simpleEmail.setFrom("brekha@firstam.com");
	        simpleEmail.setSubject("this is the exception handling email subject 1111111");
	        simpleEmail.setMsg("this is the body of simple email");
	        simpleEmail.send();
System.out.println("sent successfully");      	        
        }
        catch (EmailException e)
        {
//System.err.println("there was an exception");
//e.printStackTrace(System.err);

            //printExceptionStackTrace((SendFailedException)e.getCause(), 1);
System.err.println(e.getMessage());
e.printStackTrace(System.err);
            
			
//exception.printStackTrace(System.err);
//			Address[] invalidAddresses = exception.getInvalidAddresses();
//			for (int i = 0; i < invalidAddresses.length; i++) 
//			{qo
//System.out.println("EACH INVALID TYPE : " + invalidAddresses[i].getType() + " , toString : " + invalidAddresses[i].toString());			    
//            }

        }
  
    }
    /*
    private void printExceptionStackTrace (SendFailedException exception, int counter)
    {
System.out.println("Counter : " + counter);
System.out.println("EXCEPTION IS : " + exception.getMessage());
		if (null != exception.getNextException())
		{
		    printExceptionStackTrace((SendFailedException)exception.getNextException(), ++counter);
		}
    }
    */
    public static void main(String[] args)
    {
        new SimpleEmailTest().testSimpleEmail();
    }
}
