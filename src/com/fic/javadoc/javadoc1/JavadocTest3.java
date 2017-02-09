package com.fic.javadoc.javadoc1;

/**
 * This class inherits an interface which inturn extends one more interface
 * 
 * @author brekha
 * @version 1.0
 *
 */
public class JavadocTest3 extends JavadocTest2 implements IInherit
{
    /**
     * This is the self description <code>Junky</code>.
     * This overridden method has its own description in parent
     * 
     * @param c self parameter
     * @return a self made integer
     */
    public int test(String c)
    {
        return 0;
    }
    
    public String test (int a)
    {
        return "";
    }
}
