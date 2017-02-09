package com.itreya.test1;

import java.lang.* ;
import java.io.* ;

public class CMDTest
{
  public static void main(String[] args)
   {
    try
   {
		String cmd = "D:\\Program Files\\Microsoft Office\\Office\\EXCEL.EXE";
	
     Process m ;
     String S = "" ;

     m = Runtime.getRuntime().exec(cmd) ;

	 /*
     BufferedReader in = 
           new BufferedReader(new InputStreamReader(
                               m.getInputStream()));

       while((S=in.readLine()) != null)
        {
         System.out.println(S) ;
        }*/
   }
    catch(Exception ex)
    {
     ex.printStackTrace () ;
    }
  }
}

