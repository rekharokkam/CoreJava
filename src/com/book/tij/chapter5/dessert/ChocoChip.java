package com.book.tij.chapter5.dessert;

public class ChocoChip extends Cookie
{
	public ChocoChip()
	{
System.out.println("INSIDE THE CHOCOCHIP DEFAULT CONSTRUCTOR");		
	}
	
	public ChocoChip(String chocochipName)
	{
//		super(chocochipName);
System.out.println("INSIDE THE CHOCOCHIP STRING ARG CONSTRUCTOR : " + chocochipName);		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
System.out.println("INSIDE THE MAIN METHOD OF ChocoChip");		
		new ChocoChip("Kurkure").bite();
	}
}
