package com.book.tij.chapter9;

/*
 * Every field contains 2 attributes id : value
 */
public class ExceptionChaining
{
	private Object[][] fields;
	
	public ExceptionChaining (int initialSize)
	{
		fields = new Object[initialSize][2];
		//initialise the array 
		for (int i = 0; i < fields.length; i++)
		{
			fields[i] = new Object[] {null, null};
		}
	}
	
	private void setField (String id, String value)
		throws ExceptionChainingException
	{
		if (value == null || value.equals(""))
		{
			ExceptionChainingException customException = new ExceptionChainingException ("value passed is null");
			
			//Not all exceptions have "cause" constructor. Use initCause() instead which is available in all Throwable subclasses
			customException.initCause(new NullPointerException());
			throw customException;
		}
		
		//see if the id is already availble in the array.
		int rowNumber = hasField(id);
		if (rowNumber == -1)//id is not already present
		{
			//create a new entry for the new value
			if (isArrayFull())
			{
				makeField (id);
			}
			else
			{
				for (int i = 0; i < fields.length; i++)
				{
					if (fields[i][0] == null)
					{
						fields[i][0] = id;
						break;
					}
				}
			}
		}		
		try
		{
			//set value to the Id field
			getField(id)[1] = value;
		}
		catch (NoSuchFieldException e)
		{
			/*
			 * Only Exception, RuntimeException and Error classes provide the Constructor to take "CAUSE" as the input parameter.
			 * Chaining with other exceptions can be done by using initCause() Method.
			 * Cause - is intended to be the originating exception. 
			 */
			throw new RuntimeException(e);
		}
	}
	
	private void makeField (String id)
	{
		//increase the size of the array to accomodate one more
		Object temp[][] = new Object[fields.length + 1][2];
		System.arraycopy(fields, 0, temp, 0, fields.length);
		temp[fields.length] = new Object[]{null, null};
		fields = temp;
		
		//set the value of id also
		fields[fields.length -1][0] = id;
	}
	
	private Object[] getField (String id)
		throws NoSuchFieldException
	{
		int fieldRowNumber = hasField(id);
		if (-1 == fieldRowNumber)
		{
			throw new NoSuchFieldException ("Given Id doesnt exist in the given array");			
		}
		
		return fields[fieldRowNumber];
	}
	
	private boolean isArrayFull ()
	{
		if ( (fields[fields.length - 1][0]) != null )
		{
			return true;
		}
		return false;
	}	
	
	private int hasField (String id)
	{
		for (int i = 0; i < fields.length; i++)
		{
			if (fields[i][0] != null && fields[i][0].equals(id))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		ExceptionChaining exceptionChaining = new ExceptionChaining(2);
System.out.println(exceptionChaining);
		try
		{
			exceptionChaining.setField("1", "One");
			exceptionChaining.setField("2", "Two");
			exceptionChaining.setField("3", "Three");
			exceptionChaining.setField("4", "Four");
			
			//Create ExceptionChainingException
//			exceptionChaining.setField("5", null);
			
			//Create RuntimeException
			exceptionChaining.setField(null, "Five");
		}
		catch (ExceptionChainingException e)
		{
			e.printStackTrace();
		}
		
System.out.println(exceptionChaining);		
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer(500);
		for (int i = 0; i < fields.length; i++)
		{
			sb.append("fields[").append(i).append("][0] : ").append(fields[i][0]);
			sb.append("\t");
			sb.append("fields[").append(i).append("][1] : ").append(fields[i][1]);
			sb.append("\n");
		}
		return sb.toString();
	}
}

class ExceptionChainingException extends Exception
{
	private static final long serialVersionUID = -9033612852214053383L;

	ExceptionChainingException(String msg)
	{
		super (msg);
	}
	
	ExceptionChainingException ()
	{super ();}
}

