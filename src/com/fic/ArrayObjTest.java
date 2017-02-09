package com.fic;

/**
 * This class is for testing the ArrayObject.
 * Source - http://cretesoft.com/archive/newsletter.do?issue=124&locale=en_US
 *
 */
public class ArrayObjTest
{
    private final String name; 
    private int[] intArr;
    public ArrayObjTest(String name)
    {
        this.name = name;
        this.intArr = new int[20];
        
        //load the array first
        loadArray();
    }
    
    private void loadArray ()
    {
        //load the array first
        for (int i = 0; i < intArr.length; i++) 
        {
            intArr[i] = i;
        }
    }
    
    public static void main(String[] args)
    {
System.out.println("the name value : " + new ArrayObjTest("roopa").name);        
    }
}
