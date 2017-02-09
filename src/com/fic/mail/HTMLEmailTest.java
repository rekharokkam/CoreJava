package com.fic.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @author brekha
 */
public class HTMLEmailTest
{
    private void sendHTMLEmail ()
    	throws EmailException
    {
        HtmlEmail htmlEmail = new HtmlEmail();
//        htmlEmail.setHostName("smtp.firstam.com");
        htmlEmail.setHostName("PISGBLR01SXCH01.india.firstamdata.com");
        htmlEmail.setFrom("FAWS.ORS.DEV@firstam.com");
        htmlEmail.addTo("brekha@firstam.com");
        htmlEmail.setSubject("Html mail");
        htmlEmail.setHtmlMsg("<html><body><table border='2'><tr><td>HI</td></tr></table></body></html>");
        htmlEmail.setTextMsg("Your mail client does not support html format");
        
        htmlEmail.send();
    }
    
    public static void main(String[] args)
    {
        try
        {
            new HTMLEmailTest().sendHTMLEmail();
        }catch(Exception e)
        {
System.err.println("there was an email exception");
e.printStackTrace(System.err);
        }
System.out.println("mail sent successfully ");        
    }
}
