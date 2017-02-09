package com.book.tij.chapter4;

public class GarbageCollector 
{

	private static class Book
	{
		boolean checkedOut;
		String name; //To find out which book
		
		public Book(boolean checkOut, String name)
		{			
			checkedOut = checkOut;
			this.name = name;
		}
		
		public void checkIn()
		{
			checkedOut= false;
		}
		
		public void finalize()
		{
System.out.println("\nINSIDE THE FINALIZE METHOD OF BOOK : " + name);
			if (checkedOut)
			{
System.out.println("there was an error in garbage collecting this instance");			
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Book book1 = new Book(true, "Harry Potter");
		book1.checkIn();
		
		new Book(true, "Sherlock Holmes");
		
		System.gc();
	}
}
