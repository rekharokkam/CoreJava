package com.fic.log4j;

//import org.apache.log4j.Appender;
//import org.apache.log4j.ConsoleAppender;
//import org.apache.log4j.Layout;
//import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.SimpleLayout;

/**
 * @author Roopa Murthy
 * 
 * Created to test the Log4j
 * file:///D:/Materials/HTML/Java/EE/log4j/www.onjava.com/pub/a/onjava/2002/08/07/log4j2679.html?page=1
 */
public class Log4jTest
{
    final static Logger myLogger = Logger.getLogger(Log4jTest.class);    
    
    private static void getProgramLogger ()
    {
//        myLogger.setLevel(Level.WARN);
//        Appender consoleAppender = new ConsoleAppender();
//        Layout simpleLayout = new SimpleLayout();
//        consoleAppender.setLayout(simpleLayout);
//        myLogger.addAppender(consoleAppender);
        
        myLogger.warn("here is the file");
    }
    
    private static void getGenericAppender ()
    {
        PropertyConfigurator.configure("E:/Rekha/learning/Testing_Workspace/CoreJava/logs/log4j.properties");
//        myLogger.setLevel(Level.FATAL);
    }

    private static void getJdbcLogger ()
    {
        PropertyConfigurator.configure("E:/Rekha/learning/Testing_Workspace/CoreJava/logs/myJdbcLog4j.properties");
    }

    private static void getNDCLogger ()
    {
        PropertyConfigurator.configure("E:/Rekha/learning/Testing_Workspace/CoreJava/logs/ndcLog4j.properties");
//        myLogger.setLevel(Level.DEBUG);
    }

    private static void getMDCLogger ()
    {
        PropertyConfigurator.configure("E:/Rekha/learning/Testing_Workspace/CoreJava/logs/mdcLog4j.properties");
        MDC.put("MY_MDC1", "1");
        MDC.put("MY_MDC2", "22");
        MDC.put("MY_MDC3", "333");
    }

    private void startNDCStatements ()
    {
        NDC.push("1");
        NDC.push("22");
        NDC.push("333");
    }
    
    private void endNDCStatements()
    {
        NDC.pop();
    }
    
    private void testException ()    	
    	throws Exception
    {
    	throw new MyException("002", "this is a custom exception message", new NullPointerException("I am the NullPointerException"));
    }
    
    public static void main(String[] args)
    {
//      getProgramLogger();
//    	getGenericAppender ();
//    	getNDCLogger();
//    	getMDCLogger();
        
//    	new Log4jTest().startNDCStatements();
//        myLogger.fatal ("This is the FATAL message");
//        myLogger.error("This is the ERROR message");
//        myLogger.warn("This is the WARN message");        
//        myLogger.info("This is the INFO message");
//        myLogger.debug("This is the DEBUG message");
        
//        new Log4jTest().endNDCStatements();
        
        myLogger.debug ("AFTER EVERY THING IS THIS StatEMENT");
        

//        try
//        {
//            new Log4jTest().testException();
//        }
//        catch (Exception exception)
//        {
//            myLogger.error ("df" , exception);
//        }
    }
}
