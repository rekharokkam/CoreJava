package com.fic;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneTest 
{
	private static final String STORAGE_TIMEZONE = "PST8PDT";
	private static final String DISPLAY_TIMEZONE1 = "EST5EDT";
	private static final String DISPLAY_TIMEZONE2 = "CST6CDT";
	private static final String DISPLAY_TIMEZONE3 = "MST7MDT";

	private Date userCreatedDateTime;
	private Date storedDateTime;
	private Date retrievedDateTime;
	
	private Date createUserDateTime(Date date)
	{
		//create test date time with pst as the time zone
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone(STORAGE_TIMEZONE));		
//		calendar.set(2007, Calendar.MAY, 30, 13, 10);
		
System.out.println("before conversion : " + date.toString());		
		
		calendar.setTime(date);
		
//System.out.println("year : " + calendar.get(Calendar.YEAR));		
		
		return calendar.getTime();
	}
	
	private void storeUserDateTime(Date date)
	{
System.out.println("User created datetime :: " + (formatDateTime(createUserDateTime(date), STORAGE_TIMEZONE)));		
		userCreatedDateTime = createUserDateTime(date);
		
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone(STORAGE_TIMEZONE));
		calendar.setTime(userCreatedDateTime);		
		
		storedDateTime = calendar.getTime();
		
System.out.println("\nStorage date time : " + (formatDateTime(storedDateTime, STORAGE_TIMEZONE)));		
	}
	
	private String getUserDisplayDateTime(Date date)
	{
		storeUserDateTime (date);
System.out.println("\nUser retrieved date time :: " + formatDateTime(storedDateTime, STORAGE_TIMEZONE));		
		return null;
	}
	
//	private void formatTime ()
//	{
//		String[] differentTimeZone = TimeZone.getAvailableIDs();
//		
//		for(int counter = 0; counter < differentTimeZone.length; counter ++)
//		{
//System.out.println("each Id : " + differentTimeZone[counter]);			
//		}
//		
//System.out.println("\nOur default timezone : " + TimeZone.getDefault().getDisplayName());
//
//		TimeZone est = TimeZone.getTimeZone("EST");
//
//	}
	
	private static String formatDateTime (Date date, String timeZone)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy EEE hh:mm a z", Locale.US);
//		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone(timeZone));
		
//		Date today = new Date();
//System.out.println("TODAYS DATE LOCALE STRING : " + today.toLocaleString());		
//System.out.println("TODAYS DATE GMT STRING : " + today.toGMTString());
//System.out.println("TODAYS DATE TO STRING : " + today.toString());

		String formattedDateTime = format.format(date);
		
//System.out.println("AFTER FORMATTING :: " + formattedDateTime);

		return formattedDateTime;
	}
	
    public static Date getDateFromString (String dateString, String datePattern, String timeZonString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat (datePattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZonString) );
        Date date = null;

        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException eParseException)
        {
            //do nothing
        }

        return date;
    }
    /*
	private void testGregorianCalendar ()
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		TimeZone cst = TimeZone.getTimeZone("PST");
		gregorianCalendar.setTimeZone(cst);
		gregorianCalendar.set(2007, Calendar.MAY, 25, 22, 20, 20);
		
//System.out.println("date : " + (gregorianCalendar.get(Calendar.DATE)));
//System.out.println("Month : " + gregorianCalendar.get(Calendar.MONTH));
//System.out.println("year : " + gregorianCalendar.get(Calendar.YEAR));
//System.out.println("day of week : " + gregorianCalendar.get(Calendar.DAY_OF_WEEK));

System.out.println("THE DATE OBJ OF CST : " + gregorianCalendar.getTime().toString());	

		formatDateTime(gregorianCalendar.getTime());
	}
	*/
	public static void main(String[] args) 
	{
		Date date = getDateFromString("05/31/2007 10:00 AM", "MM/dd/yyyy hh:mm a", STORAGE_TIMEZONE);
		Date newDate = new TimeZoneTest().createUserDateTime(date);
		
System.out.println("User Created Date :: " + formatDateTime (newDate, DISPLAY_TIMEZONE3));		

		
	}
}
