/**this class writes object into a file (FIleOutputStream)
 */

package com.itreya.learn;

import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

class ObjectStreamTest
{
	
	/*
	//create the object by setting the value
	private static ObjectDO m_objectDO;
	
	private static ObjectDO getObjectDO ()
	{
		m_objectDO = new ObjectDO ("rekha", "1");
		return m_objectDO;
	}
	
	public static void main (String args [])
	{
		try
		{
			File file = new File (args [0]);
			
			FileOutputStream fos = new FileOutputStream (file);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			
			int ione = 10;
			
			Object oosObj = (Object)"me here" ;
			//oos.writeObject (oosObj);
			oos.writeBytes ("me here at my house please all of U come and see me here");
				
		}
		
		catch (FileNotFoundException ffe)
		{
			System.out.println ("there was file not found exception");
			ffe.printStackTrace ();
		}
		
		catch (IOException ioe)
		{
			System.out.println ("there was an IO Exception");
			ioe.printStackTrace ();
		}
		
		
			
	}
	
	*/
}