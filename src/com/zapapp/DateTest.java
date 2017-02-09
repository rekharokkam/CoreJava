/*
 * http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-dates_p.html
 */
package com.zapapp;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest
{
    public static void main(String[] args)
    	throws Exception
    {
/*
 * Different dateformat types tat can be used
 * 
        Date today = new Date ();
        
        DateFormat defaultFormat = DateFormat.getDateInstance();        
System.out.println("DEFAULT : " + defaultFormat.format(today));

		DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
System.out.println("SHORT : " + shortFormat.format(today));

		DateFormat mediumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
System.out.println("MEDIUM : " + mediumFormat.format(today));

		DateFormat longFormat = DateFormat.getDateInstance(DateFormat.LONG);
System.out.println("LONG : " + longFormat.format(today));

		DateFormat fullFormat = DateFormat.getDateInstance(DateFormat.FULL);
System.out.println("FULL : " + fullFormat.format(today));

System.out.println("GETTING DATE FROM STRING USING PARSE METHOD : " + shortFormat.parse("5/12/05"));

*/
        
/* 
 * formatting of gregorian calendar
 *      
        GregorianCalendar today = new GregorianCalendar (2005,Calendar.MAY, 12);
        Date date = today.getTime();
        DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
System.out.println("GREGORIAN CALENDAR BEING FORMATTED : " + shortFormat.format(date));

*/

/*
        GregorianCalendar gregorianCalendar1 = new GregorianCalendar (2004, Calendar.FEBRUARY, 27);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar1;
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar (2004, Calendar.FEBRUARY, 27);
        
        Date date1 = gregorianCalendar1.getTime();
        Date date2 = gregorianCalendar2.getTime();
        Date date3 = gregorianCalendar3.getTime();
        
        gregorianCalendar1.add(GregorianCalendar.YEAR, 1);
        
        DateFormat defaultFormat = DateFormat.getDateInstance();
        
System.out.println("FIRST CALENDAR  : " + defaultFormat.format(date1));        
System.out.println("SECOND CALENDAR : " + defaultFormat.format (date2));
System.out.println("THIRD CALENDAR  : " + defaultFormat.format(date3));
 

       ReviewDates reviewDates = new DateTest().new ReviewDates(new GregorianCalendar(2005, GregorianCalendar.JANUARY, 1));
       reviewDates.listDate();
*/       
        
        GregorianCalendar calendar = new GregorianCalendar ();
        GregorianCalendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) - 31);
//System.out.println(calendar.get(Calendar.DATE));        
System.out.println(calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.YEAR));        
        
    }
    
    private class ReviewDates 
    {
        private GregorianCalendar thirdDay, oneweek, oneMonth, oneQuarter, halfYearly, oneYear;
        private final int dateArrSize = 6; 
        
        public ReviewDates (GregorianCalendar gregorianCalendar)
        {
            int year = gregorianCalendar.get(GregorianCalendar.YEAR);
            int month = gregorianCalendar.get(GregorianCalendar.MONTH);
            int date = gregorianCalendar.get(GregorianCalendar.DATE);
                
            thirdDay = new GregorianCalendar (year, month, date);
            thirdDay.add(GregorianCalendar.DATE, 3);
            
            oneweek = new GregorianCalendar (year, month, date);
            oneweek.add(GregorianCalendar.DATE, 7);
            
            oneMonth = new GregorianCalendar (year, month, date);
            oneMonth.add(GregorianCalendar.MONTH, 1);
            
            oneQuarter = new GregorianCalendar (year, month, date);
            oneQuarter.add (GregorianCalendar.MONTH, 3);
            
            halfYearly = new GregorianCalendar (year, month, date);
            halfYearly.add(GregorianCalendar.MONTH, 6);
            
            oneYear = new GregorianCalendar (year, month, date);
            oneYear.add(GregorianCalendar.YEAR, 1);   
        }
        
        public ReviewDates()
        {
            this (new GregorianCalendar());
        }
        
        public void listDate ()
        {
System.out.println("REMINDERS PLANNED FOR U ARE : \n");
			DateFormat formatter = DateFormat.getDateInstance();

System.out.println("THIRD DAY REMINDER        :  " + formatter.format(thirdDay.getTime()) );
System.out.println("ONE WEEK REMINDER         :  " + formatter.format(oneweek.getTime()) );
System.out.println("ONE MONTH REMINDER        :  " + formatter.format(oneMonth.getTime()) );
System.out.println("FIRST QUARTERLY REMINDER  :  " + formatter.format(oneQuarter.getTime()) );
System.out.println("HALF YEARLY REMINDER      :  " + formatter.format(halfYearly.getTime()) );
System.out.println("YEARLY REMINDER           :  " + formatter.format(oneYear.getTime()) );

        }
        
        public GregorianCalendar[] getDates ()
        {
            return new GregorianCalendar[] {thirdDay, oneweek, oneMonth, oneQuarter, halfYearly, oneYear};
        }
    }    
}
