/**
 * refers to the article 
 * http://www.javaworld.com/javaqa/2001-11/01-qa-1102-singleton_p.html
 */


package com.itreya.test2;

public class LoadBalanceTest
{
	private int m_iCounter = 0;//this is only for testing purposes not for real time application
	private static final LoadBalancer loadBalancer = new LoadBalancer (); 
	private static final int s_iBalancers = 5; // number of instances of LoadBalanceTest required at any given point of time 
	
	private LoadBalanceTest (int a_iCounter)
	{
		m_iCounter = a_iCounter;
	}
	
	public int getCounter ()
	{
		return m_iCounter;
	}	

	public static LoadBalanceTest getLoadBalancerInstance ()
	{
		return loadBalancer.next ();
	}

	public static void main(String[] args)
	{
		
		for (int i = 100; --i >= 0;)
		{
			LoadBalanceTest balancer = LoadBalanceTest.getLoadBalancerInstance();
			System.out.println("Each Balancer count = " + balancer.getCounter() + "  i = " + i);	
		}
		
	}
	
	
	/*This method is used only for load balancing the LoadBalanceTest. Depending on the situation
	 * there could be more than the methods mentioned here 
	 */
	
	private static class LoadBalancer
	{
		private LoadBalanceTest[] eachLoadBalancer = new LoadBalanceTest[s_iBalancers];
		private int counter = 0;
		
		private  LoadBalancer ()
		{
			for (int i = s_iBalancers; --i >= 0;)
			{
				eachLoadBalancer[i] = new LoadBalanceTest(i);
			}
		}
		
		private LoadBalanceTest next ()
		{
			if (counter == 5)
			{
				counter = 0;
			}
			
			LoadBalanceTest eachInstance = eachLoadBalancer[counter];
			counter = eachLoadBalancer[counter].getCounter();
			counter ++;
			return eachInstance;
		}
	}
}
