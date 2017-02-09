package com.fic.mail;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 * @author brekha
 */
public class MultiPartEmailTest
{

    private EmailAttachment getPDFAttachment ()
    {
        EmailAttachment pdfAttachment = new EmailAttachment();
        pdfAttachment.setPath("E:/Rekha/Materials/Books/EJB/ejbdesignpatterns.pdf");
        pdfAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        pdfAttachment.setName("MyPdfDoc");
        pdfAttachment.setDescription("pdf desc");
        
        return pdfAttachment;
    }
    
    private EmailAttachment getPlainTextattachment ()
    {
        EmailAttachment textattachment = new EmailAttachment();
        textattachment.setPath("C:/ccviews/system.properties");
        textattachment.setDisposition(EmailAttachment.INLINE);
        textattachment.setName("MyPlainTxt.txt");
        textattachment.setDescription("plain text desc ");
        
        return textattachment;
    }
    
    private EmailAttachment getURLEmailAttachment ()
    {
        EmailAttachment urlAttachment = new EmailAttachment();
        urlAttachment.setPath("http://www.attachments.com/images/spinearth.gif");
        urlAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        urlAttachment.setName("My logo");
        urlAttachment.setDescription("Url email attachment");
        
        return urlAttachment;
    }
    
    public void getEmailWitattachments(int attachmentType)
    	throws EmailException
    {
        EmailAttachment emailAttachment = null;
        switch(attachmentType)
        {
        	case 1:
        	    emailAttachment = getPDFAttachment();
        	    break;
        	case 2:
        	    emailAttachment = getPlainTextattachment();
        	    break;
        	case 3: 
        	    emailAttachment = getURLEmailAttachment();
        	    break;
        }
        
        MultiPartEmail multipartemail = new MultiPartEmail();
        multipartemail.setHostName("smtp.firstam.com");
        multipartemail.setFrom("brekha@firstam.com");
        multipartemail.addTo("brekha@firstam.com");
//        multipartemail.addTo("arachna@firstam.com");
        multipartemail.setSubject("attachment mail");
        multipartemail.setMsg("enjoy the attachment");
        
        multipartemail.attach(emailAttachment);
        
        multipartemail.send();
    }
    
    public static void main(String[] args)
    {
        try
        {
            new MultiPartEmailTest().getEmailWitattachments(2);
        }
        catch (Exception e)
        {
System.err.println("there was an exception during the mail attachment sending");
e.printStackTrace(System.err);
        }
System.out.println("mail with the attachment sent successfully");        
    }
}
