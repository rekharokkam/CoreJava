/**this class is only for testing how to run different applications from
 * The java application 
 */

package com.itreya.learn;

import java.io.*;

class CMDTest
{
	public static void main (String args[])
	{
		//String command = "setlocal set classpath=C:\\jdk1.2.1\\jre\\lib\\rt.jar applet.html endlocal";
		String command = "setlocal set classpath=C:\\jdk1.2.1\\jre\\lib\\rt.jar applet.html endlocal";
		String cmd[] = {"cmd.exe","/c",command};		
		try
		{
			Process pro = Runtime.getRuntime().exec(cmd);		
			String s = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			while((s = reader.readLine())!=null)
			{
				System.out.println(s);
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}