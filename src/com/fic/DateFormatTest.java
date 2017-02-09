package com.fic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatTest 
{
	/*
	 * Date is available as date object. time is available in a seperate string object.
	 * Convert Both to gregorian calendar and test the output
	 */
	private void testDateFormatting()
	{
		Date date = new Date();//Already exists with only date and no time
		String timeStr = "7:30 PM";
		
		Date time = getDateFromString(timeStr, "HH:mm a");

		String dateStr = getStringFromDate(date, "yyyy-MM-dd");
		String formattedTime = getStringFromDate (time, "HH:mm");

System.out.println("FINAL DISPLAY :: " + dateStr + "T" + formattedTime);
	}	
	
	private void compareTodayWithPassedDate (String datePassed)
	{
		Calendar calendar = Calendar.getInstance();
		StringBuffer sb = new StringBuffer (100);
		sb.append(calendar.get(Calendar.DATE)).append("/").append(calendar.get(Calendar.MONTH) + 1).append("/").append(calendar.get(Calendar.YEAR));
		Date toBeComparedDate = getDateFromString(datePassed, "dd/MM/yyyy");
System.out.println("first Date : " + toBeComparedDate);
		Date today = getDateFromString(sb.toString() , "dd/MM/yyyy");
System.out.println("today : " + sb.toString() + " : " + today);		
System.out.println("compared : " + (toBeComparedDate.compareTo(today)) );		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		new DateFormatTest().testDateFormatting();
		new DateFormatTest ().compareTodayWithPassedDate("01/11/2008");
	}
	
	private Date getDateFromString(String dateString, String datePattern)
	{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat (datePattern);
        try
        {
            return simpleDateFormat.parse(dateString);
        }
        catch (ParseException eParseException)
        {
eParseException.printStackTrace(System.err);        	
        	return null;        
        }     
	}
	
	private static String getStringFromDate (Date date, String pattern)
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String formattedDateTime = format.format(date);
		return formattedDateTime;
	}
}
