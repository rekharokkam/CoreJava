package com.concentrix.fileio;

public class FileWriteFailedException extends Exception
{
	private String errorCode;
	private String errorMessage;
	private Throwable exception;
	
	public FileWriteFailedException ()
	{
		
	}
	
	public FileWriteFailedException (String errorCode, String errorMessage)
	{
		super (errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public FileWriteFailedException (String errorCode, String errorMessage, Throwable exception)
	{
		super(errorMessage, exception);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exception = exception;
	}
	
	
	public String getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public Throwable getException()
	{
		return exception;
	}

	public void setException(Throwable exception)
	{
		this.exception = exception;
	}
}
