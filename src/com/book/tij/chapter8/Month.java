package com.book.tij.chapter8;

//avoid inheritance
public final class Month 
{
	public static final Month
		JAN = new Month ("January"),
		FEB = new Month ("Febuary"),
		MAR = new Month ("March"),
		APR = new Month ("April"),
		MAY = new Month ("May"),
		JUN = new Month ("June"),
		JUL = new Month ("July"),
		AUG = new Month ("August"),
		SEP = new Month ("Sptember"),
		OCT = new Month ("October"),
		NOV = new Month ("November"),
		DEC = new Month ("December");
	
	private String monthName;
	
	//avoid creation of instance
	private Month (String monthName)
	{
		this.monthName = monthName;
	}
	
	private static final Month[] months = {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
	
	public static final Month getMonth (int month)
	{
		return months[month - 1];
	}
	
	public String toString(){return monthName;}
	
	public static void main(String[] args) 
	{
		Month m = Month.JAN;
System.out.println((m == Month.getMonth(1)));
System.out.println(m.equals(Month.JAN));
System.out.println(Month.getMonth(3));
	}
}
