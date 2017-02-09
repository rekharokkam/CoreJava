package com.book.tij.chapter5;

import com.book.tij.chapter5.dessert.Cookie;

public class ChocolateChip extends Cookie 
{
	public ChocolateChip()
	{
System.out.println("INSIDE THE CHOCOLATE CHIP DEFAULT CONSTRUCTOR");		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		new ChocolateChip().bite(); //Cannot access as the method is packageaccess
	}
}
