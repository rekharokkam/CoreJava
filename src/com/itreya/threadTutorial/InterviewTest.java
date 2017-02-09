package com.itreya.threadTutorial;

public class InterviewTest
{
	String abc;
	
	public static void sortDescing (int[] x)
	{
		int temp = 0;
		for (int i = 0; i < (x.length-1); i++)
		{
			for (int j = (i + 1); j < x.length; j++)
			{
				if (x[j] > x[i])
				{
					temp = x[i];
					x[i] = x[j];
					x[j] = temp;					
				}
			}
		}
		
		for (int s = 0; s < x.length; s++)
		{
			System.out.println ("\n\n");
			System.out.println ("Each element = " + x[s]);
		}		
		
	}
	
	public static int greatest (int x[])
	{
		int greatest = -1;
		int tempGreatest = -1;
		
		for (int i = 0, j = (i + 1); i < (x.length-1); i++, j++)
		{
			tempGreatest = Math.max(x[i], x[j]);
			if (tempGreatest > greatest)
			{
				greatest = tempGreatest;
			}
		}
		
		return greatest;
		
	}
	
	public static void main (String args[])
	{
		//System.out.println (new InterviewTest().abc);
		Object[] obj = new Object[1000];
		System.out.println (obj[1]);
	}
}
