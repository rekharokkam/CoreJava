/**This class looks into some of the features of the HashMap class
 * There are three objects as in a dictionary.
 * Every time a word is used by the user there is an increase in the count of the particular word by one
 */

package com.itreya.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//These bean represents the word
class Word
{
	private int m_iCounter;
	
	public Word ()
	{
		m_iCounter = 0;
	}
	
	public void wordAccessed ()
	{		
		m_iCounter ++;
	}
	
	public final int getCounter ()
	{	
		return m_iCounter;
	}
}

public class Dictionary
{
	private HashMap m_hmWords = new HashMap ();
											 
	private void init ()
	{
		//Different words are added to the HashMap
		
		m_hmWords.put ("Apple", new Word ());
		m_hmWords.put ("Banana", new Word ());
		m_hmWords.put ("Carrot", new Word ());
		m_hmWords.put ("Dog", new Word ());
		m_hmWords.put ("Egg", new Word ());
	}
	
	public void useWords (String a_strWord)
	{
		Word word = (Word)m_hmWords.get (a_strWord);
		word.wordAccessed ();
	}
	
	//This displays the status of all the words in the HashMap
	public void display ()
	{
		Iterator it = m_hmWords.entrySet ().iterator ();
		while (it.hasNext ())
		{
			Map.Entry entry = (Map.Entry) it.next ();
			System.out.println ("The word " + entry.getKey () + " is accessed " + ((Word)entry.getValue ()).getCounter () + " times");
		}
		
	}
	
	public void eachEntryDisplay (String a_strWord)
	{
		Word word = (Word)m_hmWords.get (a_strWord);
		System.out.println ("The word " + a_strWord + " is accessed " + word.getCounter () + " times");
		
	}
	
	public static void main (String args [])
	{
		Dictionary test = new Dictionary ();
		test.init ();
		test.useWords ("Apple");
		test.useWords ("Dog");
		test.useWords ("Apple");
		test.useWords ("Dog");
		test.useWords ("Egg");
		
		//test.display ();
		test.eachEntryDisplay ("Egg");
			
		
		
	}
}