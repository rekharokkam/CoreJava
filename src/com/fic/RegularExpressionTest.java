package com.fic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author brekha
 * http://www.onjava.com/pub/a/onjava/2003/11/26/regex.html
 */
public class RegularExpressionTest
{
    private final static String strPattern = "cats.+dogs";
    private final static Pattern pattern = Pattern.compile(strPattern); 
        
    private static boolean exactMatchMatcher (String toBeMatched)
    {
        Matcher matcher = pattern.matcher(toBeMatched);
        return matcher.matches();
    }

    private static boolean exactMatchPattern (String toBeMatched)
    {
        return Pattern.matches("cats.?dogs", toBeMatched);        
    }

    private static void partialMatchLookingAt (String toBeMatched)
    {
        Pattern pattern1 = Pattern.compile("john");
        Matcher matcher = pattern1.matcher(toBeMatched);
        
System.out.println("THE LOOKING AT METHOD OUTPUT : " + matcher.lookingAt());
System.out.println("THE find METHOD OUTPUT : " + matcher.find());
System.out.println("THE matches METHOD OUTPUT : " + matcher.matches());
    }
    
    private static void groupTest ()
    {
        String str = "www.onjava.com";
        String regExp = "(www\\.(.+)\\.(.+))";
        
        Pattern pattern1 = Pattern.compile(regExp);
        Matcher matcher = pattern1.matcher(str);
        
System.out.println("find method : " + matcher.find());     
System.out.println("group count : " + matcher.groupCount());
System.out.println("generic group method : " + matcher.group());
System.out.println("generic start method : " + matcher.start());
System.out.println("generic end method : " + matcher.end());

System.out.println("\nfirst group method : " + matcher.group(0));
System.out.println("first start method : " + matcher.start(0));
System.out.println("first end method : " + matcher.end(0));

System.out.println("\nsecond group method : " + matcher.group(1));
System.out.println("second start method : " + matcher.start(1));
System.out.println("second end method : " + matcher.end(1));

System.out.println("\nthird group method : " + matcher.group(2));
System.out.println("third start method : " + matcher.start(2));
System.out.println("third end method : " + matcher.end(2));

    }
    
    private static void testReset()
    {
        Pattern pattern1 = Pattern.compile("john");
        Matcher matcher = pattern1.matcher("hello world");
        
System.out.println("before reset calling find : " + matcher.find());
		matcher.reset("my name is john");
		
System.out.println("after resetting calling find method : " + matcher.find());		
    }
    
    private static void testReplaceAll ()
    {
        String oldString = "my name is john." +
        					"john is also my grand father's name";
            
        Pattern pattern1 = Pattern.compile("john");
        Matcher matcher = pattern1.matcher(oldString);
System.out.println("AFTER REPLACE ALL : " + matcher.replaceAll("grisham"));        
    }

    private static void testReplaceFirst ()
    {
        String oldString = "my name is john." +
        					"john is also my grand father's name";
            
        Pattern pattern1 = Pattern.compile("john");
        Matcher matcher = pattern1.matcher(oldString);
System.out.println("AFTER REPLACE FIRST : " + matcher.replaceFirst("grisham"));        
    }
  
    private static void testSplit ()
    {
        String str = "cathy~_paul~_c";
        Pattern pattern1 = Pattern.compile("~_");
        String[] splitStrArr = pattern1.split(str);
System.out.println("THE LENGTH OF THE ARRAY : " + splitStrArr.length);

for (int i = 0; i < splitStrArr.length; i++) 
{
    System.out.println("EACH ELEMENT : " + splitStrArr[i]);
}
    }
    
    private static void testEmailValidation ()
    {
        String emailAddress = "admin@firstam.com";
        String regExp = ".+@.+\\.[a-z]+";
        
        Pattern emailPattern = Pattern.compile(regExp);
        Matcher matcher = emailPattern.matcher(emailAddress);
        
System.out.println("find method : " + matcher.find());  

		matcher.reset("admin@firstamcom.at.er.you");
System.out.println("find method after reset : " + matcher.find());		
    }
    
    private static void testFNMFileUploadFileName ()
    {
    	String fnmFileName = "a.fnm";
System.out.println(fnmFileName.matches("^.+\\.fnm"));    	
    }
    
    public static void main(String[] args)
    {
//System.out.println("THIS IS THE EXACT MATCH METHOD USING THE MATCHER CLASS : " + exactMatchMatcher("catsdogs"));        

//System.out.println("THIS IS THE EXACT MATCH METHOD USING THE PATTERN CLASS : " + exactMatchPattern("cats  dogs"));
	
		//partialMatchLookingAt ("john is my name");
        
        //groupTest();
        
        //testReset();
        
        //testReplaceAll();
        
        //testReplaceFirst();
        
        //testSplit();
        
//        testEmailValidation();    
    	
    	testFNMFileUploadFileName();
    }
}
