package com.fic.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author brekha
 */
public class SMTPMailTest
{
    private static final Properties prop = new Properties(); 

    static 
    {
        //prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.firstam.com");
        //prop.put ("mail.smtp.port", "25");
    }
    
    private void testSendMail ()
    {
        Session mailSession = Session.getDefaultInstance(prop);
        Message msg = new MimeMessage(mailSession);
        try
        {
            msg.setFrom(new InternetAddress("brekha@firstam.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("brekha@firstam.com"));
            msg.setSentDate(new Date());
            msg.setSubject("test msg from pgm");
            msg.setText("hi this is the body of the email");
            
            Transport.send(msg);            
        }
        catch (Exception e)
        {
System.err.println("there was an exception during the initial stage itself");
e.printStackTrace(System.err);
        }
        
System.out.println("Successfully sent the mail");        
        
    }
    
    private void receiveMails ()
    {
        String host = "69.87.54.5";
        String userName = "brekha";
        String password = "heidi_18";
        
        Properties props = new Properties();
//        props.put("mail.pop3.host", host);
        
        Session session = Session.getDefaultInstance(props, null);
        
        Store store = null;
        Folder folder = null;
        try
        {
            store = session.getStore("pop3");
            store.connect(host, userName, password);
            
            folder = store.getFolder("FACS");
System.out.println("after the server is successfully contacted");            
        }
        catch (Exception exception)
        {
System.err.println("there was an exception during the fetching of mails from FACS folder");
exception.printStackTrace(System.err);
if (null != exception.getStackTrace())
{
    StackTraceElement[] stackTrace = exception.getStackTrace();
    for (int i = 0; i < stackTrace.length; i++) 
    {
System.out.println(stackTrace[i].toString());        
    }
    
}
        }
        finally
        {
            if (null != store)
            {
                try
                {
                    store.close();
                }
                catch (Exception exception)
                {
System.err.println("there was an exception during the closing of store");                    
exception.printStackTrace(System.err);                    
                }
            }
            if (null != folder)
            {
                try
                {
                    folder.close(false);
                }
                catch (Exception exception)
                {
System.err.println("there was an exception during the closing of folder");                    
exception.printStackTrace(System.err);                    
                }
            }
            
        }
        
            
    }
    
    public static void main(String[] args)
    {
        new SMTPMailTest().receiveMails();
    }
}
