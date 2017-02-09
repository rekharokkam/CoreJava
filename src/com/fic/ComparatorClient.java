package com.fic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author brekha
 */
public class ComparatorClient
{

    public static void main(String[] args)
    {
        Person person1 = new Person ();
        person1.setFName("tom");
        person1.setLName("Hanks");
        person1.setAge(30);
        
        Person person2 = new Person ();
        person2.setFName("tom");
        person2.setLName("Hanks");
        person2.setAge(21);
        
        Person person3 = new Person ();
        person3.setFName("Aman");
        person3.setLName("Verma");
        person3.setAge(30);

        Person person4 = new Person ();
        person4.setFName("rahul");
        person4.setLName("roy");
        person4.setAge(45);
        
        List stars = new ArrayList (2);
        stars.add (person1);
        stars.add (person2);
        stars.add (person3);
        stars.add (person4);
        
System.out.println("Before sorting : " + stars);        
        
		String[] criteria = {"fName", "lName", "age"};
        Collections.sort(stars, new FAWSComparator(criteria , 1));
        
System.out.println("\nAfter sorting : " + stars);        
    }
    
    private static class Person 
    {
        private String fName;
        private String lName;
        private int age;
        
        public Person ()
        {
            
        }

        public Person (String fName, String lName)
        {
            this.fName = fName;
            this.lName = lName;
        }
        
        /**
         * @return Returns the fName.
         */
        public String getFName()
        {
            return fName;
        }
        /**
         * @param name The fName to set.
         */
        public void setFName(String name)
        {
            fName = name;
        }
        /**
         * @return Returns the lName.
         */
        public String getLName()
        {
            return lName;
        }
        /**
         * @param name The lName to set.
         */
        public void setLName(String name)
        {
            lName = name;
        }
        
        public String toString ()
        {
            return "First Name : " + this.getFName() + 
            	" , Last Name : " + this.getLName() + " , Age : " + this.getAge();
        }
        /**
         * @return Returns the age.
         */
        public int getAge()
        {
            return age;
        }
        /**
         * @param age The age to set.
         */
        public void setAge(int age)
        {
            this.age = age;
        }
    }
    
}
