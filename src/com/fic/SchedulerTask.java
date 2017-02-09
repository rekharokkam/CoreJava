package com.fic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * @author brekha
 * Runs at predefined time
 */
public class SchedulerTask
{
    private File file;
    
    public SchedulerTask(String fileName)
    {
        file = new File (fileName);
    }
    
    private void run()
    {
        if (null != file)
        {
            BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter(new FileWriter(file, true) );
                writer.write("Run at : " + new Date().toString());
                writer.newLine();
                writer.flush();
            }
            catch(IOException eIOException)
            {
System.err.println("there was an exception during process of writing to file");
eIOException.printStackTrace(System.err);
            }
            finally
            {
                if (null != writer)
                {
	                try
	                {
	                    writer.close();
	                }
	                catch (IOException eIOException)
	                {
	                    //Do nothing
	                }
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
		new SchedulerTask("E:/Rekha/learning/Testing/CoreJava/scheduler/logs/schedulerLogs.log").run();
    }
}
