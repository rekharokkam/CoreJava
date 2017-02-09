package com.book.tij.chapter4;

public class StaticDataInitialization2 
{
	static StaticDataInitialization2.Table table = new StaticDataInitialization2.Table();
	
	private static class Chair
	{
		public Chair(int i, String message)
		{
System.out.println(message + " : " + i);			
		}
		
		public void chairFunction (String message)
		{
System.out.println(message);			
		}
	}
	
	private static class Cupboard
	{
		Chair chair1 = new Chair(1, "NON - StatIC CUPBOARD CHAIR");		
		public Cupboard()
		{
System.out.println("INSIDE THE CUPBOARD CONSTRUCTOR : " );			
			chair1.chairFunction("FROM THE NON - StatIC CHAIR OBJECT OF CUPBOARD ");
			chair3.chairFunction("FROM THE StatIC CHAIR OBJECT OF CUPBOARD");
		}
		
		static Chair chair2 = new Chair(2, "StatIC CUPBOARD CHAIR");
		
		void cupboardFunction (String message)
		{
System.out.println(message);			
		}
		
		static Chair chair3 = new Chair(3, "StatIC CUPBOARD CHAIR");
	}
	
	private static class Table
	{
		static Chair chair4 = new Chair(4, "StatIC TABLE CHAIR");	
		Chair chair5 = new Chair(5, "NON - StatIC TABLE CHAIR");
		
		Table()
		{
System.out.println("INSIDE THE TABLE CONSTRCUTOR");			
			chair5.chairFunction("FROM THE NON - StatIC CHAIR OBJECT OF TABLE");
			chair6.chairFunction("FROM THE StatIC CHAIR OBJECT OF TABLE");
		}
		
//		static void tableFunction (String message)
		void tableFunction (String message)
		{
System.out.println(message);			
		}
		
		static Chair chair6 = new Chair(6, "StatIC TABLE CHAIR");
	}
	
	public static void main(String[] args) 
	{
		new Cupboard();
		new Cupboard();

		table.tableFunction("FROM THE MAIN METHOD - StatIC TABLE FUNCTION ");
		cupboard.cupboardFunction("FROM THE MAIN METHOD - StatIC CUPBOARD FUNCTION ");
		
//		Table.tableFunction("INSIDE MAIN THE TABLE FUNCTION");
	}
		
	static StaticDataInitialization2.Cupboard cupboard = new StaticDataInitialization2.Cupboard();
}
