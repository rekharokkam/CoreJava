package com.fic.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roopa Murthy
 */
public class JunitTest
{
    private List cart;
    
    public JunitTest()
    {
        cart = new ArrayList();
    }
    
    public void addItem (Object item)
    {
        cart.add(item);
    }
    
    public List getCartItems()
    {
        return cart;
    }
    
    public int getCartItemsCount()
    {
        return cart.size();
    }
    public void exception()
    	throws IOException
    {      
        File file = new File ("");
        throw new IOException("My IO Exception");
        
    }
    
}
