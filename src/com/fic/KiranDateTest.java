package com.fic;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KiranDateTest
{
	private static final int NUMBER_OF_DATES = 5;//Number of dates reqd
	private static final int[] range = {1, 5, 3, 2, 9}; //for creating the dates difference
	private static final DateFormat dateFormatter = DateFormat.getDateInstance();//for just printing
	private Date[] dates = new Date[NUMBER_OF_DATES];
	
	/*
	 * This method is used only for data population and may not be useful to u.
	 */
	private void populateDates ()
	{
        Calendar fiveDays = Calendar.getInstance();
        
        Date now = new Date ();
        fiveDays.setTime(now);
        
        for (int i = 0; i < NUMBER_OF_DATES; i++)
		{
        	fiveDays.add(Calendar.DATE, range[i]);
			dates[i] = fiveDays.getTime();
		}

        for (int i = 0; i < NUMBER_OF_DATES; i++)
		{
System.out.println("EACH DATE : " + dateFormatter.format(dates[i]));			
		}        
	}
	
	/*
	 * conmpares consecutive dates in the array to find out 
	 * if they are not consecutive.
	 */
	private void compareDates ()
	{
		Calendar firstDate = Calendar.getInstance();
		Calendar consecutiveDate = Calendar.getInstance();
		
		for (int i = 0; i < (dates.length-1); i++)
		{
			firstDate.setTime(dates[i]);
			consecutiveDate.setTime(dates[i]);
			consecutiveDate.add(Calendar.DATE, 1);
			
			if (consecutiveDate.getTime().compareTo(dates[i + 1]) != 0)
			{
				//missed dates
				List<Date> missingDates = getMissingDates (dates[i], dates[i + 1]);
				
				//Just for testing may not be useful to u. 
				printMissingDates (missingDates);
			}
		}
	}
	
	/*
	 * for just testing the pgm
	 */
	private void printMissingDates (List<Date> missingDates)
	{
System.out.println("\n\n------------------------------");		
		for (int i = 0; i < missingDates.size(); i++)
		{
System.out.println(dateFormatter.format(missingDates.get(i)));
		}
System.out.println("----------------------------------\n\n");		
	}
	
	/*
	 * This method gets the range of dates which are different
	 */
	private static List<Date> getMissingDates (Date firstDate, Date secondDate)
	{
		List<Date> missingDates = new ArrayList<Date>();
		Calendar firstDateCal = Calendar.getInstance();
		Calendar consecutiveDate = Calendar.getInstance();
		
		firstDateCal.setTime(firstDate);
		consecutiveDate.setTime(firstDate);
		
		consecutiveDate.add(Calendar.DATE, 1);
		while (consecutiveDate.getTime().compareTo(secondDate) != 0)
		{
			missingDates.add(consecutiveDate.getTime());
			consecutiveDate.add(Calendar.DATE, 1);
		}	
		return missingDates;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		KiranDateTest test = new KiranDateTest();
		test.populateDates();
		test.compareDates();
	}
}
