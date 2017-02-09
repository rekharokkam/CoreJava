/*
 * Ref - http://docs.oracle.com/javase/1.5.0/docs/guide/language/static-import.html
 */

package com.vtc.java2certificate.chapter7;

/*
 * Import both the class and the static member of the class tat will be used frequently.
 * Use static import sparingly.
 */
import java.util.Calendar;
import static java.util.Calendar.getInstance;

public class StaticImportTest
{
	public static void main(String[] args)
	{
		Calendar calendar = getInstance();
	}
}
