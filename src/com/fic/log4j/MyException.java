	package com.fic.log4j;

public class MyException extends Exception 
{
	public MyException (String errorCode, String errorMessage, Throwable exception)
	{
		super ("errorMessage : " + errorMessage, exception);
	}
}
