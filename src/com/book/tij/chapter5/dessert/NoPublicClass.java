package com.book.tij.chapter5.dessert;

class NoPublicClass1 
{
	public static void NoPublicClass1Function()
	{
System.out.println("INSIDE THE FUNCTION OF NoPublicClass1");		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
System.out.println("INSIDE THE MAIN OF NoPublicClass1 ACCESSING MAIN METHOD OF ChocoChip");		
		ChocoChip.main(args);
	}

}
