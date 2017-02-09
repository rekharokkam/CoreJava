package com.fic;

/**
 * @author brekha
 * http://java.sun.com/developer/JDCTechTips/2001/tt0109.html#using
 */
public class UnHandledExceptionTest
{
    public static void main(String[] args)
    {
        ThreadGroup myGroup = new MyThreadGroup("selfCreatedGroup");
        MyThread thread = new MyThread(myGroup, "thread1");
        
        thread.start();
    }
    
    private static class MyThread extends Thread
    {
        public MyThread (ThreadGroup threadGroup, String threadName)
        {
            super (threadGroup, threadName);
        }
        
        public void run ()
        {
            int vec[] = new int[10];
            vec[10] = 12;                
        }
    }
    
    private static class MyThreadGroup extends ThreadGroup
    {
        public MyThreadGroup (String groupName)
        {
            super (groupName);
        }
        
        public void uncaughtException (Thread thread, Throwable throwable)
        {
System.err.println("THE THREAD WHICH IS DYING : " + thread.getName() + " , priority : " + thread.getPriority());            
//throwable.printStackTrace(System.err);
			super.uncaughtException(thread, throwable);
        }
    }
}
