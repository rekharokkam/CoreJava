/**This class if for testing Memory Usage
 */

package com.itreya.test;

class MemoryTest
{
	
	private final static int _size = 500;
	
	public static void main (String args[])
	{	
		
		//One approach to call GC and calculate Free Memory
		/*
		long start = java.lang.Runtime.getRuntime().freeMemory();
		System.out.println("\nthe free mrmory at the start is\t"+start+"\tBytes\n");
		
		java.lang.Runtime.getRuntime().gc();
		long end = java.lang.Runtime.getRuntime().freeMemory();
		System.out.println("\nthe free mrmory at the end is\t"+end+"\tBytes\n");
		
		long difference = end-start;
		System.out.println("\nThe difference between the start and end is\t"+difference+"\tBytes\n");
		*/
		
		
		Object arrayArr[] = new Object[_size];
		
		java.lang.Runtime.getRuntime().gc();
		long start = java.lang.Runtime.getRuntime().freeMemory();
		
		for (int i=0;i<_size;i++)
		{
			arrayArr[i] = new Object();
		}
		java.lang.Runtime.getRuntime().gc();		
		long end = java.lang.Runtime.getRuntime().freeMemory();
		
		long difference = start-end;
		
		System.out.println("\nthe free mrmory at the start is\t"+start+"\tBytes\n");
		System.out.println("\nthe free mrmory at the end is\t"+end+"\tBytes\n");
		System.out.println("\nThe difference between the start and end is\t"+difference+"\tBytes\n");
		
	}
}