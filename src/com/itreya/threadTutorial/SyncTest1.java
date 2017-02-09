/**
 * From the fifth chapter of Threads Ibm tutorials
 */

package com.itreya.threadTutorial;

import java.util.HashMap;
import java.util.Map;

public class SyncTest1
{
	private final Map cache = new HashMap ();
	
	public void load (Object a_key)
	{
		cache.put(a_key, a_key);
	}
	
	public void clearCache ()
	{
		synchronized (cache)
		{
			cache.clear();
		}
	}
	
	public Object getValue (Object a_key)
	{
		Object toBeRetunred = null;
		synchronized (cache)
		{
			toBeRetunred = cache.get(a_key);
			if (null == toBeRetunred)
			{
				load (a_key);
				toBeRetunred = a_key;
			}
		}
		
		return toBeRetunred;
		
	}
	
	
}
