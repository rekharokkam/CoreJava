package com.book.tij.chapter10;

public class AssociativeArray
{
	private int index = 0;
	private Object[][] pairs;
	
	public AssociativeArray(int pairLength)
	{
		pairs = new Object[pairLength][2];
	}
	
	public void put (Object key, Object value)
	{
		if (index >= pairs.length)
		{
			throw new ArrayIndexOutOfBoundsException("array capacity is overshot");
		}
		pairs [index ++] = new Object[]{key, value};
	}
	
	public Object get(Object key)
	{
		for (int i = 0; i < pairs.length; i++)
		{
			if (pairs[i][0].equals(key))
			{
				return pairs[i][1];
			}
		}
		throw new RuntimeException("Failed to find the key");
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer(5000);
		for (int i = 0; i < pairs.length; i++)
		{
			sb.append(pairs[i][0]).append (" : ").append(pairs[i][1]);
			if (i < index - 1)
			{
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		AssociativeArray associativeArray = new AssociativeArray(3);
		associativeArray.put("Aamir", "Khan");
		associativeArray.put("Abhisheik", "Bachan");
		associativeArray.put("Akshaya", "Khanna");
		
		try
		{
			associativeArray.put("Ranbir", "Kapoor");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
//System.out.println("Array is full");			
		}
		
System.out.println(associativeArray);

System.out.println("\n" + associativeArray.get("Akshaya"));
	}
}
