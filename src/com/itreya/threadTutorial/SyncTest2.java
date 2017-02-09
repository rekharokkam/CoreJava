/**This example is copied directly from the tutorials
 */

package com.itreya.threadTutorial;

public class SyncTest2
{
	public int top = 0;
	public int[] values = new int[1000];

	public void push(int n) 
	{
		synchronized (values)
		{
			values[top++] = n;
		}
	  
	}

	public int pop() 
	{
		int returnValue = 0;
		synchronized (values)
		{
			returnValue = values[--top];
		}
	  return returnValue; 
	}

	public static void main (String args[])
	{
		SyncTest2 test = new SyncTest2();
		test.push(10);
		System.out.println (test.pop());
	}
	
}
