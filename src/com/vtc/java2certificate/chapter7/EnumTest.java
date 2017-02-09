package com.vtc.java2certificate.chapter7;

public class EnumTest
{
	enum Computer 
	{
		APPLE("Apple"), HP("Compac"), IBM("TabletPC");
		
		String computerName;
		Computer (String name)
		{
			computerName = name;
		}
		
		String getComputerName ()
		{
			return computerName;
		}
		
//		void setComputerName (String name)
//		{
//			computerName = name;
//		}
	};
	public static void main(String[] args)
	{
//		Computer macintosh = Computer.APPLE;
System.out.println("Macintosh is a type of " + Computer.APPLE.name() + " Computer");		
	}
}
