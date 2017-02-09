package com.fic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author brekha
 */
public class FAWSComparatorClient
{
    private List createData ()
    {
        List persons = new ArrayList();
        
        Calendar calendar = new GregorianCalendar(2004, 2, 21);
        persons.add(new Person(1, "Aman", 21, new Date()));
        persons.add(new Person(2, "Zena", 35, calendar.getTime()));
        
        return persons;
    }
    
    public void sortData()
    {
        List persons = createData();
System.out.println("before sorting : " + persons);
		Collections.sort(persons, new FAWSComparator(new String[]{"DOB"}, 1));
System.out.println("\n\nAFTER SORTING : " + persons);		
    }
    
    public static void main(String[] args)
    {
        new FAWSComparatorClient().sortData();
    }
    
    private static class Person
    {
        private String name;
        private long id;
        private int age;
        private Date DOB;
        
        public Person ()
        {            
        }
        
        public Person(long id, String name, int age, Date DOB)
        {
            this.id = id;
            this.name = name;
            this.age = age;
            this.DOB = DOB;
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
        /**
         * @return Returns the dOB.
         */
        public Date getDOB()
        {
            return DOB;
        }
        /**
         * @param dob The dOB to set.
         */
        public void setDOB(Date dob)
        {
            DOB = dob;
        }
        /**
         * @return Returns the id.
         */
        public long getId()
        {
            return id;
        }
        /**
         * @param id The id to set.
         */
        public void setId(long id)
        {
            this.id = id;
        }
        /**
         * @return Returns the name.
         */
        public String getName()
        {
            return name;
        }
        /**
         * @param name The name to set.
         */
        public void setName(String name)
        {
            this.name = name;
        }
        
        public String toString()
        {
            StringBuffer sb = new StringBuffer(2000);
            sb.append("\n");
            sb.append("id : ").append(getId()).append("\n");
            sb.append("name : ").append(getName()).append("\n");
            sb.append("age : ").append(getAge()).append("\n");
            sb.append("dob : ").append(getDOB()).append("\n");
            
            return sb.toString();
        }
    }
}
